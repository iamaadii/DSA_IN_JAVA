/*
Given the head of two sorted singly linked lists consisting of nodes respectively. Merge both lists and return the head of
the sorted merged list.

Constraints:
    1 ≤ list1.size, list2.size ≤ 10^3
    0 ≤ node->data ≤ 10^5
*/
package Linked_List.HardProblems;
import java.util.ArrayList;
import java.util.Collections;

import static Linked_List.HardProblems.ListNode.*;

public class MergeTwoSortedList {
    static ListNode bruteForce(ListNode head1, ListNode head2){
        ListNode t1 = head1, t2 = head2;
        ArrayList<Integer> l = new ArrayList<>();
        while (t1 != null) {
            l.add(t1.data);
            t1 = t1.next;
        }
        while (t2 != null) {
            l.add(t2.data);
            t2 = t2.next;
        }
        Collections.sort(l);
        ListNode dummy = new ListNode(-1),current = dummy;
        for (int e: l){
            current.next = new ListNode(e); current = current.next;
        }
        return dummy.next;
    }
    static ListNode optimal(ListNode head1, ListNode head2){
        ListNode t1 = head1, t2 = head2;
        ListNode dummy = new ListNode(-1), current = dummy;
        while (t1 != null && t2 != null){
            if (t2.data < t1.data){
                current.next = t2; current = current.next;
                t2 = t2.next;
            }
            else{
                current.next = t1; current = current.next;
                t1 = t1.next;
            }
        }
        if (t1 != null) current.next = t1;
        if (t2 != null) current.next = t2;

        return dummy.next;
    }
    public static void main(String[] args) {
        int[] arr1 = {5,10,15,40};
        int[] arr2 = {2,3,20};
        ListNode l1 = createLL(arr1);
        ListNode l2 = createLL(arr2);

        ListNode res1 = bruteForce(l1,l2);
        traversal(res1);

        ListNode res2 = optimal(l1,l2);
        traversal(res2);
    }
}
