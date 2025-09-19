/*
Given a link list, modify the list such that all the even numbers appear before all the odd numbers in the modified list.
The order of appearance of numbers within each segregation should be the same as that in the original list.
*/
package Linked_List.MediumOfSinglyLL;
import java.util.ArrayList;
import static Linked_List.MediumOfSinglyLL.ListNode.*;

public class SegregateEvenAndOddNodes {

    static ListNode bruteForce(ListNode head){
        if (head==null || head.next==null) return head;

        ListNode temp = head;
        ArrayList<Integer> l = new ArrayList<>();
        while (temp != null){
            if (temp.data % 2 == 0) l.add(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (temp != null){
            if (temp.data % 2 == 1) l.add(temp.data);
            temp = temp.next;
        }

        int i=0;
        temp = head;
        while (temp != null && i<l.size()){
            temp.data = l.get(i);
            i++;
            temp = temp.next;
        }
        return head;
    }

    static ListNode optimal(ListNode head){
        if (head==null || head.next==null) return head;

        ListNode temp = head;

        ListNode evenHead = new ListNode(-1);
        ListNode even = evenHead;

        ListNode oddHead = new ListNode(-1);
        ListNode odd = oddHead;

        while (temp!=null){
            if (temp.data % 2 == 1){
                odd.next = temp;
                odd = temp;
            }
            else if(temp.data % 2 == 0){
                even.next = temp;
                even = temp;
            }
            temp = temp.next;
        }
        even.next = oddHead.next;
        odd.next = null;

        return evenHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {17,15,8,9,2,4,6};
        ListNode head = createLL(arr);

//        head = bruteForce(head);
//        traversal(head);

        head = optimal(head);
        traversal(head);
    }
}
