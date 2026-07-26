/*
You are given a n,m which means the row and column of the 2D matrix and an array of  size k denoting the number of operations. Matrix elements is 0 if there is water or 1 if there is land. Originally, the 2D matrix is all 0 which means there is no land in the matrix. The array has k operator(s) and each operator has two integer A[i][0], A[i][1] means that you can change the cell matrix[A[i][0]][A[i][1]] from sea to island. Return how many island are there in the matrix after each operation.You need to return an array of size k.
Note : An island means group of 1s such that they share a common side.
*/
package Graphs.MSTAndDisjointSet;
import java.util.*;
public class NumberOfIslandsII {
    static class DisjointSet {
        int[] rank;
        int[] parent;
        DisjointSet(int n) {
            rank = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i]=i;
            }
        }
        int findUltimateParent(int node){
            if (node== parent[node])  return node;
            return parent[node] = findUltimateParent(parent[node]);
        }

        void unionByRank(int u, int v){
            int ultimateU = findUltimateParent(u); int ultimateV = findUltimateParent(v);
            if (ultimateU==ultimateV) return;

            int rankU = rank[ultimateU];
            int rankV = rank[ultimateV];
            if(rankU < rankV)  parent[ultimateU]=ultimateV;
            else if(rankV < rankU)  parent[ultimateV]=ultimateU;
            else{
                parent[ultimateV]=ultimateU;
                rank[ultimateU]=rankU+1;
            }
        }
    }

    static List<Integer> optimal(int rows, int cols, int[][] mat) {
        int[] rowsIdx = {0,-1,0,1};
        int[] colsIdx = {-1,0,1,0};
        int[][] vis = new int[rows][cols];
        int totalComponent = 0;
        List<Integer> ans = new ArrayList<>();
        DisjointSet d = new DisjointSet(rows*cols);
        for(int i=0;i<mat.length;i++){
            int r = mat[i][0];
            int c = mat[i][1];
            if(vis[r][c]==0){
                vis[r][c]=1;
                totalComponent += 1;
                for(int j=0;j<4;j++){
                    int nr = r+rowsIdx[j];
                    int nc = c+colsIdx[j];
                    if(nr>=0 && nr<rows && nc>=0 && nc<cols && vis[nr][nc]==1){
                        int u = cols*r+c;
                        int v = cols*nr + nc;
                        int ultimateU = d.findUltimateParent(u);
                        int ultimateV = d.findUltimateParent(v);
                        if(ultimateU != ultimateV){
                            d.unionByRank(u,v);
                            totalComponent -= 1;
                        }
                    }
                }
            }
            ans.add(totalComponent);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,1},{0,1},{3,3},{3,4}};
        System.out.println(optimal(4,5,edges));
    }
}
