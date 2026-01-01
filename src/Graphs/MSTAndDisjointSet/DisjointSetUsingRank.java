package Graphs.MSTAndDisjointSet;

import java.util.*;

public class DisjointSetUsingRank {
     static class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                rank.add(0);
                parent.add(i);
            }
        }
        int findUltimateParent(int node){
            if (node== parent.get(node))  return node;
            int up = findUltimateParent(parent.get(node));
            parent.set(node,up);
            return parent.get(node);
        }

        void unionByRank(int u, int v){
            int ultimateU = findUltimateParent(u); int ultimateV = findUltimateParent(v);
            if (ultimateU==ultimateV) return;

            int rankU = rank.get(ultimateU);int rankV = rank.get(ultimateV);
            if(rankU < rankV)  parent.set(ultimateU,ultimateV);
            else if(rankV < rankU)  parent.set(ultimateV,ultimateU);
            else{
                parent.set(ultimateV,ultimateU);
                rank.set(ultimateU,rankU+1);
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
