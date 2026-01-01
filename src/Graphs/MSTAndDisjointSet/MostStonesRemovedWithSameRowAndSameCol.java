/*
On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.
*/
package Graphs.MSTAndDisjointSet;
import java.util.*;
public class MostStonesRemovedWithSameRowAndSameCol {
    static class Disjoint{
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        Disjoint(int n) {
            for (int i = 0; i < n; i++) {
                size.add(1);
                parent.add(i);
            }
        }
        int findUltimateParent(int node){
            if (node== parent.get(node)){
                return node;
            }
            int up = findUltimateParent(parent.get(node));
            parent.set(node,up);
            return parent.get(node);
        }

        void unionBySize(int u, int v){
            int ultimateU = findUltimateParent(u);
            int ultimateV = findUltimateParent(v);

            if (ultimateV==ultimateU) {
                return;
            }

            int sizeU = size.get(ultimateU);
            int sizeV = size.get(ultimateV);

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
    static void optimal(int[][] stones) {
        int totalRows = 0;
        int totalCols = 0;
        for(int i=0;i<stones.length;i++){
            totalRows = Math.max(totalRows,stones[i][0]);
            totalCols = Math.max(totalCols,stones[i][1]);
        }

        int n= totalRows+totalCols+2;
        HashMap<Integer,Integer> mp = new HashMap<>();
        Disjoint obj = new Disjoint(n);
        for(int i=0;i<stones.length;i++){
            int row = stones[i][0];
            int col = stones[i][1] + totalRows + 1;
            obj.unionBySize(row,col);
            mp.put(row,1);
            mp.put(col,1);
        }

        int count = 0;
        for (Map.Entry<Integer,Integer> e: mp.entrySet()){
            if (obj.findUltimateParent(e.getKey()) == e.getKey()){
                count+=1;
            }
        }
        System.out.println(stones.length - count);
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,1}};
        optimal(edges);
    }
}
