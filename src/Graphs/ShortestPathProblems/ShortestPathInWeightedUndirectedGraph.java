/*
You are given a weighted undirected graph with n vertices numbered from 1 to n and m edges along with their weights. Find the shortest path between vertex 1 and vertex n. Each edge is given as {a, b, w}, denoting an edge between vertices a and b with weight w.
If a path exists, return a list of integers where the first element is the total weight of the shortest path, and the remaining elements are the nodes along that path (from 1 to n). If no path exists, return a list containing only {-1}.
*/
package Graphs.ShortestPathProblems;
import java.util.*;

public class ShortestPathInWeightedUndirectedGraph {

    static class Pair{
        int node;
        int dist;
        Pair(int n, int d){
            node = n;
            dist = d;
        }
    }
    static List<Integer> optimal(int V, int E, int edges[][]){
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i=0;i<V+1;i++){
            adjList.add(new ArrayList<>());
        }
        for (int i=0;i<E;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adjList.get(u).add(new Pair(v,w));
            adjList.get(v).add(new Pair(u,w));
        }

        int[] dist = new int[V+1];
        int[] par = new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.add(new Pair(1,0));
        dist[1] = 1;

        while (!pq.isEmpty()){
            Pair curr = pq.poll();
            int u = curr.node;
            int uw = curr.dist;
            for (Pair p : adjList.get(u)){
                int v = p.node;
                int vw = p.dist;
                if (uw+vw < dist[v]){
                    dist[v] = uw+vw;
                    pq.add(new Pair(v,dist[v]));
                    par[v] = u;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        if (dist[V]==Integer.MAX_VALUE) {
            res.add(-1);
            return res;
        }

        int node = V;
        res.add(node);
        while (true){
            if (node==1) break;
            int e = par[node];
            res.add(e);
            node = e;
        }
        for(int i=0;i<res.size()/2;i++){
            int j = res.size()-i-1;
            int temp = res.get(i);
            res.set(i,res.get(j));
            res.set(j,temp);
        }
        res.addFirst(dist[V]);
        return res;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        System.out.println(optimal(5,6,edges));
    }
}
