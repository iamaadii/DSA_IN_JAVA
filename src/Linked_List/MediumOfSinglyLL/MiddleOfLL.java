/*
You are given the head of a linked list, You have to return the value of the middle node of the linked list.
    If the number of nodes is odd, return the middle node value.
    If the number of nodes is even, there are two middle nodes, so return the second middle node value.
*/
package Linked_List.MediumOfSinglyLL;
import static Linked_List.MediumOfSinglyLL.ListNode.*;

public class MiddleOfLL {
    static ListNode bruteForce(ListNode head){
        if (head == null || head.next == null)  return head;

        ListNode temp = head;
        int count = 0;
        while (temp != null){
            count += 1;
            temp = temp.next;
        }

        int mid = (count/2)+1;
        temp = head;
        while (temp != null){
            mid -= 1;
            if (mid==0) break;
            temp = temp.next;
        }
        return temp;
    }

    static ListNode optimal(ListNode head){
        if (head == null || head.next == null)  return head;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5};
        ListNode head = createLL(arr);
        ListNode temp1 = bruteForce(head);
        traversal(temp1);

        ListNode temp2 = optimal(head);
        traversal(temp2);
    }
}
