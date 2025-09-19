/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Constraints:
    The number of nodes in the list is 'sz'.
    1 <= sz <= 30
    0 <= Node.val <= 100
    1 <= n <= sz

*/
package Linked_List.MediumOfSinglyLL;
import static Linked_List.MediumOfSinglyLL.ListNode.*;

public class RemoveNthNodeFromEnd {
    static ListNode bruteForce(ListNode head,int n){
        ListNode temp = head;
        int size = 0;
        while (temp!=null){
            size += 1;
            temp = temp.next;
        }

        if (n==size) return head.next;

        temp = head;
        int count = 1;
        while (temp!=null){
            if (count == size-n)  {
                temp.next = temp.next.next;
                break;
            }
            count++;
            temp = temp.next;
        }
        return head;
    }


    static ListNode optimal(ListNode head,int n){
        ListNode fast = head;
        ListNode slow = head;
        for (int i=1;i<=n;i++)  fast=fast.next;

        if (fast == null) return head.next;

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        ListNode head = createLL(arr);

//        head = bruteForce(head,4);
//        traversal(head);

        head = optimal(head,5);
        traversal(head);
    }
}
