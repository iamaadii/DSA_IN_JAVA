/*
Consider a rat placed at position (0, 0) in an n x n square matrix maze[][]. The rat's goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).
The matrix contains only two possible values:
    0: A blocked cell through which the rat cannot travel.
    1: A free cell that the rat can pass through.
Your task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore, the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.
If no path exists, return an empty list.

Note: Return the final result vector in lexicographically Smallest order.
*/

package Recursion.Hard;
import java.util.*;

public class RatInAMaze {
    static void helper(int[][] maze,int row, int col,  ArrayList<String> res, StringBuilder sb,int[] rowBoundary, int[] colBoundary,int[][] vis, char[] dir){
        if(row==maze.length-1 && col==maze.length-1){
            res.add(sb.toString());
        }

        else if(maze[row][col]==1){
            vis[row][col]=1;
            for(int i=0;i<4;i++){
                int neiRow = rowBoundary[i]+row;
                int neiCol = colBoundary[i]+col;

                if(neiRow>=0 && neiRow<maze.length && neiCol>=0 && neiCol<maze.length){
                    if(maze[neiRow][neiCol]==1 && vis[neiRow][neiCol]==0){
                        sb.append(dir[i]);
                        helper(maze,neiRow,neiCol,res,sb,rowBoundary,colBoundary,vis,dir);
                        sb.deleteCharAt(sb.length()-1);
                    }
                }
            }
            vis[row][col]=0;
        }
    }
    static ArrayList<String> optimal(int[][] maze) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        int[] rowBoundary = {1,0,0,-1};
        int[] colBoundary = {0,-1,1,0};
        char[] dir = {'D','L','R','U'};
        int[][] vis = new int[maze.length][maze.length];
        helper(maze,0,0,res,new StringBuilder(),rowBoundary, colBoundary,vis, dir);
        return res;
    }


    public static void main(String[] args) {
        int[][] maze = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
        System.out.println(optimal(maze));

        int[] arr={348};
    }

}
