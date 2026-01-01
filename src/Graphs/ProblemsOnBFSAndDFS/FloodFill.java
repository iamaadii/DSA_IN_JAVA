/*
You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
To perform a flood fill:
1.	Begin with the starting pixel and change its color to color.
2.	Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
3.	Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
4.	The process stops when there are no more adjacent pixels of the original color to update.
Return the modified image after performing the flood fill.
*/
package Graphs.ProblemsOnBFSAndDFS;
import java.util.*;

public class FloodFill {
    static class Pair{
        int row;
        int col;

        Pair(int r, int c){
            row=r;
            col=c;
        }
    }
    static int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int[][] visited = new int[grid.length][grid[0].length];

        Queue<Pair> q = new LinkedList<>();
        int start = grid[sr][sc];
        grid[sr][sc] = color;
        visited[sr][sc] = 1;
        q.add(new Pair(sr,sc));

        while(!q.isEmpty()){
            int s= q.size();
            for(int iter=0;iter<s;iter++){
                Pair curr = q.poll();
                int i = curr.row; int j = curr.col;
                int lcol = j-1;
                int rcol = j+1;
                int trow = i-1;
                int brow = i+1;

                if(lcol != -1 && grid[i][lcol] == start && visited[i][lcol]==0){
                    grid[i][lcol] = color;
                    q.add(new Pair(i,lcol));
                    visited[i][lcol]=1;

                }
                if(rcol != grid[i].length && grid[i][rcol]==start && visited[i][rcol]==0 ){
                    grid[i][rcol] = color;
                    q.add(new Pair(i,rcol));
                    visited[i][rcol]=1;
                }
                if(trow != -1 && grid[trow][j]==start && visited[trow][j]==0 ){
                    grid[trow][j]=color;
                    q.add(new Pair(trow,j));
                    visited[trow][j]=1;
                }
                if(brow != grid.length && grid[brow][j]==start && visited[brow][j]==0 ){
                    grid[brow][j]=color;
                    q.add(new Pair(brow,j));
                    visited[brow][j]=1;
                }
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(Arrays.deepToString(floodFill(grid, 0, 0, 2)));
    }
}
