/*
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with
even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.

Constraints:
The number of nodes in the linked list is in the range [0, 104].
-106 <= Node.val <= 106
*/
package Linked_List.MediumOfSinglyLL;
import java.util.ArrayList;
import static Linked_List.MediumOfSinglyLL.ListNode.*;

public class Odd_Even_LL {
    static ListNode bruteForce(ListNode head){
        if (head==null || head.next==null) return head;

        ListNode temp = head;
        ArrayList<Integer> l = new ArrayList<>();
        while (temp != null && temp.next != null){
            l.add(temp.data);
            temp = temp.next.next;
        }
        if (temp!= null) l.add(temp.data);

        temp = head.next;
        while (temp != null && temp.next != null){
            l.add(temp.data);
            temp = temp.next.next;
        }
        if (temp!= null) l.add(temp.data);

        temp = head;
        int i = 0;
        while ( temp != null && i<l.size() ){
            temp.data = l.get(i);
            i++;
            temp = temp.next;
        }
        return head;
    }

    static ListNode optimal(ListNode head){
        if (head==null || head.next==null) return head;

        ListNode evenHead = head.next;
        ListNode odd = head, even = head.next;
        while (even!= null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ListNode head = createLL(arr);

        head = bruteForce(head);
        traversal(head);

//        head = optimal(head);
//        traversal(head);
    }
}
