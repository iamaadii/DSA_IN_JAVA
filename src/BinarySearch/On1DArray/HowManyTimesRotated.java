/*
Given an increasing sorted rotated array arr[] of distinct integers. The array is right-rotated k times. Find the value of k.
Let's suppose we have an array arr[] = [2, 4, 6, 9], if we rotate it by 2 times it will look like this:
After 1st Rotation : [9, 2, 4, 6]
After 2nd Rotation : [6, 9, 2, 4]
*/
package BinarySearch.On1DArray;

public class HowManyTimesRotated {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(Optimal(arr));
    }

    static int Optimal(int[] arr){
        int low = 0, high = arr.length-1;
        int temp = Integer.MAX_VALUE;
        int index = -1;

        while(low <= high){
            int mid = low+(high-low)/2;

            //If search space is already sorted then arr[low] will be smaller in that search space
            if(arr[low]<=arr[mid] && arr[mid]<=arr[high]){
                if(arr[low]<temp)  index = low; temp=arr[low];
                break;
            }
            else if (arr[low]<=arr[mid]){
                if(arr[low]<temp)  index = low; temp=arr[low];
                low = mid+1;
            }
            else {
                if(arr[mid]<temp)  index = mid; temp=arr[mid];
                high = mid-1;
            }
        }
        return index;
    }
}
