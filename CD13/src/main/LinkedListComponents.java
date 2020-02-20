package main;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> gSet = new HashSet<>();
        for(int i = 0; i < G.length; i++){
            gSet.add(G[i]);
        }

        int count = 0;
        ListNode current = head;
        boolean connected = false;

        while(true){
            System.out.println(current.val);
            if(!gSet.contains(current.val) && connected){
                count++;
                connected = false;
            }else if(gSet.contains(current.val)){
                connected = true;
            }

            if(current.next == null){
                break;
            }

            current = current.next;
        }

        if(connected){
            count++;
        }

        return count;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
