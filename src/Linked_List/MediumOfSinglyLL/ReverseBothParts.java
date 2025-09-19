/*
Given a linked list and a number k. You have to reverse the first part of the linked list with k nodes and the second
part with n-k nodes.

Input: Linked list: 1 -> 2 -> 3 -> 4 -> 5,  k = 2
Output: 2 -> 1 -> 5 -> 4 -> 3

Constraints:
    1 <= size of linked list <= 10^6
    1 <= node->data <= 10^6
    1 <= k < size of linked list
*/
package Linked_List.MediumOfSinglyLL;
import static Linked_List.MediumOfSinglyLL.ListNode.*;

public class ReverseBothParts {
    static ListNode findKth(ListNode temp, int k){
        while (temp != null && k != 1){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    static ListNode reverse(ListNode head){
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
    static ListNode optimal(ListNode head,int k){
        ListNode temp = head;
        ListNode kth = findKth(temp,k);
        ListNode nextNode = kth.next;
        kth.next = null;
        head = reverse(temp);

        ListNode prev = temp;
        temp = nextNode;

        temp = reverse(temp);
        prev.next = temp;

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
