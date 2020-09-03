package Week1;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode current = head;

        if (head.next == null) {
            return null;
        }

        while (current != null) {
            nodes.add(current);
            current = current.next;
        }

        for (ListNode node : nodes) {
            System.out.println(node.val);
        }

        int target = nodes.size() - n;

        if (target != 0) {
            nodes.get(target - 1).next = nodes.get(target).next;
        } else {
            head = nodes.get(1);
        }


        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
