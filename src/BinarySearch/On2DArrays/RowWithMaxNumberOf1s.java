/*
You are given a 2D binary array arr[][] consisting of only 1s and 0s. Each row of the array is sorted in non-decreasing
order. Your task is to find and return the index of the first row that contains the maximum number of 1s.
If no such row exists, return -1.

Note:
    The array follows 0-based indexing.
    The number of rows and columns in the array are denoted by n and m respectively.

Constraints:
1 ≤ arr.size(), arr[i].size() ≤ 10^3
0 ≤ arr[i][j] ≤ 1
*/
package BinarySearch.On2DArrays;
public class RowWithMaxNumberOf1s {
    public static void main(String[] args) {
        int[][] arr= {
                    {0,0,0,1},
                    {1,1,1,1},
                    {0,1,1,1},
                    {1,1,1,1}
                };
        System.out.println(bruteForce(arr));
        System.out.println(betterSolution(arr));
        System.out.println(optimalSolution(arr));
    }
    static int bruteForce(int[][] arr){
        int index = -1, countMax = 0;
        for (int i=0;i<arr.length;i++){
            int countOnes = 0;
            for (int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1) countOnes+=1;
            }
            if (countOnes>countMax) {
                countMax = countOnes;
                index=i;
            }
        }
        return index;
    }


    static int betterSolution(int[][] arr){
        int n = arr.length, m = arr[0].length;
        int index = -1, countMax = 0;
        for (int i=0;i<n;i++){
            int low = 0;
            int high = m-1;
            int ans = n;
            while (low<=high){
                int mid = low+(high-low)/2;
                if(arr[i][mid]>0){
                    ans = mid;
                    high=mid-1;
                }
                else if(arr[i][mid]<=0) low = mid+1;
            }

            int countOnes = m-ans;
            if (countOnes>countMax) {
                countMax = countOnes;
                index=i;
            }
        }
        return index;
    }



    static int optimalSolution(int[][] arr){
        int n = arr.length, m = arr[0].length;
        int row = 0, col = m - 1;
        int index = -1;

        while (row < n && col >= 0) {
            if (arr[row][col] == 1) {
                index = row;
                col--;
            } else {
                row++;
            }
        }
        return index;
    }
}
