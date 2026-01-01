/*
There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.
You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.
Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
*/
package Graphs.MSTAndDisjointSet;
import java.util.*;

public class MinNumberOfOperationRequiredToMakeComponentsConnected {
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
            if (node== parent.get(node)){
                return node;
            }
            int up = findUltimateParent(parent.get(node));
            parent.set(node,up);
            return parent.get(node);
        }

        void unionBySize(int u, int v, int[] extraEdges){
            int ultimateU = findUltimateParent(u);
            int ultimateV = findUltimateParent(v);

            if (ultimateV==ultimateU) {
                extraEdges[0] += 1;
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
    static int optimal(int n, int[][] edges){
        DisjointSet obj = new DisjointSet(n);
        int[] extraEdges = {0};
        for (int i=0;i< edges.length;i++){
            obj.unionBySize(edges[i][0],edges[i][1],extraEdges);
        }

        int totalComponents = 0;
        for (int i=0;i<n;i++){
            if (obj.parent.get(i)==i)
                totalComponents+=1;
        }
        if (extraEdges[0] >= totalComponents-1) return totalComponents-1;
        return -1;
    }

    public static void main(String[] args) {

    }
}
