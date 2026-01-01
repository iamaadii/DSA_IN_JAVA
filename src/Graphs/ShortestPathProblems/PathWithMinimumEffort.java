/*
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
*/

package Graphs.ShortestPathProblems;
import java.util.*;
public class PathWithMinimumEffort {
    static class Pair{
        int row, col, diff;
        Pair(int r, int c, int d){
            row=r; col=c; diff = d;
        }
    }
    public static int optimal(int[][] matrix) {
        int n = matrix.length; int m = matrix[0].length;
        int[][] diffArr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) diffArr[i][j] = Integer.MAX_VALUE;
        }
        int[] rows = {0,-1,0,1}; int[] columns = {-1,0,1,0};
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.diff-b.diff);
        pq.add(new Pair(0,0,0));
        diffArr[0][0] = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int currRow = p.row;
            int currCol = p.col;
            int currDiff = p.diff;
            if(currRow==n-1 && currCol==m-1){
                return currDiff;
            }
            for(int i=0;i<4;i++){
                int neiRow = rows[i] + currRow; int neiCol = columns[i] + currCol;
                if(neiRow>=0 && neiRow<n && neiCol>=0 && neiCol<m){
                    int diff = Math.abs(matrix[neiRow][neiCol] - matrix[currRow][currCol]);
                    int newEffort = Math.max(diff, currDiff);
                    if (newEffort < diffArr[neiRow][neiCol]) {
                        diffArr[neiRow][neiCol] = newEffort;
                        pq.add(new Pair(neiRow, neiCol, newEffort));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(optimal(matrix));
    }
}
