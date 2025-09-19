/*
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Constraints:
    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9
*/
package Linked_List.MediumOfSinglyLL;
import java.util.Stack;
import static Linked_List.MediumOfSinglyLL.ListNode.*;

public class CheckGivenLL_IsPalindrome {

    static Boolean bruteForce(ListNode head){
        if (head==null || head.next == null) return true;

        ListNode temp = head;
        Stack<Integer> s = new Stack<>();
        while (temp!=null){
            s.add(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (temp != null){
            if (s.pop() != temp.data) return false;
            temp = temp.next;
        }
        return true;
    }


    static ListNode reverse(ListNode head){
        if (head== null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    static boolean optimal(ListNode head){
        if (head==null || head.next == null) return true;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverse(slow.next);
        ListNode first = head, second = newHead;

        while (second != null){
            if (first.data != second.data) {
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = createLL(arr);
//        System.out.println(bruteForce(head));

        System.out.println(optimal(head));
        traversal(head);
    }
}
