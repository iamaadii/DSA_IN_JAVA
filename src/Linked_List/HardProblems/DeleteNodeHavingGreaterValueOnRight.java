/*
Given a singly linked list, remove all nodes that have a node with a greater value anywhere to their right in the list.
Return the head of the modified linked list.

Constraints:
    1 ≤ size of linked list ≤ 10^6
    1 ≤ element of linked list ≤ 10^6
*/
package Linked_List.HardProblems;
import static Linked_List.HardProblems.ListNode.*;

public class DeleteNodeHavingGreaterValueOnRight {

    static ListNode bruteForce(ListNode head){
        ListNode dummy = new ListNode(-1),current = dummy;
        ListNode left = head;
        while(left.next != null){
            ListNode right = left.next;
            while(right != null){
                if(right.data > left.data) break;
                else right = right.next;
            }
            if(right == null){
                current.next = left;
                current = current.next;
            }
            left = left.next;
        }
        current.next = left;
        return dummy.next;
    }



    static ListNode reverse(ListNode head){
        if (head.next==null) return head;
        ListNode back = null,current = head;
        while (current!=null){
            ListNode front = current.next;
            current.next = back;
            back = current;
            current = front;
        }
        return back;
    }
    static ListNode optimal(ListNode head){
        if(head.next == null) return head;

        head = reverse(head);
        int maxSoFar = 0;
        ListNode dummy = new ListNode(-1), current = dummy;
        ListNode temp = head;
        while(temp != null){
            if(temp.data >= maxSoFar){
                maxSoFar = temp.data;
                current.next = temp;
                current = current.next;
            }
            temp = temp.next;
        }
        current.next = null;
        return reverse(dummy.next);
    }

    public static void main(String[] args) {
        int[] arr = {12,15,10,11,5,6,2,3};
        ListNode head = createLL(arr);

//        ListNode res = bruteForce(head);
//        traversal(res);

        ListNode res = optimal(head);
        traversal(res);
    }
}
