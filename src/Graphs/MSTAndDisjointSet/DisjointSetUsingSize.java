package Graphs.MSTAndDisjointSet;

import java.util.*;

public class DisjointSetUsingSize {

     static class DisjointSet {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        DisjointSet(int n) {
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
