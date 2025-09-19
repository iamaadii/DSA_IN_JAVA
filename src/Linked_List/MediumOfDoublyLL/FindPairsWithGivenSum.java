/*
Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose
sum is equal to given value target.

Constraints:
    1 <= N <= 10^5
    1 <= target <= 10^5
*/
package Linked_List.MediumOfDoublyLL;
import java.util.ArrayList;
import java.util.Arrays;
import static Linked_List.MediumOfDoublyLL.ListNode.*;

public class FindPairsWithGivenSum {

    static ArrayList<ArrayList<Integer>> bruteForce(ListNode head,int sum){
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        ListNode t1 = head;
        while (t1 != null){
            ListNode t2 = t1.next;
            while (t2 != null && t1.data+t2.data<=sum){
                if (t1.data + t2.data == sum) l.add(new ArrayList<>(Arrays.asList(t1.data, t2.data)));
                t2 = t2.next;
            }
            t1 = t1.next;
        }
        return l;
    }

    static ArrayList<ArrayList<Integer>> optimal(ListNode head, int sum){
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        ListNode left = head, right = head;
        while (right.next != null)  right = right.next;

        while (left.data < right.data){
            int total = left.data+right.data;
            if (total == sum) {
                l.add(new ArrayList<>(Arrays.asList(left.data, right.data)));
                left = left.next; right = right.prev;
            }
            else if(total > sum) right = right.prev;
            else left = left.next;
        }
        return l;
    }
    public static void main(String[] args) {
        int[] arr = {1,5,6};
        ListNode head = createLL(arr);
        traversal(head);

        System.out.println(bruteForce(head,6));
        System.out.println(optimal(head,6));
    }
}
