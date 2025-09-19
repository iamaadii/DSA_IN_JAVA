/*
You are given an array with unique elements of stalls[], which denote the positions of stalls. You are also given
an integer k which denotes the number of aggressive cows. The task is to assign stalls to k cows such that the minimum
distance between any two of them is the maximum possible.

Constraints:
2 ≤ stalls.size() ≤ 10^6
0 ≤ stalls[i] ≤ 10^8
2 ≤ k ≤ stalls.size()
*/
package BinarySearch.OnAnswers;

import java.util.Arrays;

public class AggresiveCows {
    public static void main(String[] args) {
        int[] arr = {0,3,4,7,10,9};
        int cows = 4;
        System.out.println(bruteForce(arr,cows));
        System.out.println(optimal(arr,cows));
    }

    static int bruteForce(int[] arr, int cows){
        Arrays.sort(arr);
        int ans = 1;
        for (int i = 1;i<=arr[arr.length-1]-arr[0];i++ ){
            int countCows = 1, lastCow = arr[0];
            for (int j=1;j< arr.length;j++){
                if(arr[j]-lastCow >= i){
                    countCows+=1;
                    lastCow=arr[j];
                }
            }
            if (countCows>=cows)  ans = i;
            else break;
        }
        return ans;
    }


    static int optimal(int[] arr, int cows){
        Arrays.sort(arr);
        int low = 1, high = arr[arr.length-1]-arr[0], res = 1;
        while (low<=high){
            int mid = low+(high-low)/2;
            int countCows = 1, lastCow = arr[0];
            for (int j=1;j< arr.length;j++){
                if(arr[j]-lastCow >= mid){
                    countCows+=1;
                    lastCow=arr[j];
                }
            }
            if(countCows>=cows) {
                res = mid;
                low=mid+1;
            }
            else high = mid-1;
        }
        return res;
    }
}
