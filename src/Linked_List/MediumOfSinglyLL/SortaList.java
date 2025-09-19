/*
Given the head of a linked list, return the list after sorting it in ascending order.

Constraints:
    The number of nodes in the list is in the range [0, 5 * 10^4].
    -10^5 <= Node.val <= 10^5
*/
package Linked_List.MediumOfSinglyLL;

import java.util.ArrayList;
import java.util.Collections;
import static Linked_List.MediumOfSinglyLL.ListNode.*;

public class SortaList {
    static ListNode bruteForce(ListNode head){
        ArrayList<Integer> l = new ArrayList<>();
        ListNode temp = head;
        while (temp != null){
            l.add(temp.data);
            temp = temp.next;
        }
        Collections.sort(l);

        temp = head;
        for (int e: l){
            temp.data = e;
            temp = temp.next;
        }
        return head;
    }




    static ListNode merge(ListNode head1, ListNode head2){
        ListNode t1 = head1, t2 = head2;
        ListNode dummy = new ListNode(-1), current = dummy;
        while (t1 != null && t2 != null){
            if (t2.data < t1.data){
                current.next = t2; current = current.next;
                t2 = t2.next;
            }
            else{
                current.next = t1; current = current.next;
                t1 = t1.next;
            }
        }
        if (t1 != null) current.next = t1;
        if (t2 != null) current.next = t2;

        return dummy.next;
    }
    static ListNode optimal(ListNode head){
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;
        ListNode sorted1 = optimal(left);
        ListNode sorted2 = optimal(right);
        return merge(sorted1,sorted2);
    }

    public static void main(String[] args) {
        int[] arr = {54,15,25,8};
        ListNode head = createLL(arr);

//        head = bruteForce(head);
//        traversal(head);

        head = optimal(head);
        traversal(head);
    }
}
