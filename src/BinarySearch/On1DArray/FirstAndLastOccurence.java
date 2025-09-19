/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
*/
package BinarySearch.On1DArray;
import java.util.Arrays;

public class FirstAndLastOccurence {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 10;
        System.out.println(Arrays.toString(bruteForce(arr,target)));
        System.out.println(Arrays.toString(optimal1(arr,target)));
        System.out.println(Arrays.toString(optimal2(arr,target)));
    }

    static int[] bruteForce(int[] arr,int target){
        int start = -1,end=-1;
        for (int i=0;i< arr.length;i++){
            if(arr[i]==target){
                if(start==-1) {
                    start=i;
                }
                end=i;
            }
        }
        return new int[] {start,end};
    }





    static int[] optimal1(int[] arr,int target){
        int start = lowerBound(arr,target);
        if(start==arr.length || arr[start]!=target)
            return new int[] {-1,-1};

        int end = upperBound(arr,target);
        return new int[] {start,end-1};
    }
    static int lowerBound(int[] arr,int target){
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
    static int upperBound(int[] arr, int target){
        int res = arr.length;
        int low = 0;
        int high = arr.length-1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>target) {
                res = mid;
                high = mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return res;
    }






    static int[] optimal2(int[] arr,int target){
        int start = findStartIndex(arr,target);
        if(start == -1)
            return new int[] {-1,-1};

        int end = findEndIndex(arr,target);
        return new int[] {start,end};
    }
    static int findStartIndex(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        int start = -1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target){
                start = mid;
                high = mid-1;
            }
            else if(target>arr[mid]) low = mid+1;
            else high = mid-1;
        }
        return start;
    }
    static int findEndIndex(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        int start = -1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target){
                start = mid;
                low = mid+1;
            }
            else if(target>arr[mid]) low = mid+1;
            else high = mid-1;
        }
        return start;
    }
}
