/*
Given a Directed Acyclic Graph of V vertices from 0 to n-1 and a 2D Integer array(or vector) edges[ ][ ] of length E, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.
Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.
*/
package Graphs.ShortestPathProblems;
import java.util.*;
public class ShortestDistanceFromSrcToAllOtherNodesInDAG {

    static class Pair{
        int ev;
        int wei;
        Pair(int v, int w){
            ev = v;
            wei = w;
        }
    }
    static void topoSort(int node, Stack<Integer> s,ArrayList<ArrayList<Pair>> adj, int[] vis){
        vis[node] = 1;
        for(Pair p: adj.get(node)){
            if(vis[p.ev] == 0){
                topoSort(p.ev,s,adj,vis);
            }
        }
        s.push(node);
    }

    static int[] optimal(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<E;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }

        Stack<Integer> s = new Stack<>();
        int[] vis = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0)
                topoSort(i,s,adj,vis);
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while(!s.isEmpty()){
            int curr = s.pop();
            if (dist[curr] != Integer.MAX_VALUE) {
                for(Pair p: adj.get(curr)){
                    int v = p.ev;
                    if( (dist[curr]+p.wei) < dist[v]){
                        dist[v] = dist[curr]+p.wei;
                    }
                }
            }
        }

        for(int i=0;i<V;i++){
            if(dist[i]==Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }
    public static void main(String[] args) {
        int[][] edges = {{0,1,2},{0,2,1}};
        System.out.println(Arrays.toString(optimal(4,2,edges)));
    }
}
