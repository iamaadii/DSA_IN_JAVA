/*
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
*/
package Stack_And_Queues.Monotonic;
import java.util.Stack;

public class SumOfSubarrayMinimums {

    static int bruteForce(int[] arr){
        long totalSum = 0;
        int mod = (int)(1e9+7);
        for (int i=0;i< arr.length;i++){
            int min = arr[i];
            for (int j=i;j<arr.length;j++){
                min = Math.min(min,arr[j]);
                totalSum = (totalSum+min) % mod ;
            }
        }
        return (int)totalSum;
    }







    static int optimal(int[] arr){
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
            else if(arr[st2.peek()]<ele){
                previousSmallerOrEqualElementIndex[i] = st2.peek();
            }
            st2.push(i);
        }
        long totalSum = 0;
        int mod = (int) 1e9 + 7;
        for (int i=0;i< arr.length;i++){
            int left = i-previousSmallerOrEqualElementIndex[i];
            int right = nextSmallerElementIndex[i] - i;
            long contribution = ((long) left * right % mod) * arr[i] % mod;
            totalSum = (totalSum + contribution) % mod;
        }

        return (int) totalSum;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        System.out.println(bruteForce(arr));
        System.out.println(optimal(arr));
    }
}
