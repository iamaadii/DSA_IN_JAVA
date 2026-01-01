/*
You are given an n × n matrix grid where grid[i][j] is the unique elevation of cell (i, j).
Rain starts falling at time t = 0. At any later time t ≥ 0, every cell is covered by water to depth t.
You may move 4-directionally (up, down, left, right) between adjacent cells instantaneously iff the elevations of both cells are ≤ t.
Starting from the top-left cell (0, 0), return the minimum time t at which you can reach the bottom-right cell (n − 1, n − 1).
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
