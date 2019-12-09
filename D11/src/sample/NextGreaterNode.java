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
        ListNode current1 = head;
        ListNode current2 = head.next;
        boolean found;

        ArrayList<Integer> result = new ArrayList<>();

        int counter = 0;
        while (true){
            found = false;
            current2 = current1;
            while(true){
                if(current2.val > current1.val){
                    result.add(current2.val);
                    found = true;
                    break;
                }
                if(current2.next == null){
                    break;
                }
                current2 = current2.next;
            }
            counter++;

            if (!found){
                result.add(0);
            }

            if(current1.next == null){
                break;
            }

            current1 = current1.next;


        }

        int[] toReturn = new int[counter];
        for (int i = 0; i < result.size(); i++) {
            toReturn[i] = result.get(i);
        }

        return toReturn;
    }
}
