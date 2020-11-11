package Week4;

import java.util.*;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> level = new HashMap<>();

        String start = "0000";
        if(deadendSet.contains(start)){
            return -1;
        }
        queue.add(start);
        level.put(start, 0);

        int[][] moves = new int[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}, {-1, 0, 0, 0},
                {0, -1, 0, 0}, {0, 0, -1, 0}, {0, 0, 0, -1}};

        while(!queue.isEmpty()){
            String current = queue.remove();
            if(current.equals(target)){
                return level.get(current);
            }

            for(int[] move : moves){
                String child = getChild(current.charAt(0), move[0]) + getChild(current.charAt(1), move[1]) +
                        getChild(current.charAt(2), move[2]) + getChild(current.charAt(3), move[3]);

                if(!deadendSet.contains(child) && !level.containsKey(child)){
                    queue.add(child);
                    level.put(child, level.get(current) + 1);
                }
            }
        }

        return -1;


    }

    String getChild(char p, int move){
        int parent = Character.getNumericValue(p);
        return parent == 0 && move == -1 ? "9" : parent == 9 && move == 1 ? "0" : parent + move + "";
    }
}
