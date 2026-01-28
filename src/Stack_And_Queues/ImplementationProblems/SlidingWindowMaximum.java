/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.
*/

package Stack_And_Queues.ImplementationProblems;
import java.util.*;

public class SlidingWindowMaximum {

    static int[] optimal(int[] nums, int k){
        Deque<Integer> st = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        int ind=0;

        for(int i=0 ;i<nums.length;i++){
            if(!st.isEmpty() && st.peekLast()<=i-k){
                st.pollLast();
            }
            while(!st.isEmpty() && nums[st.peekFirst()] <= nums[i]){
                st.pollFirst();
            }
            st.addFirst(i);

            if(i>=k-1){
                res[ind++] = nums[st.peekLast()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(optimal(arr,3)));
    }
}
