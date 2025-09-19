/*
Given a singly linked list. The task is to remove duplicates (nodes with duplicate values) from the given list (if it exists).
Note: Try not to use extra space. The nodes are arranged in a sorted way.

Constraints:
    1 <= Number of nodes, data of nodes <= 10^5
*/
package Linked_List.MediumOfSinglyLL;
import static Linked_List.MediumOfSinglyLL.ListNode.*;

public class RemoveDuplicatesFromSortedList {
    static ListNode optimal(ListNode head){
        ListNode t1 = head;
        while (t1 != null && t1.next != null){
            ListNode t2 = t1.next;
            while (t2 != null && t1.data == t2.data) t2 = t2.next;

            t1.next = t2;
            t1 = t1.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {2,5,7,7,8,8,9,9,9,9};
        ListNode head = createLL(arr);
        traversal(head);

        ListNode temp = optimal(head);
        traversal(temp);
    }
}
