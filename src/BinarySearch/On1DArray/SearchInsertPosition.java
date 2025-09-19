/*
Given a sorted array arr[] (0-index based) of distinct integers and an integer k, find the index of k if it is present in the arr[].
If not, return the index where k should be inserted to maintain the sorted order.
*/
package BinarySearch.On1DArray;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int target = 2;
        System.out.println(bruteForce(arr,target));
        System.out.println(optimal(arr,target));
    }

    static int bruteForce(int[] arr, int target) {
        int res = arr.length;
        for (int i=0;i<arr.length;i++){
            if(arr[i]>=target) {
                res = i;
                break;
            }
        }
        return res;
    }

    static int optimal(int[] arr, int target) {
        int res = arr.length;
        int low = 0;
        int high = arr.length-1;

        while (low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>=target){
                res = mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return res;
    }
}
