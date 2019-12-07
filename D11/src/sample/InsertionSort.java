package sample;

import java.util.List;

public class InsertionSort {
    public static void main(String[] args) {
        ListNode input = new ListNode(-1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(0);

        input.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        ListNode sorted = insertionSortList(input);
        while(true){
            ListNode next = sorted.next;
            System.out.println(sorted.val);
            if(next == null){
                break;
            }
            sorted = next;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head == null){
            return null;
        }else if(head.next == null){
            return head;
        }
        ListNode current = head.next;
        ListNode sorted = new ListNode(head.val);
        ListNode sortedCurrent;
        ListNode next, sortedNext;
        boolean placed;
        int sortedIndex;
        while (true){
            next = current.next;
            sortedIndex = 0;
            sortedCurrent = sorted;
            placed = false;

            while (true){
                sortedNext = sortedCurrent.next;
                if (current.val <= sortedCurrent.val){
                    sorted = addAtIndex(sorted, sortedIndex, current);
                    placed = true;
                    break;
                }
                sortedIndex++;
                if(sortedNext == null){
                    break;
                }
                sortedCurrent = sortedNext;
            }


            if(!placed){
                sorted = addAtIndex(sorted, sortedIndex, current);
            }

            if(next == null){
                break;
            }

            current = next;
        }

        return sorted;
    }

    static ListNode addAtHead(ListNode head, ListNode newNode) {

        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }

        return head;
    }

    static ListNode addAtIndex(ListNode head, int index, ListNode newNode) {
        int i = 0;
        ListNode current = head;
        if(index == 0){
            return addAtHead(head, newNode);
        }
        while(true){
            ListNode next = current.next;
            if(index - 1 == i){
                current.next = newNode;
                newNode.next = next;
                break;
            }
            if(current.next == null){
                break;
            }
            current = next;
            i++;
        }

        return head;
    }

    public static void printList(ListNode head){
        ListNode list = head;
        while(true){
            ListNode next = list.next;
            System.out.print(list.val + " ");
            if(list.next == null){
                break;
            }
            list = next;
        }
    }

}
