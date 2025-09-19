/*
Given a 2D matrix mat[][], identify any peak element within the matrix.
A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left,
right, top, and bottom.

Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return
the length 2 array [i,j].

You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
*/
package BinarySearch.On2DArrays;

import java.util.Arrays;

public class PeakElement {
    public static void main(String[] args) {
        int[][] arr = {
                {4,2,5,1,4,5},
                {2,9,3,2,3,2},
                {1,7,6,0,1,3},
                {3,6,2,3,7,2}
            };

        System.out.println(Arrays.toString(optimal(arr)));
    }


    static int[] optimal(int[][] arr){
        int n= arr.length, m = arr[0].length;

        int low = 0, high = m-1;
        while (low<=high){
            int mid = low+(high-low)/2;
            int row = 0;
            for (int i=1;i<n;i++)
                if(arr[i][mid]>arr[row][mid])  row=i;

            int left = -1,right = -1;
            if (mid-1 >= 0) left = arr[row][mid-1];
            if (mid+1 < m) right = arr[row][mid+1];

            if(arr[row][mid] > left && arr[row][mid] > right)
                return new int[]{row,mid};

            else if(left > arr[row][mid]) high=mid-1;

            else if(right > arr[row][mid]) low=mid+1;
        }
        return new int[]{-1,-1};
    }
}
