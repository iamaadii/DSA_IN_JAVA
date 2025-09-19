package Linked_List.LL_1D;
import static Linked_List.LL_1D.ListNode.*;

public class DeleteOperation {
    static ListNode deleteHead(ListNode head){
        if (head==null) return null;
        head = head.next;
        return head;
    }

    static ListNode deleteTail(ListNode head){
        if (head==null || head.next == null) return null;
        ListNode temp = head;
        while (temp.next.next != null) temp=temp.next;
        temp.next = null;
        return head;
    }

    static ListNode deleteKthElement(ListNode head, int k){
        if (head==null) return null;
        else if (k == 1){
            head = head.next;
            return head;
        }

        ListNode temp = head, prev = null;
        int count = 0;
        while (temp != null){
            count++;
            if (count==k){
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    static ListNode deleteBasedOnElement(ListNode head, int element){
        if (head==null) return null;
        else if (head.data == element){
            head = head.next;
            return head;
        }

        ListNode temp = head, prev = null;
        while (temp != null){
            if (temp.data==element){
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        traversal(head);

//        head = deleteHead(head);
//        traversal(head);

//        head = deleteTail(head);
//        traversal(head);

//        head = deleteKthElement(head,4);
//        traversal(head);

        head = deleteBasedOnElement(head,50);
        traversal(head);
    }
}
