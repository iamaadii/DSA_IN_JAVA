/*
You are given the head of two singly linked lists head1 and head2 representing two non-negative integers.
You have to return the head of the linked list representing the sum of these two numbers.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

Input: l1 = [1,2,3], l2 = [9,9,9]
Output: [1,1,2,2]
Explanation: 123 + 999 = 1122.
*/
package Linked_List.MediumOfSinglyLL;
import static Linked_List.MediumOfSinglyLL.ListNode.*;

public class AddTwoNumbers_II {

    static ListNode trimLeadingZeroes(ListNode head){
        while (head!=null && head.data==0) head = head.next;
        return head;
    }

    static int length(ListNode head){
        int count = 0;
        ListNode temp = head;
        while (temp!=null){
            count+=1;
            temp = temp.next;
        }
        return count;
    }
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

    static ListNode bruteForce(ListNode head1, ListNode head2){
        head1 = trimLeadingZeroes(head1);
        head2 = trimLeadingZeroes(head2);

        head1 = reverse(head1);
        head2 = reverse(head2);

        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        int carry = 0;
        while (head1 != null || head2 !=null){
            int sum = carry;
            if (head1 != null){
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null){
                sum+=head2.data;
                head2 = head2.next;
            }
            current.next = new ListNode(sum%10);
            carry = sum/10;
            current = current.next;
        }
        if (carry>0)   current.next = new ListNode(carry);
        return reverse(dummyNode.next);
    }


    static ListNode optimal(ListNode head1, ListNode head2){
        head1 = trimLeadingZeroes(head1);
        head2 = trimLeadingZeroes(head2);

        int l1 = length(head1),l2 = length(head2);
        if (l2>l1) return optimal(head2,head1);

        head1 = reverse(head1);
        head2 = reverse(head2);

        ListNode res = head1;
        int carry = 0;
        while(head2!=null || carry!=0){
            head1.data+=carry;
            if (head2 != null){
                head1.data+=head2.data;
                head2 = head2.next;
            }
            carry = head1.data/10;
            head1.data = head1.data % 10;

            if(head1.next == null && carry!=0)  head1.next = new ListNode(0);
            head1 = head1.next;
        }
        return reverse(res);
    }


    public static void main(String[] args) {
        int[] arr1 = {6,7};
        int[] arr2 = {8,9};

        ListNode head1 = createLL(arr1);
        ListNode head2 = createLL(arr2);

        ListNode res = bruteForce(head1,head2);
        traversal(res);

//        res = optimal(head1,head2);
//        traversal(res);
    }

}
