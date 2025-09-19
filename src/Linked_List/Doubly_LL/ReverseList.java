/*
Given a doubly linked list of size ‘N’ consisting of positive integers, your task is to reverse it and return the
head of the modified doubly linked list.
*/
package Linked_List.Doubly_LL;

import java.util.Stack;
import static Linked_List.Doubly_LL.ListNode.*;

public class ReverseList {
    static ListNode bruteForce(ListNode head){
        if (head==null || head.next==null) return head;

        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null){
            stack.add(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (temp != null){
            temp.data = stack.pop();
            temp = temp.next;
        }
        return head;
    }

    static ListNode optimal(ListNode head){
        if (head==null || head.next==null) return head;

        ListNode current = head,last=null;
        while (current != null){
            last = current.back;
            current.back = current.next;
            current.next = last;
            current = current.back;
        }
        return last.back;
     }

    public static void main(String[] args) { ListNode head = new ListNode(10);
        head.next = new ListNode(20,head,null);
        head.next.next = new ListNode(30,head.next,null);
        head.next.next.next = new ListNode(40,head.next.next,null);
        traversal(head);

//        head = bruteForce(head);
//        traversal(head);

        head = optimal(head);
        traversal(head);
    }
}
