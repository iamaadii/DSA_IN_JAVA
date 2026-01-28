/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Implement the MinStack class:
    MinStack() initializes the stack object.
    void push(int val) pushes the element val onto the stack.
    void pop() removes the element on the top of the stack.
    int top() gets the top element of the stack.
    int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.
*/

package Stack_And_Queues.Learning;
import java.util.*;

class MinStack_I {
    Stack<Integer> st;
    Stack<Integer> min;
    public MinStack_I() {
        st = new Stack<>();
        min = new Stack<>();
        min.push(Integer.MAX_VALUE);
    }
    public void push(int val) {
        st.push(val);
        min.push(Math.min(val, min.peek()));
    }
    public void pop() {
        st.pop();
        min.pop();
    }
    public int top() {
        return st.peek();
    }
    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack_I s = new MinStack_I();
        s.push(2);
        s.push(1);
        s.push(4);
        s.push(1);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();


    }
}
