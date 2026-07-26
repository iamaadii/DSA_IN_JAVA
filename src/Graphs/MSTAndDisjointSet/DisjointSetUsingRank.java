package Graphs.MSTAndDisjointSet;

import java.util.*;

public class DisjointSetUsingRank {
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

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(8);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        if (ds.findUltimateParent(1)== ds.findUltimateParent(2)){
            System.out.println("same component");
        }
    }
}
