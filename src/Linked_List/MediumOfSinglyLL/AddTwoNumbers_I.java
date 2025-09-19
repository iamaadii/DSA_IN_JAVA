/*
Given the heads of two non-empty linked lists representing two non-negative integers. The digits are stored in
reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
*/

package Linked_List.MediumOfSinglyLL;
import static Linked_List.MediumOfSinglyLL.ListNode.*;

public class AddTwoNumbers_I {

    static ListNode optimal(ListNode head1, ListNode head2){
        ListNode t1 = head1, t2 = head2;
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        int carry = 0;

        while (t1 != null || t2 != null){
            int total = carry;
            if (t1 != null) {
                total += t1.data;
                t1 = t1.next;
            }
            if (t2 != null) {
                total += t2.data;
                t2 = t2.next;
            }
            current.next = new ListNode(total%10);
            current = current.next;
            carry = total/10;
        }
        if (carry>0) current.next = new ListNode(carry);
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {3,5};
        ListNode head1 = createLL(arr1);
        int[] arr2 = {4,5,9,9};
        ListNode head2 = createLL(arr2);

        ListNode head = optimal(head1,head2);
        traversal(head);
    }
}
