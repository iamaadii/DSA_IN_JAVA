/*
Given a weighted, undirected, and connected graph with V vertices and E edges, your task is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph along with the path edges. The graph is provided as a list of edges, where each edge is represented as [u, v, w], indicating an edge between vertex u and vertex v with edge weight w.
*/
package Graphs.MSTAndDisjointSet;
import java.util.*;

public class PrimsAlgorithm {
    static class Pair{
        int node, dist;
        Pair(int n, int d){
            node=n; dist =d;
        }
    }
    static class Pair1{
        int node, dist, par;
        Pair1(int n,int p,int d){
            node=n; dist=d; par=p;
        }
    }
    static void optimal(int n,int[][] edges){
        List<List<Pair>> adj = new ArrayList<>();
        for (int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }

        List<List<Integer>> result = new ArrayList<>();
        int minSum = 0;
        int[] vis = new int[n];
        PriorityQueue<Pair1> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.add(new Pair1(0,-1,0));

        while (!pq.isEmpty()){
            Pair1 p = pq.poll();
            int currNode = p.node;
            int currPar = p.par;
            int currDis = p.dist;
            if (vis[currNode]==0) {
                vis[currNode] = 1;
                if(currPar!=-1)
                    result.add(Arrays.asList(currPar, currNode));
                minSum += currDis;

                for (Pair nei: adj.get(currNode)){
                    int neiNode = nei.node;
                    int neiDist = nei.dist;
                    if(vis[neiNode]==0){
                        pq.add(new Pair1(neiNode,currNode,neiDist));
                    }
                }
            }
        }
        System.out.println(result);
        System.out.println(minSum);
    }
    public static void main(String[] args) {
        int[][] edges = {{0,1,2},{0,2,1},{2,1,1},{2,4,2},{2,3,2},{4,3,1}};
        optimal(5,edges);
    }
}
