/*
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
If the two linked lists have no intersection at all, return null.

Constraints:
2 ≤ total number of nodes ≤ 2*10^5
-10^4 ≤ node->data ≤ 10^4
*/
package Linked_List.MediumOfSinglyLL;
import java.util.HashMap;

import static Linked_List.MediumOfSinglyLL.ListNode.*;

public class IntersectionOfTwoListYList {
    static ListNode bruteForce(ListNode head1, ListNode head2){
        if (head1 == null || head2 == null) return null;

        ListNode t1 = head1, t2 = head2;
        HashMap<ListNode,Integer> mp = new HashMap<>();
        while (t1 != null){
            mp.put(t1,1);
            t1 = t1.next;
        }

        while (t2 != null){
            if (mp.containsKey(t2)) return t2;
            t2 = t2.next;
        }
        return null;
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
    static ListNode collisionPoint(ListNode head1, ListNode head2, int difference){
        ListNode t1 = head1, t2 = head2;
        while (difference != 0){
            difference -= 1;
            t2 = t2.next;
        }
        while (t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
        }
        return t1;
    }
    static ListNode betterSolution(ListNode head1, ListNode head2){
        if (head1 == null || head2 == null) return null;

        int n1 = length(head1), n2 = length(head2);
        if (n1 < n2) return collisionPoint(head1,head2,n2-n1);
        else return collisionPoint(head2, head1, n1-n2);
    }



    static ListNode optimal(ListNode head1, ListNode head2){
        if (head1 == null || head2 == null) return null;

        ListNode t1 = head1, t2 = head2;
        while (t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
            if (t1 == t2) return t1;
            if(t1 == null) t1 = head2;
            if(t2 == null) t2 = head1;
        }
        return t1;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(4);

        ListNode head2 = new ListNode(3);
        head2.next = head1.next.next.next;
        head2.next.next = head1.next.next.next.next;

        traversal(head1);
        traversal(head2);

//        ListNode intersection = bruteForce(head1,head2);
//        traversal(intersection);

//        ListNode intersection = betterSolution(head1,head2);
//        traversal(intersection);

        ListNode intersection = optimal(head1, head2);
        traversal(intersection);

    }
}
