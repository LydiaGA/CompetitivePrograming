package sample;

public class DeleteNode {
    public static void main(String[] args) {
        ListNode input = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        input.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        deleteNode(third);

        while(true){
            ListNode next = input.next;
            System.out.println(input.val);
            if(input.next == null){
                break;
            }
            input = next;
        }

    }

    public static void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        next.next = null;
    }
}
