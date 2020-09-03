package Week1;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    boolean hasCycle(SinglyLinkedListNode head) {
        Set<SinglyLinkedListNode> set = new HashSet<>();

        while(head != null){
            if(set.contains(head)){
                return true;
            }else{
                set.add(head);
            }

            head = head.next;
        }

        return false;

    }
}

class SinglyLinkedListNode {
    int val;
    SinglyLinkedListNode next;
    SinglyLinkedListNode() {}
    SinglyLinkedListNode(int val) { this.val = val; }
    SinglyLinkedListNode(int val, SinglyLinkedListNode next) { this.val = val; this.next = next; }
}

