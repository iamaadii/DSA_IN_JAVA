/*
Given an adjacency list, adj of Directed Graph, Find the number of strongly connected components in the graph
*/
package Graphs.OtherAlgorithm;
import java.util.*;
public class StronglyConnectedComponent {
    static void dfs1(int node, int[] vis, List<List<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1;
        for (int nei: adj.get(node)) {
            if (vis[nei] == 0) {
                dfs1(nei, vis, adj, st);
            }
        }
        st.push(node);
    }


    static void dfs2(int node, int[] vis, List<List<Integer>> adjRev) {
        vis[node] = 2;
        for (int nei: adjRev.get(node)) {
            if (vis[nei] == 1) {
                dfs2(nei, vis, adjRev);
            }
        }
    }

    public int kosaraju(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i<n; i++) {
            if (vis[i] == 0) {
                dfs1(i, vis, adj, st);
            }
        }

        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            adjRev.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            adjRev.get(edge[1]).add(edge[0]);
        }


        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (vis[node] == 1) {
                dfs2(node, vis, adjRev);
                scc += 1;
            }
        }

        return scc;
    }
}
