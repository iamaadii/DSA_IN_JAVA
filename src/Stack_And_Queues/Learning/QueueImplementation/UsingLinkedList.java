package Stack_And_Queues.Learning.QueueImplementation;

public class UsingLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int n){
            data = n;
            next = null;
        }
    }

    int size;
    Node front, rear;
    UsingLinkedList(){
        size = 0;
        front = rear = null;
    }

    void add(int element){
        Node temp = new Node(element);
        if (front==null && rear==null){
            front = rear = temp;
        }else{
            rear.next = temp;
            rear = rear.next;
        }
        size += 1;
    }

    int pop(){
        if (front==null){
            System.out.println("Queue is Empty");
            return -1;
        }
        Node temp = front;
        if (front==rear){
            front = null;
            rear = null;
        }
        else {
            front = front.next;
        }
        size -= 1;
        return temp.data;
    }

    int peek(){
        if (front==null){
            System.out.println("Queue is Empty");
            return -1;
        }
        return front.data;
    }

    int Size(){
        return size;
    }

    public static void main(String[] args) {
        UsingLinkedList q = new UsingLinkedList();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.Size());
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.Size());
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.Size());
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.Size());
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.Size());
    }
}
