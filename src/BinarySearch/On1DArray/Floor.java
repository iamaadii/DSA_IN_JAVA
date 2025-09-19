/*
Given a sorted array arr[] and an integer x, find the index (0-based) of the largest element in arr[] that is less than or equal to x.
This element is called the floor of x. If such an element does not exist, return -1.
Note: In case of multiple occurrences of ceil of x, return the index of the last occurrence.
*/
package BinarySearch.On1DArray;

public class Floor {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int target = 11;
        System.out.println(bruteForce(arr,target));
        System.out.println(optimal(arr,target));
    }

    static int bruteForce(int[] arr,int x){
        int res = -1;
        for (int i=0;i< arr.length;i++){
            if (arr[i]<=x) res=i;
        }
        return res;
    }

    static int optimal(int[] arr,int x){
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]<=x){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}
