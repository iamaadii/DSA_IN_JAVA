/*
Given a sorted array of distinct positive integers arr[], You need to find the kth positive number that is missing from
the arr[].

Constraints:
1 ≤ arr.size() ≤ 10^5
1 ≤ k ≤ 105
1 ≤ arr[i] ≤ 10^6
*/
package BinarySearch.OnAnswers;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(bruteForce(arr,k));
        System.out.println(optimal(arr,k));
    }
    static int bruteForce(int[] arr, int k){
        for (int e:arr){
            if(e<=k) k+=1;
            else break;
        }
        return k;
    }


    static int optimal(int[] arr, int k){
        int low = 0, high =arr.length-1;
        while (low<=high){
            int mid = low+(high-low)/2;
            int missing = arr[mid]-(mid+1);
            if(missing<k) low=mid+1;
            else high = mid-1;
        }
        return low+k;  //high+1+k
    }
}
