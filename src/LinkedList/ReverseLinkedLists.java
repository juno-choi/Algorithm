package LinkedList;

public class ReverseLinkedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode head = reverseList(l1);
        while (head != null){
            System.out.println(head.val);
            head =head.next;
        }
    }

    public static ListNode reverseList(ListNode current){
        ListNode prev = null;
        ListNode next = null;

        while(current != null){
            next=current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }


}
