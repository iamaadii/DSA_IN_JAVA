package Linked_List.LL_1D;

import static Linked_List.LL_1D.ListNode.*;

public class BasicOperation {
    static int lengthOfLL(ListNode head){
        ListNode temp = head;
        int count = 0;
        while (temp != null){
            count+=1;
            temp = temp.next;
        }
        return count;
    }

    static boolean searching(ListNode head, int target){
        ListNode temp = head;
        while (temp != null){
            if (temp.data == target)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {45,78,86,98};
        ListNode head = createLL(arr);
        traversal(head);

        System.out.println(lengthOfLL(head));
        System.out.println(searching(head,75));
    }
}
