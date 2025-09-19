/*
Given an unsorted linked list. The task is to remove duplicate elements from this unsorted Linked List. When a value appears
in multiple nodes, the node which appeared first should be kept, all other duplicates are to be removed.

Constraints:
    1 <= number of nodes <= 10^6
    0 <= node->data <= 10^6
*/
package Linked_List.MediumOfSinglyLL;
import java.util.ArrayList;
import static Linked_List.MediumOfSinglyLL.ListNode.*;

public class RemoveDuplicatesFromUnsortedList {
    static ListNode optimal(ListNode head){
        ArrayList<Integer> l = new ArrayList<>();
        ListNode t1 = head;
        ListNode dummy = new ListNode(-1), t2 = dummy;
        while(t1 != null){
            if(!l.contains(t1.data)){
                l.add(t1.data);
                t2.next = t1;
                t2 = t2.next;
            }
            t1 = t1.next;
        }
        t2.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,2,4};
        ListNode head = createLL(arr);
        traversal(head);

        ListNode temp = optimal(head);
        traversal(temp);
    }
}
