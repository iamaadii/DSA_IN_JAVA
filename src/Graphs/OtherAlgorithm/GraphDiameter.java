/*
You are given an undirected connected graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where each element edges[i] = [u, v] represents an undirected edge between vertex u and vertex v.
Find the diameter of the graph.
The diameter of a graph (sometimes called the width) is the number of edges on the longest path between two vertices in the graph.
*/
package Graphs.OtherAlgorithm;
import java.util.*;

public class GraphDiameter {
    static void dfs(int node, int[] vis, List<List<Integer>> adj, int currDist, int[] maxDist, int[] end) {
        vis[node] = 1;

        for (int nei: adj.get(node)) {
            if (vis[nei] == 0) {
                if (currDist + 1 > maxDist[0]) {
                    maxDist[0] = currDist + 1;
                    end[0] = nei;
                }
                dfs(nei, vis, adj, currDist + 1, maxDist, end);
            }
        }
    }

    public int diameter(int n, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];
        int[] maxDist = {0};
        int[] oneEnd = {0};
        dfs(0, vis, adj, 0, maxDist, oneEnd);

        vis = new int[n];
        maxDist[0] = 0;
        int[] otherEnd = {oneEnd[0]};
        dfs(oneEnd[0], vis, adj, 0, maxDist, otherEnd);

        return maxDist[0];

    }
}
