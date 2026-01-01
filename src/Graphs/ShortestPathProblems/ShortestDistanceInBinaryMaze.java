/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
    All the visited cells of the path are 0.
    All the adjacent cells of the path are 8-directionally connected (i.e., they are different and  they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.
*/

package Graphs.ShortestPathProblems;
import java.util.*;
public class ShortestDistanceInBinaryMaze {
    static class Pair{
        int row, col, dist;
        Pair(int r, int c, int d){
            row = r;
            col = c;
            dist = d;
        }
    }
    public static int optimal(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)
            return -1;
        if(n==1 && grid[0].length==1 && grid[0][0]==0)
            return 1;

        int[][] distArr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                distArr[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,1));
        distArr[0][0] = 1;

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            int currDis = curr.dist;

            int[] rows = {-1,0,1};
            int[] columns = {-1,0,1};

            for(int i: rows){
                for(int j: columns){
                    int neiRow = currRow+i;
                    int neiCol = currCol+j;

                    if(neiRow>=0 && neiRow<n && neiCol>=0 && neiCol<n && grid[neiRow][neiCol]==0){
                        if(distArr[neiRow][neiCol] > currDis+1){
                            q.add(new Pair(neiRow,neiCol,currDis+1));
                            distArr[neiRow][neiCol] = currDis+1;
                            if(neiRow==n-1 && neiCol==n-1){
                                return  distArr[neiRow][neiCol];
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(optimal(grid));
    }
}
