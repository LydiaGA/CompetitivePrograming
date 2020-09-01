package main;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }

    boolean dfs(int[] arr, int start, boolean[] visited){
        boolean found = arr[start] == 0;
        int[] children = new int[]{start - arr[start], start + arr[start]};
        visited[start] = true;
        if(!found){
            for(int child : children){
                if(child < 0  || child > arr.length - 1 || visited[child]){
                    continue;
                }
                found = found || dfs(arr, child, visited);
            }
        }

        return found;

    }
}
