package Week3;

public class MinimumTime {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < edges.length; i++){
            if(!map.containsKey(edges[i][0])){
                map.put(edges[i][0], new ArrayList<>());
            }

            map.get(edges[i][0]).add(edges[i][1]);

            if(!map2.containsKey(edges[i][1])){
                map2.put(edges[i][1], new ArrayList<>());
            }

            map2.get(edges[i][1]).add(edges[i][0]);
        }

        return doDFS(map, map2, hasApple, visited, 0);

    }

    int doDFS(Map<Integer, List<Integer>> map1, Map<Integer, List<Integer>> map2, List<Boolean> hasApple, boolean[] visited, int start){
        int count = 0;
        visited[start] = true;
        if(map1.containsKey(start)){
            for(int i : map1.get(start)){
                if(!visited[i]){
                    count += doDFS(map1, map2, hasApple, visited, i);
                }
            }
        }

        if(map2.containsKey(start)){
            for(int i : map2.get(start)){
                if(!visited[i]){
                    count += doDFS(map1, map2, hasApple, visited, i);
                }
            }
        }

        if(start != 0 && ((!hasApple.get(start) && count > 0) || hasApple.get(start))){
            count += 2;
        }

        return count;
    }
}
