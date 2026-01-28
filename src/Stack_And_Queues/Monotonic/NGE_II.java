/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
*/

package Stack_And_Queues.Monotonic;
import java.util.*;
public class NGE_II {
    static int[] optimal(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=2*arr.length-1;i>=0;i--){
            int ele = arr[i%arr.length];

            while(!st.isEmpty() && st.peek()<=ele){
                st.pop();
            }
            if(i<arr.length){
                if(!st.isEmpty() && st.peek()>ele){
                    res[i] =st.peek();
                }
                else if(st.isEmpty()){
                    res[i]=-1;
                }
            }
            st.push(ele);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        System.out.println(Arrays.toString(optimal(arr)));
    }
}
