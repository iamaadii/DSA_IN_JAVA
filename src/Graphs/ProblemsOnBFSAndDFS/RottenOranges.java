/*
You are given an m x n grid where each cell can have one of three values:
    0 representing an empty cell,
    1 representing a fresh orange, or
    2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
*/
package Graphs.ProblemsOnBFSAndDFS;
import java.util.*;
public class RottenOranges {
    static class Pair{
        int row, col;
        Pair(int r,int c){
            row=r;
            col=c;
        }
    }
    static int optimal(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==2) q.add(new Pair(r,c));
            }
        }
        int minutes = 0;
        while(!q.isEmpty()){
            boolean flag = false;
            int s = q.size();
            for(int iteration=0; iteration<s; iteration++){
                Pair curr = q.poll();
                int i = curr.row; int j = curr.col;
                int lcol = j-1;
                int rcol = j+1;
                int trow = i-1;
                int brow = i+1;
                if(lcol != -1 && grid[i][lcol] == 1 ){
                    grid[i][lcol] = 2;
                    flag = true;
                    q.add(new Pair(i,lcol));
                }
                if(rcol != grid[i].length && grid[i][rcol]==1){
                    grid[i][rcol] = 2;
                    flag = true;
                    q.add(new Pair(i,rcol));
                }
                if(trow != -1 && grid[trow][j]==1){
                    grid[trow][j]=2;
                    flag=true;
                    q.add(new Pair(trow,j));
                }
                if(brow != grid.length && grid[brow][j]==1){
                    grid[brow][j]=2;
                    flag=true;
                    q.add(new Pair(brow,j));
                }
            }
            if(flag) minutes += 1;
            else break;
        }
        boolean flag = false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1) {
                    flag=true;
                    break;
                }
            }
        }
        if(flag) return -1;
        return minutes;
    }




    public static void main(String[] args) {
        int[][] matrix = new int[][]{{2,2,2,1,0}};
        System.out.println(optimal(matrix));
    }
}
