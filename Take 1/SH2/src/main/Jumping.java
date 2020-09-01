package main;

public class Jumping {
    static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        for(int i = c.length - 1; i > 0; i--){
            System.out.println(jumps + " " + i);
            if(i > 1 && c[i - 2] == 0){
                i--;
            }

            jumps++;
        }

        return jumps;

    }
}
