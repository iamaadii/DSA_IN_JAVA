/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
Implement the LRUCache class:
    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    int get(int key) Return the value of the key if the key exists, otherwise return -1.
    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
    The functions get and put must each run in O(1) average time complexity.
*/
package Stack_And_Queues.ImplementationProblems;
import java.util.HashMap;

public class LRUCache {
    static class Pair{
        int key,value;
        Pair(int k,int v){
            key = k;
            value = v;
        }
    }
    static class Node{
        Pair pair;
        Node next;
        Node prev;
        Node(Pair p){
            pair = p;
            next = null;
            prev = null;
        }
    }

    Node head,tail;
    HashMap<Integer,Node> mp;
    int capacity;
    public LRUCache(int c) {
        head = new Node(new Pair(-1,-1));
        tail = new Node(new Pair(-1,-1));
        head.next = tail;
        tail.prev = head;

        capacity = c;
        mp = new HashMap<>();
    }
    public int get(int key) {
        if (!mp.containsKey(key)){
            return -1;
        }
        Node curr = mp.get(key);
        int res = curr.pair.value;
        Node currPrev = curr.prev;
        Node currNext = curr.next;

        currPrev.next = currNext;
        currNext.prev = currPrev;

        Node insertBefore = head.next;
        curr.prev = head;
        curr.next = insertBefore;
        head.next = curr;
        insertBefore.prev = curr;
        return res;
    }

    public void put(int key, int value) {
        if (!mp.containsKey(key)){
            if (mp.size()==capacity) {
                mp.remove(tail.prev.pair.key);
                Node temp = tail.prev.prev;
                temp.next = tail;
                tail.prev = temp;
            }
            Node newNode = new Node(new Pair(key,value));
            Node insertBefore = head.next;
            newNode.next = insertBefore;
            newNode.prev = head;
            insertBefore.prev = newNode;
            head.next = newNode;
            mp.put(key,newNode);
        }
        else{
            Node curr = mp.get(key);
            curr.pair.value = value;

            Node currNext = curr.next;
            Node currPrev = curr.prev;
            currPrev.next = currNext;
            currNext.prev = currPrev;

            Node insertBefore = head.next;
            curr.next = insertBefore;
            curr.prev = head;
            insertBefore.prev = curr;
            head.next = curr;
            mp.put(key,curr);
        }
    }

    void traversal(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.pair.key);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(2,1);
        obj.put(1,1);
//        obj.traversal();
//        System.out.println(obj.get(1));
//        obj.traversal();
        obj.put(2,3);
//        obj.traversal();
//        System.out.println(obj.get(2));
        obj.put(4,1);
        System.out.println(obj.get(1));
        System.out.println(obj.get(2));
//        System.out.println(obj.get(4));
//        obj.traversal();
    }

}
