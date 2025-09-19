/*
Given a sorted array arr[] and an integer x, find the index (0-based) of the smallest element in arr[] that is greater than or
equal to x. This element is called the ceil of x. If such an element does not exist, return -1.
Note: In case of multiple occurrences of ceil of x, return the index of the first occurrence.
*/
package BinarySearch.On1DArray;

public class Ceil {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 11, 12, 19};
        int target = 5;
        System.out.println(bruteForce(arr,target));
        System.out.println(optimal(arr,target));
    }

    static int bruteForce(int[] arr, int target) {
        int res = -1;
        for (int i=0;i<arr.length;i++){
            if(arr[i]>=target) {
                res = i;
                break;
            }
        }
        return res;
    }

    static int optimal(int[] arr, int target) {
        int res = -1;
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
