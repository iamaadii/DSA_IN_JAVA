/*
You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the
number formed by concatenating all the list node numbers together and return the head of the modified linked list.

Constraints:
    1 <= len(list) <= 105
    0 <= list[i] <= 9
*/
package Linked_List.MediumOfSinglyLL;
import static Linked_List.MediumOfSinglyLL.ListNode.*;

public class Add1ToaNumberRepresentedByLL {
    static ListNode reverse(ListNode head){
        ListNode back = null, current = head;
        while (current != null){
            ListNode front = current.next;
            current.next = back;
            back = current;
            current = front;
        }
        return back;
    }
    static ListNode bruteForce(ListNode head){
        head = reverse(head);
        ListNode temp = head;
        int carry = 1;
        while (temp != null){
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum/10;
            if (carry == 0) break;
            temp = temp.next;
        }
        head = reverse(head);
        if (carry != 0) {
            ListNode t = new ListNode(carry,head);
            head = t;
        }
        return head;
    }

    static int helper(ListNode head){
        if (head == null) return 1;

        int carry = helper(head.next);
        int sum = head.data + carry;
        head.data = sum % 10;
        return sum/10;
    }

    static ListNode optimal(ListNode head){
        int carry = helper(head);
        if (carry != 0){
            ListNode temp = new ListNode(carry,head);
            head = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {9,9,9};
        ListNode head = createLL(arr);

//        head = bruteForce(head);
//        traversal(head);

        head = optimal(head);
        traversal(head);
    }
}
