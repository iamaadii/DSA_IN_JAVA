/*
Given a sorted and rotated array arr[] of distinct elements, the task is to find the index of a target key.
If the key is not present in the array, return -1.
*/

package BinarySearch.On1DArray;

public class SearchInRotatedSortedArray_1 {
    public static void main(String[] args) {
        int[] arr = {7,8,9,1,2,3,4,5,6};
        int target = 5;
        System.out.println(Optimal(arr,target));
    }
    static int Optimal(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        while (low<=high)
        {
            int mid = low+(high-low)/2;

            if(arr[mid]==target)  return mid;

            else if(arr[low]<=arr[mid])
                if(target>=arr[low] && target<=arr[mid])    high = mid-1;
                else low = mid+1;

            else
                if(target>=arr[mid] && target<=arr[high])   low = mid+1;
                else high = mid-1;
        }
        return -1;
    }
}
