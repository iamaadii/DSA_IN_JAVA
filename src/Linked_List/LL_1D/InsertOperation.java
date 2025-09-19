package Linked_List.LL_1D;
import static Linked_List.LL_1D.ListNode.*;

public class InsertOperation {
    static ListNode insertHead(ListNode head, int element){
        ListNode temp = new ListNode(element);
        temp.next = head;
        return temp;
    }

    static ListNode insertTail(ListNode head, int element){
        ListNode new_node = new ListNode(element);
        if (head==null) return new_node;

        ListNode temp = head;
        while (temp.next != null) temp=temp.next;
        temp.next = new_node;
        return head;
    }

    static ListNode insertAtKthPosition(ListNode head, int element, int k){
        ListNode new_node = new ListNode(element);
        if(head==null) {
            if (k==1)  return new_node;
        }
        if (k==1) {
            new_node.next = head;
            return new_node;
        }

        int count = 2;
        ListNode temp = head;
        while (temp != null){
            if (count == k){
                new_node.next = temp.next;
                temp.next = new_node;
                break;
            }
            count++;
            temp = temp.next;
        }
        return head;
    }

    static ListNode insertBeforeValue(ListNode head, int element, int value){
        ListNode new_node = new ListNode(element);
        if(head==null) return null;
        if (head.data == value) {
            new_node.next = head;
            return new_node;
        }

        ListNode temp = head;
        while (temp.next != null){
            if (temp.next.data == value){
                new_node.next = temp.next;
                temp.next = new_node;
                break;
            }
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

//        head = insertHead(head,67);
//        traversal(head)
//
//        head = insertTail(head,23);
//        traversal(head);

//        head = insertAtKthPosition(head,45,5);
//        traversal(head);

        head = insertBeforeValue(head,78,50);
        traversal(head);
    }
}
