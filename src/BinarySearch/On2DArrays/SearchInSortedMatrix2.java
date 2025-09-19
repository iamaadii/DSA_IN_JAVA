/*
Given a 2D integer matrix mat[][] of size n x m, where every row and column is sorted in increasing order and a number x,
the task is to find whether element x is present in the matrix.

Constraints:
1 <= n, m <=1000
1 <= mat[i][j] <= 10^9
1<= x <= 10^9
*/
package BinarySearch.On2DArrays;

public class SearchInSortedMatrix2 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
            };
        System.out.println(better(arr,23));
        System.out.println(optimal(arr,23));
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
        for (int i=0;i<n;i++) {
            boolean flag = binarySearch(arr[i], target);
            if (flag) return true;
        }
        return false;
    }



    static boolean optimal(int[][] arr, int target){
        int row = 0, col = arr[0].length-1;
        while (row< arr.length && col>=0){
            if(arr[row][col]==target)
                return true;
            else if(target>arr[row][col]) row+=1;
            else col -= 1;
        }
        return false;
    }
}
