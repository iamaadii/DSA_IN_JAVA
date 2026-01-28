/*
Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.
*/
package Stack_And_Queues.ImplementationProblems;
import java.util.HashMap;

class LFUCache {
    static class Node{
        int key,value,frequency;
        Node next,prev;

        Node(int key,int value){
            this.key = key;
            this.value = value;
            this.frequency = 1;
            next = null;
            prev = null;
        }
    }
    static class DoublyLL{
        Node head;
        Node tail;
        int size;
        DoublyLL(){
            this.size = 0;
            this.head = new Node(-1,-1);
            this.tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
        }

        void addNode(Node currNode){
            Node headNext = head.next;
            currNode.next = headNext;
            currNode.prev = head;
            head.next = currNode;
            headNext.prev = currNode;
            size += 1;
        }

        void deleteNode(Node currNode){
            Node prevNode = currNode.prev;
            Node nextNode = currNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size -= 1;
        }
    }

    int maxSize;
    int minFrequency, currSize;
    HashMap<Integer,DoublyLL> freqList;
    HashMap<Integer,Node> keyNode;

    public LFUCache(int c) {
        maxSize = c;
        currSize = 0;
        minFrequency = 0;
        freqList = new HashMap<>();
        keyNode = new HashMap<>();
    }

    void updateFrequency(Node currNode){
        int currFre = currNode.frequency;
        DoublyLL currList = freqList.get(currFre);
        currList.deleteNode(currNode);

        if(currFre==minFrequency && currList.size==0){
            minFrequency += 1;
        }
        currNode.frequency += 1;
        DoublyLL list = freqList.getOrDefault(currNode.frequency,new DoublyLL());
        list.addNode(currNode);
        freqList.put(currNode.frequency,list);
    }

    public int get(int key) {
        Node currNode = keyNode.get(key);
        if(currNode==null){
            return -1;
        }
        updateFrequency(currNode);
        return currNode.value;
    }

    public void put(int key, int value) {
        if(maxSize ==0){
            return;
        }
        if(keyNode.containsKey(key)){
            Node currNode = keyNode.get(key);
            currNode.value = value;
            updateFrequency(currNode);
        }
        else{
            if(currSize == maxSize){
                DoublyLL currList = freqList.get(minFrequency);
                keyNode.remove(currList.tail.prev.key);
                currList.deleteNode(currList.tail.prev);
                currSize -= 1;
            }
            minFrequency = 1;
            Node newNode = new Node(key,value);
            DoublyLL list = freqList.getOrDefault(1,new DoublyLL());
            list.addNode(newNode);
            freqList.put(1,list);
            keyNode.put(key,newNode);
            currSize++;
        }
    }
}