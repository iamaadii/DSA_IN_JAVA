package Linked_List.MediumOfSinglyLL;
import java.util.Stack;
import static Linked_List.MediumOfSinglyLL.ListNode.*;

public class ReverseList {

    static ListNode bruteForce(ListNode head){
        if (head==null || head.next==null) return head;

        ListNode temp = head;
        Stack<Integer> s = new Stack<>();

        while (temp!=null){
            s.add(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp!=null){
            temp.data = s.pop();
            temp = temp.next;
        }
        return head;
    }

    static ListNode optimal1(ListNode head){
        if (head==null || head.next==null) return head;

        ListNode back = null,current = head;
        while (current!=null){
            ListNode front = current.next;
            current.next = back;
            back = current;
            current = front;
        }
        return back;
    }

    static ListNode optimal2(ListNode head){
        if (head==null || head.next == null) return head;
        ListNode newHead = optimal2(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        ListNode head = createLL(arr);
        traversal(head);

//        head = bruteForce(head);
//        traversal(head);

//        head = optimal1(head);
//        traversal(head);

        head = optimal2(head);
        traversal(head);
    }
}
