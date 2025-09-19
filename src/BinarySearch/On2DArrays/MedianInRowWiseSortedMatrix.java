/*
Given a row-wise sorted matrix mat[][] of size n*m, where the number of rows and columns is always odd.
Return the median of the matrix.

Constraints:
    1 ≤ n, m ≤ 400
    1 ≤ mat[i][j] ≤ 2000
*/
package BinarySearch.On2DArrays;

import java.util.Arrays;

public class MedianInRowWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };
        System.out.println(bruteForce(arr));
        System.out.println(optimal(arr));
    }

    static int bruteForce(int[][] arr){
        int n = arr.length, m = arr[0].length;
        int k = 0;
        int[] res = new int[m*n];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++)
                res[k++] = arr[i][j];
        }
        Arrays.sort(res);
        return res[res.length/2];
    }




    static int upperBound(int[]arr, int m, int x){
        int low = 0, high = m-1;
        int res = m;
        while (low<=high){
            int mid = low+(high-low)/2;
            if (arr[mid]>x){
                res = mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return res;
    }
    static int calculateSmallEquals(int[][] arr, int n, int m, int mid) {
        int count = 0;
        for (int i=0;i< n;i++){
            count += upperBound(arr[i],m,mid);
        }
        return count;
    }
    static int optimal(int[][] arr){
        int n = arr.length, m = arr[0].length;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            low = Math.min(low,arr[i][0]);
            high = Math.max(high,arr[i][m-1]);
        }

        int required = (n*m)/2;
        while (low<=high){
            int mid = low+(high-low)/2;
            int smallerEquals = calculateSmallEquals(arr,n,m,mid);
            if (smallerEquals <= required)
                low=mid+1;
            else
                high=mid-1;
        }
        return low;
    }
}
