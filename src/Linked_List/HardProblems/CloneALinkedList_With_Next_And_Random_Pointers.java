/*
You are given a special linked list with n nodes where each node has two pointers a next pointer that points to the next node
of the singly linked list, and a random pointer that points to the random node of the linked list. Construct a copy of this
linked list. The copy should consist of the same number of new nodes, where each new node has the value corresponding to its
original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list, such that it also
represent the same list state. None of the pointers in the new list should point to nodes in the original list.

Return the head of the copied linked list.

NOTE : Original linked list should remain unchanged.
Each node of the linked list is represented as a pair of [val, random_index] where:

val represents node.data.
random_index (1-based index) represents the index of the node that the random pointer of the current node points to, or NULL if
it does not point to any node.

Constraints:
    1 ≤ n ≤ 100
    0 ≤ node->data ≤ 1000
*/
package Linked_List.HardProblems;
import java.util.HashMap;

class Node2 {
    int data;
    Node2 next, random;

    Node2(int data){
        this.data = data;
        next = null;
        random = null;
    }
}

public class CloneALinkedList_With_Next_And_Random_Pointers {

    static void traversal(Node2 head){
        Node2 temp = head;
        while (temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    static Node2 brutForce(Node2 head){
        Node2 temp = head;
        HashMap<Node2, Node2> mp = new HashMap<>();
        while (temp != null){
            Node2 newNode = new Node2(temp.data);
            mp.put(temp,newNode);
            temp = temp.next;
        }
        temp = head;
        while (temp != null){
            Node2 copy = mp.get(temp);
            copy.next = mp.get(temp.next);
            copy.random = mp.get(temp.random);
            temp = temp.next;
        }
        return mp.get(head);
    }



    static Node2 optimal(Node2 head){
        Node2 temp = head;
        while (temp != null){
            Node2 copy = new Node2(temp.data);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }
        temp = head;
        while (temp != null){
            Node2 copy = temp.next;
            if (temp.random == null)
                copy.random = null;
            else
                copy.random = temp.random.next;

            temp = copy.next;
        }

        Node2 dummy = new Node2(-1), current = dummy;
        temp = head;
        while (temp != null){
           current.next = temp.next;
           current = current.next;
           temp.next = current.next;
           temp = temp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node2 head = new Node2(7);
        head.next = new Node2(13);
        head.next.next = new Node2(11);
        head.next.next.next = new Node2(10);
        head.next.next.next.next = new Node2(1);
        head.random = null;
        head.next.random = head;
        head.next.next.random =  head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

//        Node2 res = brutForce(head);
//        traversal(res); //copied list
//        traversal(head); //original list

        Node2 res = optimal(head);
        traversal(res);
        traversal(head);
    }
}
