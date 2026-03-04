/*
You are given a stack of integers. Your task is to sort the stack in descending order using recursion, such that the top of the stack contains the greatest element. You are not allowed to use any loop-based sorting methods (e.g., quicksort, mergesort). You may only use recursive operations and the standard stack operations (push, pop, peek/top, and isEmpty).
*/

package Recursion.GetStrongHold;
import java.util.Stack;

public class SortStackUsingRecursion {
    public void insert(Stack<Integer> stack, int temp) {
        if (stack.isEmpty() || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }

        // Pop the top element and recursively insert
        int val = stack.pop();
        insert(stack, temp);

        // Push the popped element back
        stack.push(val);
    }

    // Function to sort the stack
    public void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            insert(stack, temp);
        }
    }
}
