/*
Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the
list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

Constraints:
1 ≤ no. of nodes ≤ 10^6
0 ≤ node->data ≤ 2
*/
package Linked_List.MediumOfSinglyLL;
import static Linked_List.MediumOfSinglyLL.ListNode.*;

public class SortLLOf_0s_1s_2s {
    static ListNode bruteForce(ListNode head){
        if (head==null || head.next==null) return head;

        ListNode temp = head;
        int count0 = 0, count1 = 0, count2 = 0;
        while (temp != null){
            if (temp.data == 0) count0++;
            else if(temp.data == 1) count1++;
            else count2++;
            temp = temp.next;
        }

        temp = head;
        while (temp != null){
            if (count0>0){
                temp.data = 0;
                count0--;
            }
            else if(count1>0){
                temp.data = 1;
                count1--;
            }
            else if(count2>0){
                temp.data = 2;
                count2--;
            }
            temp = temp.next;
        }
        return head;
    }

    static ListNode optimal(ListNode head){
        if (head==null || head.next==null) return head;

        ListNode temp = head;
        ListNode zeroHead = new ListNode(-1);
        ListNode zero = zeroHead;

        ListNode oneHead = new ListNode(-1);
        ListNode one = oneHead;

        ListNode twoHead = new ListNode(-1);
        ListNode two = twoHead;

        while (temp!=null){
            if (temp.data == 0){
                zero.next = temp;
                zero = temp;
            }
            else if(temp.data == 1){
                one.next = temp;
                one = temp;
            }
            else if(temp.data == 2){
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,0,2,1};
        ListNode head = createLL(arr);

//        head = bruteForce(head);
//        traversal(head);

        head = optimal(head);
        traversal(head);
    }
}
