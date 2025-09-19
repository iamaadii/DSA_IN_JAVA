/*
You are given the head of a linked list, and an integer k.
Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the
end (the list is 1-indexed).

Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]

Constraints:
The number of nodes in the list is n.
    1 <= k <= n <= 10^5
    0 <= Node.val <= 100
*/
package Linked_List.MediumOfSinglyLL;
import static Linked_List.MediumOfSinglyLL.ListNode.*;

public class SwapNodesInaLL {
    static ListNode bruteForce(ListNode head, int k){
        ListNode t1 = head,t2 = head;
        int size = 0;
        while(t1 != null){
            size +=1; t1 = t1.next;
        }
        t1 = head;
        int step = k;
        while(step != 1){
            step -= 1;
            t1 = t1.next;
        }

        step = size - k +1;
        while(step != 1){
            step -= 1;
            t2 = t2.next;
        }

        int c = t1.data;
        t1.data = t2.data;
        t2.data = c;

        return head;
    }
    static ListNode optimal(ListNode head,int k){
        ListNode first = head, second = head, front = head;
        for (int i = 1; i < k; i++)  front = front.next;
        first = front;

        while (front.next != null) {
            front = front.next;
            second = second.next;
        }

        int temp = first.data;
        first.data = second.data;
        second.data = temp;

        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = createLL(arr);
        traversal(head);

//        ListNode res = bruteForce(head,2);
//        traversal(res);

        ListNode res1 = optimal(head,2);
        traversal(res1);

    }
}
