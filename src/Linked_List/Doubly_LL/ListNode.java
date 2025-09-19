package Linked_List.Doubly_LL;

class ListNode {
    int data;       // Data stored in the node
    ListNode next;      // Reference to the next node in the list (forward direction)
    ListNode back;      // Reference to the previous node in the list (backward direction)

    // Constructor for a Node with both data, a reference to the next node, and a reference to the previous node
    public ListNode(int data, ListNode back, ListNode next) {
        this.data = data;
        this.back = back;
        this.next = next;
    }

    // Constructor for a Node with data, and no references to the next and previous nodes (end of the list)
    public ListNode(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }
    public static void traversal(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.data+" <-> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode createLL(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;
        for (int i=1;i< arr.length;i++){
            ListNode temp = new ListNode(arr[i],prev,null);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
}
