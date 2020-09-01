package sample;

public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode input = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(5);
        ListNode fifth = new ListNode(5);

        input.next = second;
        second.next = third;
//        third.next = fourth;
//        fourth.next = fifth;

        ListNode result = deleteDuplicates(input);
        while(true){
            ListNode next = result.next;
            System.out.println(result.val);
            if(result.next == null){
                break;
            }
            result = next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode toReturn = head;
        while(true){
            ListNode next = head.next;
            if(head.next == null){
                break;
            }
            if(head.next.next == null && head.val == next.val){
                head.next = null;
                break;
            }
            if(head.val == next.val){
                deleteNode(next);
            }else{
                head = next;
            }
        }

        return toReturn;
    }

    public static void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        next.next = null;
    }
}
