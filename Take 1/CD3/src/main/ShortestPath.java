package main;

import java.util.*;

public class ShortestPath {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Map<Integer, List<List<Integer>>> graph = makeGraph(n, red_edges, blue_edges);
        System.out.println(graph.toString());

        int[] result = new int[n];
        Arrays.fill(result, -1);

        List<Integer> state1 = new ArrayList<>(Arrays.asList(0, 0));
        List<Integer> state2 = new ArrayList<>(Arrays.asList(0, 1));

        Map<List<Integer>, Integer> distances = new HashMap<>();
        distances.put(state1, 0);
        distances.put(state2, 0);


        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(state1);
        queue.add(state2);

        while(!queue.isEmpty()){
            List<Integer> current = queue.remove();

            if(result[current.get(0)] == -1 || result[current.get(0)] > distances.get(current)){
                result[current.get(0)] = distances.get(current);
            }

            for(int child : graph.get(current.get(0)).get(current.get(1))){
                List<Integer> newState = new ArrayList<Integer>(Arrays.asList(child, (current.get(1) + 1) % 2));

                if(distances.get(newState) == null){
                    distances.put(newState, distances.get(current) + 1);
                    queue.add(newState);
                }
            }
        }

        System.out.println(distances.toString());
        return result;
    }

    Map<Integer, List<List<Integer>>> makeGraph(int n, int[][] red_edges, int[][] blue_edges){
        Map<Integer, List<List<Integer>>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<List<Integer>>());
            graph.get(i).add(new ArrayList<Integer>());
            graph.get(i).add(new ArrayList<Integer>());

        }

        for(int i = 0; i < red_edges.length; i++){
            graph.get(red_edges[i][0]).get(0).add(red_edges[i][1]);
        }

        for(int i = 0; i < blue_edges.length; i++){
            graph.get(blue_edges[i][0]).get(1).add(blue_edges[i][1]);
        }

        return graph;
    }
}
