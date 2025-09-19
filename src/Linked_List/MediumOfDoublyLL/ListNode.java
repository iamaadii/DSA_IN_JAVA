package Linked_List.MediumOfDoublyLL;

class ListNode {
    int data;       // Data stored in the node
    ListNode next;      // Reference to the next node in the list (forward direction)
    ListNode prev;      // Reference to the previous node in the list (backward direction)

    // Constructor for a Node with both data, a reference to the next node, and a reference to the previous node
    ListNode(int data, ListNode back, ListNode next) {
        this.data = data;
        this.prev = back;
        this.next = next;
    }

    // Constructor for a Node with data, and no references to the next and previous nodes (end of the list)
    ListNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    static void traversal(ListNode head){
        ListNode temp = head;
        System.out.print("null <-> ");
        while (temp != null){
            System.out.print(temp.data+" <-> ");
            temp = temp.next;
        }
        System.out.println("null ");
    }

    static ListNode createLL(int[] arr){
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
