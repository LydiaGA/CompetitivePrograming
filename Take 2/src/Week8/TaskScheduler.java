package Week8;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Count> queue = new PriorityQueue<>((count1, count2) -> count2.count - count1.count);
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++){
            if(!map.containsKey(tasks[i])){
                map.put(tasks[i], 1);
            }else{
                map.put(tasks[i], map.get(tasks[i]) + 1);
            }
        }

        for(char key : map.keySet()){
            queue.add(new Count(key, map.get(key)));
        }

        Map<Character, Integer> lastIndexes = new HashMap<>();
        int currentIndex = 0;
        List<Count> temp = new ArrayList<>();
        while(!queue.isEmpty()){
            Count current = queue.poll();
            if(!lastIndexes.containsKey(current.task) || currentIndex - lastIndexes.get(current.task) > n){
                lastIndexes.put(current.task, currentIndex);
                currentIndex += 1;

                current.count = current.count - 1;
                if(current.count != 0){
                    queue.add(current);
                }

                queue.addAll(temp);

                temp = new ArrayList<>();
            }else{
                temp.add(current);
            }


            if(queue.isEmpty() && !temp.isEmpty()){
                queue.addAll(temp);
                temp = new ArrayList<>();
                currentIndex += 1;
            }
        }

        return currentIndex;
    }
}

class Count{
    char task;
    int count;

    Count(char task, int count){
        this.task = task;
        this.count = count;
    }
}
