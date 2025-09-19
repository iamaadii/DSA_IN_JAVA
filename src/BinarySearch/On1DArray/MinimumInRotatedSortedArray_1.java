/*
A sorted array of distinct elements arr[] is rotated at some unknown point, the task is to find the minimum element in it.
*/
package BinarySearch.On1DArray;

public class MinimumInRotatedSortedArray_1 {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(Optimal(arr));
    }

    static int Optimal(int[] arr){
        int low = 0, high = arr.length-1;
        int temp = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low+(high-low)/2;

            //If search space is already sorted then arr[low] will be smaller in that search space
           if(arr[low]<=arr[mid] && arr[mid]<=arr[high]){
                temp = Math.min(temp,arr[low]);
                break;
            }
            else if (arr[low]<=arr[mid]){
                temp = Math.min(arr[low],temp);
                low = mid+1;
            }
            else {
                temp = Math.min(arr[mid],temp);
                high = mid-1;
            }
        }
        return temp;
    }
}