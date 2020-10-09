package Week5;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        for(int i = 0; i < stones.length; i++){
            queue.add(stones[i]);
        }


        while(queue.size() > 1){
            int large1 = queue.poll();
            int large2 = queue.poll();

            if(large1 != large2){
                queue.add(large1 - large2);
            }
        }

        if(queue.isEmpty()){
            return 0;
        }else{
            return queue.poll();
        }
    }
}
