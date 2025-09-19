package Linked_List.Doubly_LL;

public class DeleteOperation {
    static void traversal(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    static ListNode deleteHead(ListNode head){
        if (head==null || head.next==null) return null;

        ListNode prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        return head;
    }

    static ListNode deleteTail(ListNode head){
        if (head==null || head.next==null) return null;
        ListNode temp = head;
        while (temp.next != null) temp=temp.next;
        temp.back.next = null;
        temp.back = null;
        return head;
    }

    static ListNode deleteKthElement(ListNode head, int k){
        if (head==null) return null;
        int count = 1;
        ListNode temp = head;
        while (temp != null){
            if (count == k) break;
            temp = temp.next;
            count++;
        }
        if (temp==null) return head;
        ListNode prev = temp.back, front = temp.next;
        if (prev==null && front==null) return null;
        else if (prev==null){
            temp.next = null;
            front.back=null;
            return front;
        }
        else if(front==null){
            temp.back = null;
            prev.next = null;
            return head;
        }
        else{
            prev.next = front;
            front.back = prev;
            temp.next = null;
            temp.back = null;
        }
        return head;
    }

    static void deleteGivenElement(ListNode temp){
        ListNode prev = temp.back, front = temp.next;
        if (front == null){
            prev.next = null;
            temp.back = null;
            return;
        }
        prev.next = front;
        front.back = prev;
        temp.next = temp.back = null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20,head,null);
        head.next.next = new ListNode(30,head.next,null);
        head.next.next.next = new ListNode(40,head.next.next,null);
        traversal(head);

//        head = deleteHead(head);
//        traversal(head);

//        head = deleteTail(head);
//        traversal(head);

//        head = deleteKthElement(head,2);
//        traversal(head);

        deleteGivenElement(head.next);
        traversal(head);
    }
}
