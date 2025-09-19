/*
Given a sorted and rotated array arr[] and a target key. Check whether the key is present in the array or not.
Note: The array may contains duplicate elements.
*/
package BinarySearch.On1DArray;

public class SearchInRotatedSortedArray_2 {
    public static void main(String[] args) {
        int[] arr = {3,1,2,3,3,3,3};
        int target = 3;
        System.out.println(Optimal(arr,target));
    }
    static Boolean Optimal(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        while (low<=high)
        {
            int mid = low+(high-low)/2;

            if(arr[mid]==target)  return true;

            else if(arr[low]==arr[mid] && arr[mid]==arr[high]) {
                low = low + 1;
                high = high - 1;
            }

            else if(arr[low]<=arr[mid]) {
                if(target>=arr[low] && target<=arr[mid])    high = mid-1;
                else low = mid+1;
            }

            else {
                if (target >= arr[mid] && target <= arr[high]) low = mid + 1;
                else high = mid - 1;
            }

        }
        return false;
    }
}
