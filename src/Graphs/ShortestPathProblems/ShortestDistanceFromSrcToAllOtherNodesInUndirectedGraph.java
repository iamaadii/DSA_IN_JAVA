/*
You are given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where each element edges[i] = [u, v] represents an undirected edge between vertices u and v.
Your task is to find the shortest path distance from a given source vertex src to all other vertices in the graph.
If a vertex is not reachable from the source, return -1 for that vertex.
Note: All edges have unit weight (1).
*/
package Graphs.ShortestPathProblems;
import java.util.*;
public class ShortestDistanceFromSrcToAllOtherNodesInUndirectedGraph {
    static void bfs(int node, int[] vis, int[] dist, ArrayList<ArrayList<Integer>> adj, int src ){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = 1;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int v: adj.get(curr)){
                if(vis[v]==0){
                    q.add(v);
                    vis[v] = 1;
                    dist[v] = dist[curr] + 1;
                }
            }
        }
    }

    static int[] optimal(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[V];
        int[] dist = new int[V];
        Arrays.fill(dist,-1);
        dist[src] = 0;

        bfs(src,vis,dist,adj,src);
        return dist;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,3},{1,3}};
        System.out.println(Arrays.toString(optimal(4,edges,3)));
    }
}
