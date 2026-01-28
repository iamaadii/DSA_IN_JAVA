package Stack_And_Queues.Learning.StackImplementation;

public class UsingLinkedLists {
    static class Node{
        int data;
        Node next;
        Node(int n){
            data = n;
            next = null;
        }
    }

    int size;
    Node top;
    UsingLinkedLists(){
        size = 0;
        top=null;
    }
    void push(int n){
        Node newNode = new Node(n);
        newNode.next = top;
        top = newNode;
        size += 1;
    }

    int pop(){
        if (top==null) {
            System.out.println("Stack is Empty");
            return -1;
        }
        Node temp = top;
        top = top.next;
        size -= 1;
        return temp.data;
    }

    int peek(){
        if (top==null) return -1;
        return top.data;
    }

    boolean isEmpty(){
        return top==null;
    }

    int Size(){
        return size;
    }

    public static void main(String[] args) {
        UsingLinkedLists st = new UsingLinkedLists();
        st.push(4);
        st.push(2);
        st.push(3);
        st.push(1);
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.Size());
    }
}
