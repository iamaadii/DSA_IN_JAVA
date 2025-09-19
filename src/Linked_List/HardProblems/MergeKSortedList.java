/*
Given an arr[] of k sorted linked lists. Your task is to merge all these lists into a single sorted linked list and return the
head of the merged list.

Constraints:
    k == lists.length
    0 <= k <= 10^4
    0 <= lists[i].length <= 500
    -10^4 <= lists[i][j] <= 10^4
    lists[i] is sorted in ascending order.
    The sum of lists[i].length will not exceed 10^4.
*/
package Linked_List.HardProblems;
import java.util.*;
import static Linked_List.HardProblems.ListNode.*;

public class MergeKSortedList {
    static ListNode bruteForce(ListNode[] arr){
        ArrayList<Integer> l = new ArrayList<>();
        for (int i=0;i< arr.length;i++){
            ListNode temp = arr[i];
            while (temp != null){
                l.add(temp.data);
                temp = temp.next;
            }
        }
        Collections.sort(l);
        ListNode dummy = new ListNode(-1), current = dummy;
        for (int e: l){
            current.next = new ListNode(e);
            current = current.next;
        }
        return dummy.next;
    }




    static ListNode merge(ListNode head1, ListNode head2){
        ListNode t1 = head1, t2 = head2;
        ListNode dummy = new ListNode(-1), current = dummy;
        while (t1 != null && t2 != null){
            if (t2.data < t1.data){
                current.next = t2; current = current.next;
                t2 = t2.next;
            }
            else{
                current.next = t1; current = current.next;
                t1 = t1.next;
            }
        }
        if (t1 != null) current.next = t1;
        if (t2 != null) current.next = t2;

        return dummy.next;
    }
    static ListNode better(ListNode[] arr){
        ListNode head = arr[0];
        for (int i=1;i< arr.length;i++){
            head = merge(head,arr[i]);
        }
        return head;
    }




    static ListNode optimal(ListNode[] arr){
        PriorityQueue<Map.Entry<Integer, ListNode>> pq = new PriorityQueue<>( Comparator.comparingInt(Map.Entry::getKey));
        for (ListNode l: arr){
            if (l != null) {
                pq.add(new AbstractMap.SimpleEntry<>(l.data, l));
            }
        }

        ListNode dummy = new ListNode(-1), current = dummy;
        while (!pq.isEmpty()){
            Map.Entry<Integer, ListNode> it = pq.poll();
            current.next = it.getValue();
            current = current.next;
            if (it.getValue().next != null) {
                pq.add(new AbstractMap.SimpleEntry<>(it.getValue().next.data, it.getValue().next));
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[4];
        listNodes[0] = createLL(new int[] {2,4,6});
        listNodes[1] = createLL(new int[] {1,5});
        listNodes[2] = createLL(new int[] {1,1,3,7});
        listNodes[3] = createLL(new int[] {8});

//        ListNode res = bruteForce(listNodes);
//        traversal(res);

//        ListNode res = better(listNodes);
//        traversal(res);

        ListNode res = optimal(listNodes);
        traversal(res);
    }
}
