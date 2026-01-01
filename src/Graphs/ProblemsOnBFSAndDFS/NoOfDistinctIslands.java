/*
Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).
*/
package Graphs.ProblemsOnBFSAndDFS;
import java.util.*;

public class NoOfDistinctIslands {
    static class Pair{
        int row,col;
        Pair(int r,int c){
            row = r; col=c;
        }
    }

    static void traversal(int i, int j, int[][] grid, int[][] vis,int[] nrows, int[] ncols, Set<ArrayList<ArrayList<Integer>>> s){
        Queue<Pair> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        q.add(new Pair(i,j));
        l.add(new ArrayList<>(Arrays.asList(0,0)));
        vis[i][j]=1;

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int cr = curr.row;
            int cc = curr.col;

            for(int iter=0; iter<4; iter++){
                int nrow = cr+nrows[iter];
                int ncol = cc+ncols[iter];

                if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[cr].length){
                    if(grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                        q.add(new Pair(nrow,ncol));
                        vis[nrow][ncol] = 1;
                        l.add(new ArrayList<>(Arrays.asList(nrow-i,ncol-j)));                   }
                }
            }
        }
        s.add(l);
    }

    static int optimal(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int[] nrows = {0,1,0,-1};
        int[] ncols = {-1,0,1,0};

        Set<ArrayList<ArrayList<Integer>>> s = new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(vis[i][j]==0 && grid[i][j]==1)
                    traversal(i,j,grid,vis,nrows,ncols,s);
            }
        }
        return s.size();
    }


    public static void main(String[] args) {
        int[][] grid = {
                            {1, 1, 0, 0, 0, 1, 1},
                            {1, 0, 0, 0, 0, 1, 0},
                            {0, 0, 0, 1, 1, 0, 0},
                            {0, 0, 0, 1, 0, 0, 0},
                            {1, 1, 0, 0, 0, 1, 1},
                            {1, 0, 0, 0, 0, 1, 0}
                        };
        System.out.println(optimal(grid));
    }
}
