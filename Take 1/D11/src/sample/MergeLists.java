package sample;

import java.util.List;

public class MergeLists {
    public static void main(String[] args) {
        ListNode input1 = new ListNode(1);
        ListNode input1_2 = new ListNode(2);
        ListNode input1_3 = new ListNode(4);

        input1.next = input1_2;
        input1_2.next = input1_3;

        ListNode input2 = new ListNode(1);
        ListNode input2_2 = new ListNode(3);
        ListNode input2_3 = new ListNode(4);
        ListNode input2_4 = new ListNode(5);

        input2.next = input2_2;
        input2_2.next = input2_3;
        input2_3.next = input2_4;

        ListNode merged = mergeTwoLists(null, input2);
        while(true){
            ListNode next = merged.next;
            System.out.println(merged.val);
            if(merged.next == null){
                break;
            }
            merged = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merged;

        if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }

        if(l1.val <= l2.val){
            merged = l1;
            l1 = l1.next;
        }else{
            merged = l2;
            l2 = l2.next;
        }

        ListNode toReturn = merged;

        while(true){

            if(l1 == null && l2 == null){
                break;
            }else if(l1 == null){
                merged.next = l2;
                l2 = l2.next;
                merged = merged.next;
                continue;
            }else if(l2 == null){
                merged.next = l1;
                l1 = l1.next;
                merged = merged.next;
                continue;
            }

            if(l1.val <= l2.val){
                merged.next = l1;
                l1 = l1.next;
                merged = merged.next;
            }else{
                merged.next = l2;
                l2 = l2.next;
                merged = merged.next;
            }
        }

        return toReturn;

    }
}
