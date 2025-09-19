/*
You are given the head_ref of a doubly Linked List and a Key. Your task is to delete all occurrences of the given key if
it is present and return the new DLL.

Constraints:
    1<=Number of Nodes<=10^5
    0<=Node Value <=10^9
*/
package Linked_List.MediumOfDoublyLL;
import static Linked_List.MediumOfDoublyLL.ListNode.*;

public class DeleteAllOccurrenceOfGivenKey {
    static ListNode optimal(ListNode head, int key){
        ListNode temp = head;
        while (temp != null){
            if (temp.data==key){
                if (temp.prev == null) {
                    head = temp.next;
                    if (head != null) head.prev = null;
                }
                else if (temp.next == null) {
                    temp.prev.next = null;
                }
                else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {10,4,10,10};
        ListNode head = createLL(arr);
        traversal(head);

        ListNode temp = optimal(head,10);
        traversal(temp);
    }
}
