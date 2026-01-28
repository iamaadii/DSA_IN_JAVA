/*
You are given an array arr[] of integers, the task is to find the next smaller element for each element of the array in order of their appearance in the array. Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
If there does not exist next greater of current element, then next smaller element for current element is -1.
*/
package Stack_And_Queues.Monotonic;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerElement {
    static ArrayList<Integer> optimal(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int i=arr.length-1;i>=0;i--){
            int ele = arr[i];

            while(!st.isEmpty() && st.peek()>=ele){
                st.pop();
            }
            if(!st.isEmpty() && st.peek()<ele){
                res.add(st.peek());
            }
            else if(st.isEmpty()) res.add(-1);
            st.push(ele);
        }

        for(int i=0;i<res.size()/2;i++){
            int temp = res.get(i);
            res.set(i,res.get(res.size()-1-i));
            res.set(res.size()-1-i,temp);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        System.out.println(optimal(arr));
    }
}
