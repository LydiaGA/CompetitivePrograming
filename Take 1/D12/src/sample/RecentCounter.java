package sample;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> pings;
    public RecentCounter() {
        pings = new LinkedList();
    }

    public int ping(int t) {
        int untilNow = t - 3000;
        pings.add(t);
        while(pings.peek() < untilNow){
            pings.remove();
        }

        return pings.size();
    }
}
