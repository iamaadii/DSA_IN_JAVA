/*
Given an undirected graph with v vertices(numbered from 1 to v) and e edges. Find the number of good components in the graph.
A component of the graph is good if and only if the component is fully connected.
Note: A fully connected component is a subgraph of a given graph such that there's an edge between every pair of vertices in the component, the given graph can be a disconnected graph.
*/
package Graphs.OtherAlgorithm;
import java.util.*;
public class NumberOfGoodComponents {

    static void dfs(int n, List<List<Integer>> adj, int[] vis,List<Integer> l){
        vis[n] = 1;
        l.add(n);
        for(int e: adj.get(n)){
            if(vis[e]==0){
                dfs(e,adj,vis,l);
            }
        }
    }

    public static int optimal(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] degree = new int[V+1];
        for(int i=0;i<V+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]+=1;
            degree[v]+=1;
        }

        int[] vis = new int[V+1];
        List<List<Integer>> components = new ArrayList<>();
        for(int i=1;i<vis.length;i++){
            if(vis[i]==0){
                List<Integer> l = new ArrayList<>();
                dfs(i,adj,vis,l);
                components.add(l);
            }
        }
        System.out.println(components);
        System.out.println(Arrays.toString(degree));

        int noOfGoodComponents = 0;
        for(List<Integer> component: components){
            int size = component.size();
            boolean flag = true;
            for(int node: component){
                if (degree[node] != size - 1) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                noOfGoodComponents+=1;
            }
        }
        return noOfGoodComponents;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2} ,{7, 2}, {3, 5}, {3, 4}, {4, 5}};
        System.out.println(optimal(7,edges));
    }
}
