/*
Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u, v, w] represents the edge between the nodes u and v having w edge weight.
You have to find the shortest distance of all the vertices from the source vertex src, and return an array of integers where the ith element denotes the shortest distance between ith node and source vertex src.

Note: The Graph is connected and doesn't contain any negative weight edge.
It is guaranteed that all the shortest distance will fit in a 32-bit integer.
*/
package Graphs.ShortestPathProblems;
import java.util.*;

public class DjisktraAlgorithm {

    static class Pair{
        int node;
        int dist;
        Pair(int n, int d){
            node = n;
            dist = d;
        }
    }

    static int[] optimal1(int V, int[][] edges, int src){
        List<List<Pair>> adj = new ArrayList<>();
        for (int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }

        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        q.add(new Pair(src,0));
        dist[src] = 0;
        while (!q.isEmpty()){
            Pair curr = q.poll();
            int vertex = curr.node;
            int weight = curr.dist;
            for (Pair p: adj.get(vertex)){
                int neiNode = p.node;
                int neiDist = p.dist;
                if (dist[neiNode] > weight+neiDist){
                    dist[neiNode] = weight+neiDist;
                    q.add(new Pair(neiNode,dist[neiNode]));
                }
            }
        }
        return dist;
    }






    static int[] optimal2(int V, int[][] edges, int src){
        List<List<Pair>> adj = new ArrayList<>();
        for (int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }

        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);

        TreeSet<Pair> ts = new TreeSet<>((a, b) -> {
            if (a.dist != b.dist)
                return a.dist - b.dist;
            return a.node - b.node; // tie-breaker
        });
        ts.add(new Pair(src,0));
        dist[src] = 0;

        while (!ts.isEmpty()){
            Pair curr = ts.pollFirst();
            int vertex = curr.node;
            int weight = curr.dist;
            for (Pair p: adj.get(vertex)){
                int neiNode = p.node;
                int neiDist = p.dist;
                if (dist[neiNode] > weight+neiDist){
                    if (dist[neiNode]!=Integer.MAX_VALUE){
                        ts.remove(new Pair(neiNode,dist[neiNode]));
                    }
                    dist[neiNode] = weight+neiDist;
                    ts.add(new Pair(neiNode,dist[neiNode]));
                }
            }
        }
        return dist;
    }


    public static void main(String[] args) {
        int[][] edges = {{0, 1, 1}, {1, 2, 3}, {0, 2, 6}};
        System.out.println(Arrays.toString(optimal1(3,edges,2)));
        System.out.println(Arrays.toString(optimal2(3,edges,2)));
    }
}
