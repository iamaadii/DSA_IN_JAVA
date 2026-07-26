/*
You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).

It starts raining, and water gradually rises over time. At time t, the water level is t, meaning any cell with elevation less than equal to t is submerged or reachable.

You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.

Return the minimum time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).
*/
package Graphs.MSTAndDisjointSet;
import java.util.*;
public class SwimInRisingWater {
    static class Pair{
        int row,col,cost;
        Pair(int r, int c, int w){
            row = r;
            col = c;
            cost = w;
        }
    }
    static int optimal(int[][] grid) {
        int n = grid.length;

        int ans = Integer.MIN_VALUE;
        int[][] vis = new int[n][n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        int[] rows = {1,0,-1,0};
        int[] cols = {0,-1,0,1};
        pq.add(new Pair(0,0,grid[0][0]));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int r = p.row;
            int c = p.col;
            ans = Math.max(ans,grid[r][c]);
            if(r==n-1 && c==n-1) break;
            for(int iter=0;iter<4;iter++){
                int nr = rows[iter]+r;
                int nc = cols[iter]+c;
                if(nr>=0 && nr<n && nc>=0 && nc<n){
                    if(vis[nr][nc]==0){
                        pq.add(new Pair(nr,nc,grid[nr][nc]));
                        vis[nr][nc] = 1;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] mat = {{0,2},{1,3}};
        System.out.println(optimal(mat));
    }
}
