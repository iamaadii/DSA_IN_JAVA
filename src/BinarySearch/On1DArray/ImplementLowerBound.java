/*
Given a sorted array arr[] and a number target, the task is to find the lower bound of the target in this given array.
The lower bound of a number is defined as the smallest index in the sorted array where the element is greater than or equal
to the given number.
Note: If all the elements in the given array are smaller than the target, the lower bound will be the length of the array.
*/

package BinarySearch.On1DArray;

public class ImplementLowerBound {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 10, 11, 11, 25};
        int target = 3;
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
