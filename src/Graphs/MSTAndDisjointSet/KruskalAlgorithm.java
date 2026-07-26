package Graphs.MSTAndDisjointSet;

import java.util.*;
public class KruskalAlgorithm {
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

    static void optimal(int n, int[][] edges){
        Arrays.sort(edges,(a,b)->a[2]-b[2]);

        DisjointSet d = new DisjointSet(n);
        List<List<Integer>> connectedEdges = new ArrayList<>();
        int totalWeight = 0;
        for (int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            int ultimateU = d.findUltimateParent(u);
            int ultimateV = d.findUltimateParent(v);

            if(ultimateU != ultimateV){
                d.unionByRank(edges[i][0],edges[i][1]);
                totalWeight += w;
                List<Integer> temp = new ArrayList<>();
                temp.add(u);
                temp.add(v);
                connectedEdges.add(temp);
            }

        }
        System.out.println(totalWeight);
        System.out.println(connectedEdges);
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,2},{0,2,1},{2,1,1},{2,4,2},{2,3,2},{4,3,1}};
        optimal(5,edges);
    }
}
