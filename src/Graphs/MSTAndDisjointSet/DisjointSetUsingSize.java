package Graphs.MSTAndDisjointSet;

import java.util.*;

public class DisjointSetUsingSize {

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

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(8);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if (ds.findUltimateParent(1)== ds.findUltimateParent(2)){
            System.out.println("same component");
        } 
    }
}
