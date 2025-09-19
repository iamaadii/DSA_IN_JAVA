package Linked_List.Doubly_LL;

public class InsertOperation {
    static void traversal(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    static ListNode beforeHead(ListNode head, int element){
        ListNode temp = new ListNode(element);
        if (head==null) return temp;

        temp.next = head;
        head.back = temp;
        return temp;
    }

    static ListNode beforeTail(ListNode head, int element){
        ListNode new_node = new ListNode(element);
        if (head == null) return new_node;
        else if(head.next==null){
            new_node.next = head;
            head.back = new_node;
            return new_node;
        }

        ListNode tail = head;
        while (tail.next != null) tail = tail.next;
        ListNode prev = tail.back;
        new_node.next = tail;
        new_node.back = prev;
        prev.next = new_node;
        tail.back = new_node;
        return head;
    }

    static ListNode beforekthNode(ListNode head, int element, int k){
        if(head==null && k==1) return new ListNode(element);
        else if (k==1) return beforeHead(head,element);

        int count = 1;
        ListNode temp = head;
        while (temp!= null){
            if (count==k) break;
            count++;
            temp=temp.next;
        }

        if (temp== null) return head;

        ListNode prev = temp.back;
        ListNode new_node = new ListNode(element,prev,temp);
        prev.next = new_node;
        temp.back = new_node;
        return head;
    }

    static void beforeNode(ListNode temp, int element){
        ListNode prev = temp.back;
        ListNode new_node = new ListNode(element,prev,temp);
        prev.next = new_node;
        temp.back = new_node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20,head,null);
        head.next.next = new ListNode(30,head.next,null);
        head.next.next.next = new ListNode(40,head.next.next,null);
        traversal(head);

//        head = beforeHead(head,34);
//        traversal(head);

//        head = beforeTail(head,42);
//        traversal(head);

//        head = beforekthNode(head,34,5);
//        traversal(head);

        beforeNode(head.next,75);
        traversal(head);
    }
}
