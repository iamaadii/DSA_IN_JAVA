/*
You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing,
*/
package Linked_List.MediumOfSinglyLL;
import static Linked_List.MediumOfSinglyLL.ListNode.*;

public class DeleteMiddleOfList {
    static ListNode bruteForce(ListNode head){
        if (head == null || head.next == null) return null;

        int count = 0;
        ListNode temp = head;
        while (temp != null){
            count+=1;
            temp = temp.next;
        }

        int mid = count/2;
        temp = head;
        while (temp != null){
            mid -= 1;
            if (mid == 0){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    static ListNode optimal(ListNode head){
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = createLL(arr);

//        ListNode temp1 = bruteForce(head);
//        traversal(temp1);

        ListNode temp2 = optimal(head);
        traversal(temp2);
    }
}
