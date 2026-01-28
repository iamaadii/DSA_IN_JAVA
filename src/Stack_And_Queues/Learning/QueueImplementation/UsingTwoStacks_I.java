package Stack_And_Queues.Learning.QueueImplementation;

import java.util.Stack;

public class UsingTwoStacks_I {

    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    void push(int x){
        while (!st1.isEmpty()){
            st2.push(st1.pop());
        }
        st1.push(x);
        while (!st2.isEmpty()){
            st1.push(st2.pop());
        }
    }

    int pop(){
        return st1.pop();
    }

    int peek(){
        return st1.peek();
    }

    int size(){
        return st1.size();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

    }
}
