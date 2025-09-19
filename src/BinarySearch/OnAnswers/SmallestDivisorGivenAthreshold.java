/*
Given an integer array arr[] and an integer k (where k ≥ arr.length), find the smallest positive integer divisor
such that the sum of the ceiling values of each element in arr[] divided by this divisor is less than or equal to threshold.

Constraints:
1  ≤  arr.size()  ≤ 10^5
1  ≤  arr[i]  ≤ 10^6
arr.size()  ≤ threshold  ≤ 10^6
*/

package BinarySearch.OnAnswers;

public class SmallestDivisorGivenAthreshold {
    public static void main(String[] args) {
        int[] arr = {1,2,5,9};
        int threshold = 7;
        System.out.println(bruteForce(arr,threshold));
        System.out.println(optimal(arr,threshold));
    }

    static int bruteForce(int[] arr, int threshold){
        if(threshold< arr.length) return -1;
        
        int max = arr[0];
        for (int i=0;i< arr.length;i++) max = Math.max(max,arr[i]);

        for(int i=1;i<=max;i++){
            int sum = 0;
            for (int k : arr) {
                sum += Math.ceilDiv(k, i);
            }
            if(sum<=threshold)  return i;
        }
        return -1;
    }




    static int optimal(int[] arr, int threshold){

        if(threshold < arr.length) return -1;

        int max = arr[0];

        for (int i : arr) max = Math.max(max, i);

        int res = 1;
        int low = 1, high=max;
        while (low<=high){
            int mid = low+(high-low)/2;
            int sum = 0;
            for (int j : arr)
                sum += Math.ceilDiv(j, mid);

            if(sum<=threshold) {
                res = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return res;
    }
}
