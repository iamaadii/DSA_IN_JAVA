/*
You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.
Return the sum of all subarray ranges of nums.
A subarray is a contiguous non-empty sequence of elements within an array.
*/
package Stack_And_Queues.Monotonic;
import java.util.*;

public class SumOfSubarrayRanges {
    static long sumOfSubarrayMin(int[] arr){
        int[] nextSmallerElementIndex = new int[arr.length];
        Stack<Integer> st1 = new Stack<>();
        for (int i=arr.length-1;i>=0;i--){
            int ele = arr[i];
            while(!st1.isEmpty() && arr[st1.peek()]>=ele){
                st1.pop();
            }
            if(st1.isEmpty()){
                nextSmallerElementIndex[i] = arr.length;
            }
            else if(arr[st1.peek()]<ele){
                nextSmallerElementIndex[i] = st1.peek();
            }
            st1.push(i);
        }

        int[] previousSmallerOrEqualElementIndex = new int[arr.length];
        Stack<Integer> st2 = new Stack<>();
        for (int i=0;i<arr.length;i++){
            int ele = arr[i];
            while(!st2.isEmpty() && arr[st2.peek()]>ele){
                st2.pop();
            }
            if(st2.isEmpty()){
                previousSmallerOrEqualElementIndex[i] = -1;
            }
            else{
                previousSmallerOrEqualElementIndex[i] = st2.peek();
            }
            st2.push(i);
        }
        long totalSum = 0;
        for (int i=0;i< arr.length;i++){
            int left = i-previousSmallerOrEqualElementIndex[i];
            int right = nextSmallerElementIndex[i] - i;
            long contribution = (long) left * right * arr[i];
            totalSum = totalSum + contribution;
        }
        return totalSum;
    }


    static long sumOfSubarrayMax(int[] arr){
        int[] nextLargerElementIndex = new int[arr.length];
        Stack<Integer> st1 = new Stack<>();
        for (int i=arr.length-1;i>=0;i--){
            int ele = arr[i];
            while(!st1.isEmpty() && arr[st1.peek()]<=ele){
                st1.pop();
            }
            if(st1.isEmpty()){
                nextLargerElementIndex[i] = arr.length;
            }
            else if(arr[st1.peek()]>ele){
                nextLargerElementIndex[i] = st1.peek();
            }
            st1.push(i);
        }

        int[] previousLargerOrEqualElementIndex = new int[arr.length];
        Stack<Integer> st2 = new Stack<>();
        for (int i=0;i<arr.length;i++){
            int ele = arr[i];
            while(!st2.isEmpty() && arr[st2.peek()]<ele){
                st2.pop();
            }
            if(st2.isEmpty()){
                previousLargerOrEqualElementIndex[i] = -1;
            }
            else{
                previousLargerOrEqualElementIndex[i] = st2.peek();
            }
            st2.push(i);
        }
        long totalSum = 0;
        for (int i=0;i< arr.length;i++){
            int left = i-previousLargerOrEqualElementIndex[i];
            int right = nextLargerElementIndex[i] - i;
            long contribution = (long) left * right * arr[i];
            totalSum = totalSum + contribution;
        }
        return totalSum;
    }

    static long optimal(int[] arr) {
        return sumOfSubarrayMax(arr) - sumOfSubarrayMin(arr);
    }

    public static void main(String[] args) {
        int[] arr = {4,-2,-3,4,1};
        System.out.println(optimal(arr));
    }
}
