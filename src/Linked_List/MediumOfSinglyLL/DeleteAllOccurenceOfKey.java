package Linked_List.MediumOfSinglyLL;
import static Linked_List.MediumOfSinglyLL.ListNode.*;

public class DeleteAllOccurenceOfKey {
    static ListNode optimal1(ListNode head, int key){
        if (head == null) return null;
        if(head.next == null && head.data == key) return null;

        ListNode current = head;
        ListNode dummy = new ListNode(-1), temp = dummy;

        while (current != null){
            if (current.data != key){
                temp.next = current;
                temp = temp.next;
            }
            current = current.next;
        }
        temp.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,4,2,6,7,2};
        ListNode head = createLL(arr);
        traversal(head);

        ListNode temp = optimal1(head,2);
        traversal(temp);
    }
}
