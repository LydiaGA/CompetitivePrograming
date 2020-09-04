package Week1;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode current = head;
        while(current != null){
            list.add(current.val);
            current = current.next;
        }


        for(int i = 0; i < list.size() / 2; i++){

            if(!list.get(i).equals(list.get(list.size() - (i + 1)))){
                return false;
            }
        }

        return true;
    }
}
