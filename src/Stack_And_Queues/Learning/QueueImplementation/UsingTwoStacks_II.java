package Stack_And_Queues.Learning.QueueImplementation;
import java.util.Stack;

public class UsingTwoStacks_II {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    void push(int x){
        st1.push(x);
    }

    int top(){
        if (!st2.isEmpty()){
            return st2.peek();
        }
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        return st2.peek();
    }

    int pop(){
        if (!st2.isEmpty()){
            return st2.pop();
        }
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        return st2.pop();
    }

    int size(){
        return st1.size()+st2.size();
    }
}
