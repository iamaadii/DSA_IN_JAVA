/*
Given a strictly sorted 2D matrix mat[][] of size n x m and a number x. Find whether the number x is present
in the matrix or not.
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.

Constraints:
1 ≤ n, m ≤ 1000
1 ≤ mat[i][j] ≤ 10^9
1 ≤ x ≤ 10^9

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
*/
package BinarySearch.On2DArrays;

public class SearchInSortedMatrix1 {
    public static void main(String[] args) {
        int[][] arr = {
                    {3,4,7,9},
                    {12,13,16,18},
                    {20,21,23,29}
                };
        int target = 23;
        System.out.println(bruteForce(arr,target));
        System.out.println(better(arr,target));
        System.out.println(optimal(arr,target));
    }

    static boolean bruteForce(int[][] arr, int target){
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                if(arr[i][j]==target) return true;
            }
        }
        return false;
    }


    static boolean binarySearch(int[] arr, int target){
        int low = 0, high = arr.length-1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target)
                return true;
            else if(target > arr[mid]) low=mid+1;
            else high=mid-1;
        }
        return false;
    }

    static boolean better(int[][] arr, int target){
        int n = arr.length, m=arr[0].length;
        for (int i=0;i<n;i++){
            if(arr[i][0]<=target && target<=arr[i][m-1])
                return binarySearch(arr[i],target);
        }
        return false;
    }

    static boolean optimal(int[][] arr, int target){
        int n = arr.length, m=arr[0].length;
        int low =0, high = (m*n)-1;
        while (low<=high){
            int mid = low+(high-low)/2;
            int row = mid/m, col=mid%m;
            if (arr[row][col]==target) return true;
            else if(arr[row][col]<target) low=mid+1;
            else high=mid-1;
        }
        return false;
    }
}
