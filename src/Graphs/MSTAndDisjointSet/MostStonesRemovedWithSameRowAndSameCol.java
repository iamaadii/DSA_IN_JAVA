/*
On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.
*/
package Graphs.MSTAndDisjointSet;
import java.util.*;
public class MostStonesRemovedWithSameRowAndSameCol {

    static class DisjointSet {
        int[] size;
        int[] parent;

        int findUltimateParent(int node){
            if(parent[node]==node){
                return node;
            }
            return parent[node] = findUltimateParent(parent[node]);
        }


        void unionBySize(int u, int v){
            int ultimateU = findUltimateParent(u);
            int ultimateV = findUltimateParent(v);

            if(ultimateU==ultimateV) return;

            int sizeU = size[ultimateU];
            int sizeV = size[ultimateV];

            if(sizeU<sizeV){
                parent[ultimateU] = ultimateV;
                size[ultimateV] += size[ultimateU];
            }
            else{
                parent[ultimateV] = ultimateU;
                size[ultimateU] += size[ultimateV];
            }
        }

        DisjointSet(int n) {
            size = new int[n];
            parent = new int[n];
            for (int i = 0; i<n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }
    }

    public static int approach1(int[][] stones) {
        int n = stones.length;
        DisjointSet d = new DisjointSet(n);
        for (int u = 0; u < n; u++) {
            int r = stones[u][0];
            int c = stones[u][1];
            for (int v = u + 1; v < n; v++) {
                if (stones[v][0] == r || stones[v][1] == c) {
                    d.unionBySize(u, v);
                }
            }
        }
        int totalComp = 0;
        for (int i = 0; i < n; i++) {
            if (d.findUltimateParent(i) == i) {
                totalComp += 1;
            }
        }
        return n - totalComp;
    }

    static int approach2(int[][] stones) {
        int n = stones.length;
        int totalRows = 0;
        int totalCols = 0;
        for (int i = 0; i < n; i++) {
            totalRows = Math.max(totalRows, stones[i][0]);
            totalCols = Math.max(totalCols, stones[i][1]);
        }

        int m = totalRows + totalCols + 2;
        DisjointSet obj = new DisjointSet(m);
        for (int i = 0; i < n; i++) {
            int row = stones[i][0];
            int col = stones[i][1] + totalRows + 1;
            obj.unionBySize(row, col);
        }

        int totalComp = 0;
        for (int i = 0; i < m; i++) {
            int ultimate = obj.findUltimateParent(i);
            if (ultimate == i && obj.size[ultimate] > 1) {
                totalComp += 1;
            }
        }
        return stones.length - totalComp;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,1}};
        System.out.println(approach1(edges));
        System.out.println(approach2(edges));
    }
}
