/*
There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.
You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.
Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
*/
package Graphs.MSTAndDisjointSet;

public class MinNumberOfOperationRequiredToMakeComponentsConnected {
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

    static int optimal(int n, int[][] edges){
        if(edges.length < n-1){
            return -1;
        }

        DisjointSet obj = new DisjointSet(n);
        int extraEdges = 0;
        int totalComponents = n;
        for (int i=0;i< edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(obj.findUltimateParent(u) == obj.findUltimateParent(v)){
                extraEdges+=1;
            }
            else {
                obj.unionBySize(u,v);
                totalComponents -= 1;
            }
        }
        if (extraEdges >= totalComponents-1) {
            return totalComponents-1;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
