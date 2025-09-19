/*
Given the head of a singly linked list, reverse the nodes of the list k at a time, and return the modified list.k is a positive integer
and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in
the end, should remain as it is. You may not alter the values in the list's nodes, only nodes themselves may be changed.

Constraints:
    The number of nodes in the list is n.
    1 <= k <= n <= 5000
    0 <= Node.val <= 1000
*/
package Linked_List.HardProblems;
import static Linked_List.HardProblems.ListNode.*;

public class ReverseNodesIn_K_Groups {
    static ListNode findKth(ListNode temp, int k){
        while (temp != null && k != 1){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    static void reverse(ListNode head){
        if (head==null || head.next==null) return;
        ListNode back = null,current = head;
        while (current!=null){
            ListNode front = current.next;
            current.next = back;
            back = current;
            current = front;
        }
    }

    static ListNode optimal(ListNode head, int k){
        ListNode temp = head, prevNode = null, nextNode;
        while (temp != null) {
            ListNode kth = findKth(temp, k);
            if (kth == null){
                if (prevNode != null) prevNode.next = temp;
                break;
            }
            nextNode = kth.next;
            kth.next = null;
            reverse(temp);
            if (temp == head)  head = kth;
            else prevNode.next = kth;

            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ListNode head = createLL(arr);
        traversal(head);

        ListNode temp = optimal(head,3);
        traversal(temp);
    }
}
