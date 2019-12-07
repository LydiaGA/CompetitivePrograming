package sample;

public class MyLinkedList {

    private ListNode first;
    private ListNode tail;
    /** Initialize your data structure here. */
    public MyLinkedList() {
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int i = 0;
        ListNode current = first;
        while(true){
            ListNode next = current.next;
            if(index == i){
                return current.val;
            }
            if(current.next == null){
                break;
            }
            current = next;
            i++;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(first == null){
            first = new ListNode(val);
            tail = first;
        }else{
            ListNode newNode = new ListNode(val);
            newNode.next = first;
            first = newNode;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(first == null){
            first = new ListNode(val);
            tail = first;
        }else{
            ListNode newNode = new ListNode(val);
            tail.next = newNode;
            tail = newNode;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        int i = 0;
        ListNode current = first;
        ListNode newNode = new ListNode(val);
        if(index == 0){
            addAtHead(val);
            return;
        }
        while(true){
            ListNode next = current.next;
            if(index - 1 == i){
                current.next = newNode;
                newNode.next = next;
                if(newNode.next == null){
                    tail = newNode;
                }
                break;
            }
            if(current.next == null){
                break;
            }
            current = next;
            i++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        int i = 0;
        ListNode current = first;
        if(index == 0){
            if(first.next == null){
                first = null;
                return;
            }
            first = current.next;
            return;
        }
        while(true){
            ListNode next = current.next;
            if(next == null){
                break;
            }
            if(index - 1 == i){
                current.next = next.next;
                if(next.next == null){
                    tail = current;
                }
                next.next = null;
                break;
            }
            if(current.next == null){
                break;
            }
            current = next;
            i++;
        }
    }

    public void printList(){
        ListNode list = first;
        while(true){
            ListNode next = list.next;
            System.out.println(list.val);
            if(list.next == null){
                break;
            }
            list = next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.addAtHead(7);
//        myList.addAtHead(2);
//        myList.addAtHead(1);
//        myList.addAtIndex(3, 0);
        myList.deleteAtIndex(1);
        //myList.addAtHead(6);
       // System.out.println("-------------");
        //myList.addAtTail(4);
        myList.printList();

       // System.out.println(myList.get(4));
//        myList.addAtHead(4);
//        myList.addAtIndex(5, 0);
//        myList.addAtHead(6);

//        System.out.println("-------");
//        System.out.println(myList.get(3));
//        myList.printList();
    }
}
