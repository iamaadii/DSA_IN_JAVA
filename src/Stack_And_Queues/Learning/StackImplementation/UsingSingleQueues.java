package Stack_And_Queues.Learning.StackImplementation;
import java.util.*;
class UsingSingleQueues {
    Queue<Integer> q = new LinkedList<>();
    int size;
    public UsingSingleQueues() {
        size=0;
    }

    public void push(int x) {
        int s = size;
        q.add(x);
        for(int i=1;i<=s;i++){
            q.add(q.poll());
        }
        size += 1;
    }

    public int pop() {
        size -= 1;
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        UsingSingleQueues st = new UsingSingleQueues();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.pop());
    }
}
