package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class NextGreaterNode {
    public static void main(String[] args) {
        ListNode input = new ListNode(1);
        ListNode second = new ListNode(9);
        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(5);
        ListNode fifth = new ListNode(1);

        input.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        System.out.println(Arrays.toString(nextLargerNodes(input)));
    }

    public static int[] nextLargerNodes(ListNode head) {
        ListNode currentOuter = head;
        ListNode currentInner;
        boolean found;

        ArrayList<Integer> result = new ArrayList<>();

        int counter = 0;
        while (true){
            found = false;
            currentInner = currentOuter;
            while(true){
                if(currentInner.val > currentOuter.val){
                    result.add(currentInner.val);
                    found = true;
                    break;
                }
                if(currentInner.next == null){
                    break;
                }
                currentInner = currentInner.next;
            }
            counter++;

            if (!found){
                result.add(0);
            }

            if(currentOuter.next == null){
                break;
            }

            currentOuter = currentOuter.next;


        }

        int[] toReturn = new int[counter];
        for (int i = 0; i < result.size(); i++) {
            toReturn[i] = result.get(i);
        }

        return toReturn;
    }
}
