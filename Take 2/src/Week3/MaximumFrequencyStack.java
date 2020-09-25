package Week3;

import java.util.*;

public class MaximumFrequencyStack {
    Map<Integer, Integer> map1;
    List<Set<Integer>> list;
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MaximumFrequencyStack() {
        map1 = new HashMap<>();
        list = new ArrayList<>(Arrays.asList(new HashSet<>()));
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if(!map1.containsKey(x)){
            map1.put(x, 0);
        }

        int previous = map1.get(x);

        map1.replace(x, previous + 1);

        if(list.size() != 0 && list.get(previous) != null){
            list.get(previous).remove(x);
        }

        if(list.size() <= previous + 1 || list.get(previous + 1) == null){
            list.add(new HashSet<>());
        }

        list.get(previous + 1).add(x);

        stack1.push(x);
    }

    public int pop() {
        int max = list.size() - 1;
        while(list.get(max).isEmpty()){
            max -= 1;
        }

        int result = -1;
        int current = stack1.pop();
        while(!list.get(max).contains(current)){
            stack2.push(current);
            current = stack1.pop();
        }



        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        list.get(max).remove(current);
        if(max != 1){
            list.get(max - 1).add(current);
        }
        map1.replace(current, map1.get(current) - 1);


        return current;
    }
}
