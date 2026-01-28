/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
*/
package Stack_And_Queues.Monotonic;
import java.util.Stack;

public class LargestRectangleAreaInHistogram {

    static void optimal1(int[] arr){
        int[] nextSmallerElementIndex = new int[arr.length];
        Stack<Integer> st1 = new Stack<>();
        for (int i=arr.length-1;i>=0;i--){
            while(!st1.isEmpty() &&  arr[st1.peek()] >= arr[i]){
                st1.pop();
            }
            if(st1.isEmpty()){
                nextSmallerElementIndex[i] = arr.length;
            }
            else if(arr[st1.peek()] < arr[i]){
                nextSmallerElementIndex[i] = st1.peek();
            }
            st1.push(i);
        }

        int[] previousSmallerElementIndex = new int[arr.length];
        Stack<Integer> st2 = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while(!st2.isEmpty() &&  arr[st2.peek()] >= arr[i]){
                st2.pop();
            }
            if(st2.isEmpty()){
                previousSmallerElementIndex[i] = -1;
            }
            else if(arr[st2.peek()] < arr[i]){
                previousSmallerElementIndex[i] = st2.peek();
            }
            st2.push(i);
        }

        int res = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int size = Math.abs(previousSmallerElementIndex[i]-nextSmallerElementIndex[i]+1);
            res = Math.max(res,size*arr[i]);
        }
        System.out.println(res);
    }


    static void optimal2(int[] arr){
        Stack<Integer> st = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() &&  arr[st.peek()] > arr[i]){
                int element = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                int area = (nse - pse - 1) * arr[element];
                maxArea = Math.max(maxArea,area);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int element = st.pop();
            int nse = arr.length;
            int pse = st.isEmpty() ? -1 : st.peek();
            int area = (nse - pse - 1) * arr[element];
            maxArea = Math.max(maxArea,area);
        }
        System.out.println(maxArea);
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        optimal1(arr);
        optimal2(arr);
    }
}
