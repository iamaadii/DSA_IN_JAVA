/*
Given a binary grid[][], where each cell contains either 0 or 1, find the distance of the nearest 0 for every cell in the grid.
The distance between two cells (i1, j1)  and (i2, j2) is calculated as |i1 - i2| + |j1 - j2|.
You need to return a matrix of the same size, where each cell (i, j) contains the minimum distance from grid[i][j] to the nearest cell having value 0.
Note: It is guaranteed that there is at least one cell with value 0 in the grid.
*/
package Graphs.ProblemsOnBFSAndDFS;
import java.util.*;
public class Matrix01 {

    static class Pair{
        int row,col,dist;
        Pair(int r,int c,int d){
            row=r; col=c; dist=d;
        }
    }
    public static void optimal(int[][] mat) {
        int[][] visited = new int[mat.length][mat[0].length];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    visited[i][j] = 1;
                }
            }
        }
        int[] rows = {-1,0,1,0};
        int[] cols = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row, c = p.col, d = p.dist;
            mat[r][c] = d;

            for(int i=0;i<4;i++){
                int nrow = r + rows[i];
                int ncol = c + cols[i];

                if(nrow>=0 && nrow<mat.length && ncol>=0 && ncol<mat[r].length){
                    if(mat[nrow][ncol]==1 && visited[nrow][ncol]==0){
                        q.add(new Pair(nrow,ncol,d+1));
                        visited[nrow][ncol]=1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        optimal(mat);
        System.out.println(Arrays.deepToString(mat));
    }
}
