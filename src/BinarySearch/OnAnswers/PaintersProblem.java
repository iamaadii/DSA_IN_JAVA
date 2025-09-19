/*
Given an array arr[] where each element denotes the length of a board, and an integer k representing the number of
painters available. Each painter takes 1 unit of time to paint 1 unit length of a board.
Determine the minimum amount of time required to paint all the boards, under the constraint that each painter can
paint only a contiguous sequence of boards (no skipping or splitting allowed).

Constraints:
1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^4
1 ≤ k ≤ 10^5

                or

Given an array arr[] and an integer k, divide the array into k contiguous subarrays such that the maximum sum among
these subarrays is minimized. Find this minimum possible maximum sum.

Constraints:
1 ≤ k ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^4
*/
package BinarySearch.OnAnswers;

public class PaintersProblem {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40};
        int k=2;
        System.out.println(bruteForce(arr,k));
        System.out.println(optimal(arr,k));
    }

    static int bruteForce(int[] arr, int k){
        if(k> arr.length) return -1;

        int min= arr[0];
        int max = 0;
        for (int e: arr){
            min = Math.max(min,e);
            max += e;
        }

        for (int maxTime=min;maxTime<=max;maxTime++){
            int painterCount = 1, time=arr[0];
            for (int j=1;j< arr.length;j++){
                time += arr[j];
                if(time>maxTime){
                    painterCount+=1;
                    time = arr[j];
                }
            }
            if (painterCount==k) return maxTime;
        }
        return -1;
    }

    static int optimal(int[] arr, int k) {
        if(k> arr.length) return -1;

        int low= arr[0];
        int high = 0;
        for (int e: arr){
            low = Math.max(low,e);
            high += e;
        }

        int ans = low;

        while (low<=high){
            int mid = low+(high-low)/2;
            int painterCount = 1, time=arr[0];
            for (int j=1;j< arr.length;j++){
                time += arr[j];
                if(time>mid){
                    painterCount+=1;
                    time = arr[j];
                }
            }
            if (painterCount<=k){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}
