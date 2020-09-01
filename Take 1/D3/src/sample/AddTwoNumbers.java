package sample;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode input1 = new ListNode(1);
//        ListNode input1_2 = new ListNode(8);
//        ListNode input1_3 = new ListNode(6);
//
//        input1.next = input1_2;
//        input1_2.next = input1_3;

        ListNode input2 = new ListNode(9);
        ListNode input2_2 = new ListNode(9);
//        ListNode input2_3 = new ListNode(4);
//        ListNode input2_4 = new ListNode(5);
//
        input2.next = input2_2;
//        input2_2.next = input2_3;
//        input2_3.next = input2_4;

        ListNode result = addTwoNumbers(null, input2);
        while(true){
            ListNode next = result.next;
            System.out.println(result.val);
            if(next == null){
                break;
            }
            result = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null ){
            l1 = new ListNode(0);
        }else if(l2 == null){
            l2 = new ListNode(0);
        }
        int carry = 0;
        ListNode currentL1 = l1.next, currentL2 = l2.next;
        ListNode resultHead = new ListNode((carry + l1.val + l2.val) % 10);
        carry = (carry + l1.val + l2.val) / 10;
        ListNode currentResult = resultHead;

        while(true){
            if(currentL1 == null && currentL2 == null){
                if(carry != 0){
                    currentResult.next = new ListNode(carry);
                }
                break;
            }else if(currentL1 == null){
                currentResult.next = new ListNode ((carry + currentL2.val) % 10);
                carry = (carry + currentL2.val) / 10;


                currentL2 = currentL2.next;
            }else if(currentL2 == null){
                currentResult.next = new ListNode ((carry + currentL1.val) % 10);
                carry = (carry + currentL1.val) / 10;
                currentL1 = currentL1.next;
            }else{
                currentResult.next = new ListNode ((carry + currentL1.val + currentL2.val) % 10);
                carry = (carry + currentL1.val + currentL2.val) / 10;
                currentL1 = currentL1.next;
                currentL2 = currentL2.next;
            }

            currentResult = currentResult.next;
        }

        return resultHead;
    }

}
