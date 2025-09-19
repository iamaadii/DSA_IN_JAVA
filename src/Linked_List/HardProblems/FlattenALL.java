/*
Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order.
Note: The flattened list will be printed using the bottom pointer instead of next pointer.

Constraints:
    0 <= N <= 50
    1 <= Mi <= 20
    1 <= Element of linked list <= 10^3
*/
package Linked_List.HardProblems;
import java.util.ArrayList;
import java.util.Collections;

class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}
public class FlattenALL {
    static void traversal(Node head){
        Node row = head;
        while (row != null){
            Node column = row;
            while (column != null){
                System.out.print(column.data + " -> ");
                column = column.bottom;
            }
            System.out.println();
            row = row.next;
        }
        System.out.println();
    }
    static Node createFlattenedList(ArrayList<Integer> l){
        if (l.isEmpty()) return null;
        Node dummy = new Node(-1),current = dummy;
        for (int element: l){
            current.bottom = new Node(element);
            current = current.bottom;
        }
        return dummy.bottom;
    }
    static Node bruteForce(Node head){
        ArrayList<Integer> l = new ArrayList<>();
        Node row = head;
        while (row != null){
            Node column = row;
            while (column != null){
               l.add(column.data);
                column = column.bottom;
            }
            row = row.next;
        }
        Collections.sort(l);
        return createFlattenedList(l);
    }



    static Node merge(Node head1, Node head2){
        Node t1 = head1, t2 = head2;
        Node dummy = new Node(-1), current = dummy;
        while (t1 != null && t2 != null){
            if (t1.data < t2.data){
                current.bottom = t1;
                current = current.bottom;
                t1 = t1.bottom;
            }
            else{
                current.bottom = t2;
                current = current.bottom;
                t2 = t2.bottom;
            }
            current.next = null;
        }
        if(t1 != null) current.bottom = t1;
        if (t2 != null) current.bottom = t2;

        return dummy.bottom;
    }
    static Node optimal(Node head){
        if (head == null || head.next == null) return head;
        Node temp = optimal(head.next);
        return merge(head,temp);
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.bottom = new Node(10);
        head.next.next = new Node(1);
        head.next.next.bottom = new Node(7);
        head.next.next.bottom.bottom = new Node(11);
        head.next.next.bottom.bottom.bottom = new Node(12);
        head.next.next.next = new Node(4);
        head.next.next.next.bottom = new Node(9);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.bottom = new Node(6);
        head.next.next.next.next.bottom.bottom = new Node(8);

        traversal(head);

//        Node res = bruteForce(head);
//        traversal(res);

        Node res = optimal(head);
        traversal(res);
    }
}
