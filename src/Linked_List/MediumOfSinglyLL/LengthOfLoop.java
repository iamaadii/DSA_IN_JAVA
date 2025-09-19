/*
Given the head of a linked list, determine the length of a loop present in the linked list; if not present, return 0.
*/
package Linked_List.MediumOfSinglyLL;
import java.util.HashMap;

public class LengthOfLoop {

    static int bruteForce(ListNode head){
        ListNode temp = head;
        HashMap<ListNode,Integer> mp = new HashMap<>();
        int count = 1;

        while (temp != null){
            if (mp.containsKey(temp)) return count - mp.get(temp);
            mp.put(temp,count);
            count += 1;
            temp = temp.next;
        }
        return 0;
    }
    static int optimal(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                int count = 1;
                slow = slow.next;
                while (slow != fast){
                    count+=1;
                    slow = slow.next;
                }
                return count;
            }
        }
        return 0;
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
