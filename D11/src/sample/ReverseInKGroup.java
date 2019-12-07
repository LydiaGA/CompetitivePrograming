package sample;

public class ReverseInKGroup {
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

        ListNode reversed = reverseKGroup(input, 2);
        while(true){
            ListNode next = reversed.next;
            System.out.println(reversed.val);
            if(reversed.next == null){
                break;
            }
            reversed = next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        return head;
    }

    public static ListNode reverseList(ListNode head) {

        ListNode next;

        ListNode reversed = new ListNode(head.val);
        reversed.next = null;

        head = head.next;

        while (true){
            next = head.next;
            head.next = reversed;
            reversed = head;

            if(next == null){
                break;
            }

            head = next;
        }

        return reversed;
    }

}
