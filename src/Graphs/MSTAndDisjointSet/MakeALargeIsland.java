/*
You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
Return the size of the largest island in grid after applying this operation.
An island is a 4-directionally connected group of 1s.
*/
package Graphs.MSTAndDisjointSet;
import java.util.*;
public class MakeALargeIsland {
    static class DisjointSet {
        int[] size;
        int[] parent;

        int findUltimateParent(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = findUltimateParent(parent[node]);
        }

        void unionBySize(int u, int v) {
            int ultimateU = findUltimateParent(u);
            int ultimateV = findUltimateParent(v);

            if (ultimateU == ultimateV)
                return;

            int sizeU = size[ultimateU];
            int sizeV = size[ultimateV];

            if (sizeU < sizeV) {
                parent[ultimateU] = ultimateV;
                size[ultimateV] += size[ultimateU];
            } else {
                parent[ultimateV] = ultimateU;
                size[ultimateU] += size[ultimateV];
            }
        }

        DisjointSet(int n) {
            size = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }
    }
    static int optimal(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] rows = { 0, -1, 0, 1 };
        int[] cols = { -1, 0, 1, 0 };

        DisjointSet d = new DisjointSet(n * m);
        List<List<Integer>> zeroNodes = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 0) {
                    zeroNodes.add(Arrays.asList(r, c));
                }
                else if (grid[r][c] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nr = rows[k] + r;
                        int nc = cols[k] + c;

                        if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                            int u = m * r + c;
                            int v = m * nr + nc;

                            int ultimateU = d.findUltimateParent(u);
                            int ultimateV = d.findUltimateParent(v);

                            if (ultimateU != ultimateV) {
                                d.unionBySize(u, v);
                            }
                        }
                    }
                }
            }
        }

        if (zeroNodes.size() == 0){
            return n * m;
        }

        int ans = 0;
        for (List<Integer> node : zeroNodes) {
            int r = node.get(0);
            int c = node.get(1);

            Set<Integer> temp = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                int nr = rows[i] + r;
                int nc = cols[i] + c;
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                    int v = m * nr + nc;
                    int ultimateV = d.findUltimateParent(v);
                    temp.add(ultimateV);
                }
            }

            int noOfNodes = 1;
            for (int p : temp) {
                noOfNodes += d.size[p];
            }
            ans = Math.max(ans, noOfNodes);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0},{0,1}};
        System.out.println(optimal(grid));
    }
}
