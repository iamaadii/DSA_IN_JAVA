/*
You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
Return the size of the largest island in grid after applying this operation.
An island is a 4-directionally connected group of 1s.
*/
package Graphs.MSTAndDisjointSet;
import java.util.*;
public class MakeALargeIsland {
    static class Disjoint {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        Disjoint(int n) {
            for (int i = 0; i < n; i++) {
                size.add(1);
                parent.add(i);
            }
        }
        int findUltimateParent(int node){
            if (node== parent.get(node)) return node;
            int up = findUltimateParent(parent.get(node));
            parent.set(node,up);
            return parent.get(node);
        }
        void unionBySize(int u, int v){
            int ultimateU = findUltimateParent(u); int ultimateV = findUltimateParent(v);
            if (ultimateV==ultimateU) return;

            int sizeU = size.get(ultimateU); int sizeV = size.get(ultimateV);
            if(sizeV < sizeU){
                parent.set(ultimateV,ultimateU);
                size.set(ultimateU,sizeU+sizeV);
            }
            else{
                parent.set(ultimateU,ultimateV);
                size.set(ultimateV,sizeV+sizeU);
            }
        }

    }
    static int optimal(int[][] grid) {
        int n = grid.length;
        Disjoint obj = new Disjoint(n*n);
        int[] rows = {-1,0,1,0}; int[] cols = {0,-1,0,1};
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) l.add(Arrays.asList(i,j));
                else if (grid[i][j] == 1) {
                    int u = i * n + j;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + rows[d];
                        int nc = j + cols[d];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            int v = nr * n + nc;
                            obj.unionBySize(u, v);
                        }
                    }
                }
            }
        }

        if(l.isEmpty()) return n*n;
        int ans = 0;
        for(int i=0;i<l.size();i++){
            int r = l.get(i).get(0); int c = l.get(i).get(1);
            int temp = 1;
            Set<Integer> st = new HashSet<>();
            for(int iter = 0;iter<4;iter++){
                int nr = rows[iter]+r;
                int nc = cols[iter]+c;
                if(nr>=0 && nr<n && nc>=0 && nc<n){
                    if(grid[nr][nc]==1) st.add(obj.findUltimateParent(nr*n+nc));
                }
            }
            for(int val: st){
                temp += obj.size.get(val);
            }
            ans = Math.max(ans,temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0},{0,1}};
        System.out.println(optimal(grid));
    }
}
