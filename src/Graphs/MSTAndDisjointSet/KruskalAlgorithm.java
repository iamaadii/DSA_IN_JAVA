package Graphs.MSTAndDisjointSet;

import java.util.*;
public class KruskalAlgorithm {
    static class DisJointSet{
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        DisJointSet(int n){
            for (int i = 0; i < n; i++) {
                size.add(1);
                parent.add(i);
            }
        }

        int findUltimate(int node){
            if (parent.get(node)==node){
                return node;
            }
            int temp = findUltimate(parent.get(node));
            parent.set(node,temp);
            return temp;
        }

        void unionBySize(int u, int v, int w, int[] sum, List<List<Integer>> res){
            int uRootNode = findUltimate(u);
            int vRootNode = findUltimate(v);

            if (uRootNode==vRootNode) return;

            sum[0] += w;
            res.add(Arrays.asList(u,v));
            int uSize = size.get(uRootNode);
            int vSize = size.get(vRootNode);

            if (vSize < uSize){
                parent.set(vRootNode,uRootNode);
                size.set(uRootNode,uSize+vSize);
            }
            else{
                parent.set(uRootNode,vRootNode);
                size.set(vRootNode,uSize+vSize);
            }
        }
    }

    static void optimal(int n, int[][] edges){
        DisJointSet obj = new DisJointSet(n);
        Arrays.sort(edges,(a,b)->a[2]-b[2]);

        List<List<Integer>> result = new ArrayList<>();
        int[] sum = {0};
        for (int i=0;i<edges.length;i++){
            obj.unionBySize(edges[i][0],edges[i][1],edges[i][2],sum,result);
        }

        System.out.println(sum[0]);
        System.out.println(result);
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1,2},{0,2,1},{2,1,1},{2,4,2},{2,3,2},{4,3,1}};
        optimal(5,edges);
    }
}
