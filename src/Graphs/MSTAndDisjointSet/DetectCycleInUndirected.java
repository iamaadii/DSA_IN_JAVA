/*
Given an undirected graph with no self loops with V (from 0 to V-1) nodes and E edges, return true if there is any cycle in the undirected graph other wise return false.
*/
package Graphs.MSTAndDisjointSet;
import java.util.ArrayList;

public class DetectCycleInUndirected {
    static class DSU {
        int[] size;
        int[] parent;

        int ultimate(int node){
            if(parent[node]==node){
                return node;
            }
            return parent[node] = ultimate(parent[node]);
        }

        void union(int u, int v){
            int ultimateU = ultimate(u);
            int ultimateV = ultimate(v);

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

        DSU(int n) {
            size = new int[n];
            parent = new int[n];
            for (int i = 0; i<n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }
    }

    public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        DSU d = new DSU(n);
        for (int u = 0; u<n; u++) {
            for (int v: adj.get(u)) {
                if (u<v) {
                    if (d.ultimate(u) == d.ultimate(v))
                        return true;
                    d.union(u, v);
                }
            }
        }
        return false;
    }
}
