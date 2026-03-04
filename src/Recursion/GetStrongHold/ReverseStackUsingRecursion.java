/*
You are given a stack of integers. Your task is to reverse the stack using recursion. You may only use standard stack operations (push, pop, top/peek, isEmpty). You are not allowed to use any loop constructs or additional data structures like arrays or queues.
*/

package Recursion.GetStrongHold;
import java.util.Stack;
public class ReverseStackUsingRecursion {
    public static void insertAtBottom(Stack<Integer> st, int val) {
        // If stack is empty, push the value
        if (st.isEmpty()) {
            st.push(val);
            return;
        }

        // Pop the top element
        int topVal = st.pop();

        // Recurse for the rest of the stack
        insertAtBottom(st, val);

        // Push the popped element back
        st.push(topVal);
    }

    // Function to reverse the stack
    public static void reverseStack(Stack<Integer> st) {
        // Base case: If stack is empty, return
        if (st.isEmpty()) return;

        // Pop the top element
        int topVal = st.pop();

        // Recursively reverse the remaining stack
        reverseStack(st);

        // Insert the popped element at the bottom
        insertAtBottom(st, topVal);
    }
}
