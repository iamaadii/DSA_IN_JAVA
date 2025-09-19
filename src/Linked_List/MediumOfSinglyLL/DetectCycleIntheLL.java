/*
You are given the head of a singly linked list. You have to determine whether the given linked list contains a loop or not.
*/
package Linked_List.MediumOfSinglyLL;
import java.util.HashMap;

public class DetectCycleIntheLL {
    static boolean bruteForce(ListNode head){
        HashMap<ListNode,Integer> mp = new HashMap<>();

        ListNode temp = head;
        while (temp != null){
            if(mp.containsKey(temp)) return true;
            mp.put(temp,1);
            temp = temp.next;
        }
        return false;
    }

    static boolean optimal(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4,head.next);

        System.out.println(bruteForce(head));
        System.out.println(optimal(head));
    }
}
