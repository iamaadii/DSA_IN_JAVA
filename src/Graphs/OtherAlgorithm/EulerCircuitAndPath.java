/*
An Eulerian Path is a path in graph that visits every edge exactly once. An Eulerian Circuit is an Eulerian Path which starts and ends on the same vertex. Given an undirected graph with V nodes, and E edges, with adjacency list adj , where adj[i] stores all the nodes that have an edge with i, return 2 if the graph contains an eulerian circuit, else if the graph contains an eulerian path, return 1, otherwise, return 0.
*/
package Graphs.OtherAlgorithm;
import java.util.ArrayList;

public class EulerCircuitAndPath {
    static void dfs(int node, int[] vis, int[][] adj) {
        vis[node] = 1;
        for (int nei: adj[node]) {
            if (vis[nei] == 0) {
                dfs(nei, vis, adj);
            }
        }
    }

    public int isEulerCircuit(int n, int[][] adj) {

        int nonZeroDegreeNode = -1;
        for (int i = 0; i<n; i++) {
            int degree = adj[i].length;
            if (degree>0) {
                nonZeroDegreeNode = i;
                break;
            }
        }

        int[] vis = new int[n];
        dfs(nonZeroDegreeNode, vis, adj);

        for (int i = 0; i<n; i++) {
            int degree = adj[i].length;
            if (vis[i] == 0 && degree>0) {
                return 0;
            }
        }



        int nodeWithOddDegree = 0;
        for (int i = 0; i<n; i++) {
            int degree = adj[i].length;
            if (degree % 2 == 1) {
                nodeWithOddDegree += 1;
            }
        }
        if (nodeWithOddDegree == 0)
            return 2;
        else if (nodeWithOddDegree == 2)
            return 1;
        else
            return 0;
    }
}
