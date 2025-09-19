/*
Given a doubly linked list of n nodes sorted by values, the task is to remove duplicate nodes present in the linked list.

Constraint:
1 <= n <= 10^5
*/
package Linked_List.MediumOfDoublyLL;
import static Linked_List.MediumOfDoublyLL.ListNode.*;

public class DeleteDuplicatesFromSortedList {
    static ListNode optimal(ListNode head){
        ListNode t1 = head;
        while (t1 != null && t1.next != null){
            ListNode t2 = t1.next;
            while (t2 != null && t1.data == t2.data) t2 = t2.next;

            t1.next = t2;
            if (t2 != null) t2.prev = t1;
            t1 = t1.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,3,3,4};
        ListNode head = createLL(arr);
        traversal(head);

        ListNode temp = optimal(head);
        traversal(temp);
    }
}
