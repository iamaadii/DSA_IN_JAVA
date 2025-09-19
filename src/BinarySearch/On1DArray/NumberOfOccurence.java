/*
Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[].
*/
package BinarySearch.On1DArray;

public class NumberOfOccurence {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;
        System.out.println(bruteForce(arr,target));
        System.out.println(optimal(arr,target));
    }
    static int bruteForce(int[] arr,int target){
        int start = -1, end=-1;
        for (int i=0;i< arr.length;i++){
            if(arr[i]==target){
                if(start==-1) {
                    start=i;
                }
                end=i;
            }
        }
        return end-start+1;
    }


    static int optimal(int[] arr,int target){
        int start = findStartIndex(arr,target);
        if(start == -1)
            return 0;

        int end = findEndIndex(arr,target);
        return end-start+1;
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
