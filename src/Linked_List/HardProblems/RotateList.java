/*
Given the head of a singly linked list, rotate the list to the right by k places.

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Constraints:
    The number of nodes in the list is in the range [0, 500].
    -100 <= Node.val <= 100
    0 <= k <= 2 * 10^9
*/
package Linked_List.HardProblems;
import static Linked_List.HardProblems.ListNode.*;

public class RotateList {
    static ListNode optimal(ListNode head, int k){
        if (k==0 || head == null) return head;
        ListNode temp = head,tail = head;
        int length = 1;
        while (tail.next != null){
            tail = tail.next;
            length += 1;
        }

        if (k % length == 0) return head;
        else{
            tail.next = head;
            k = k % length;
            int step = length - k;
            while (step != 1){
                step -= 1;
                temp = temp.next;
            }
            head = temp.next;
            temp.next = null;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = createLL(arr);
        traversal(head);

        ListNode res = optimal(head,2);
        traversal(res);
    }
}
