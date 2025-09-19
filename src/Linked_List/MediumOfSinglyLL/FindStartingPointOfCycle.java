/*
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
*/
package Linked_List.MediumOfSinglyLL;
import java.util.HashMap;
import static Linked_List.MediumOfSinglyLL.ListNode.traversal;

public class FindStartingPointOfCycle {
    static ListNode bruteForce(ListNode head){
        HashMap<ListNode,Integer> mp = new HashMap<>();

        ListNode temp = head;
        while (temp != null){
            if(mp.containsKey(temp)) return temp;
            mp.put(temp,1);
            temp = temp.next;
        }
        return null;
    }
    static ListNode optimal(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                ListNode temp = head;
                while (temp != slow){
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4,head.next);

//        ListNode temp1 = bruteForce(head);
//        traversal(temp1);

        ListNode temp2 = optimal(head);
        traversal(temp2);
    }
}
