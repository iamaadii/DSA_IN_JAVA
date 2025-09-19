package Linked_List.LL_1D;

public class ListNode {
    int data;
    ListNode next;

    public ListNode(int data1, ListNode next1){
        this.data = data1;
        this.next = next1;
    }
    public ListNode(int data1){
        data = data1;
        next = null;
    }
    public static ListNode createLL(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;
        for (int i=1;i<arr.length;i++){
            ListNode new_node = new ListNode(arr[i]);
            mover.next = new_node;
            mover = new_node;
        }
        return head;
    }

    public static void traversal(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] arr = {45,78,86};
        ListNode head = createLL(arr);
        traversal(head);
    }
}
