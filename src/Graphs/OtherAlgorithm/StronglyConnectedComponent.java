/*
Given an adjacency list, adj of Directed Graph, Find the number of strongly connected components in the graph
*/
package Graphs.OtherAlgorithm;
import java.util.*;
public class StronglyConnectedComponent {
    static void dfs1(int n,ArrayList<ArrayList<Integer>> adj,int[] vis, List<Integer> order){
        vis[n] = 1;
        for(int e: adj.get(n)){
            if(vis[e]==0){
                dfs1(e,adj,vis,order);
            }
        }
        order.add(n);
    }

    static void dfs2(int n,ArrayList<ArrayList<Integer>> adj,int[] vis){
        vis[n] = 1;
        for(int e: adj.get(n)){
            if(vis[e]==0){
                dfs2(e,adj,vis);
            }
        }
    }

   static void optimal(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] vis = new int[n];
        List<Integer> order = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(vis[i]==0) dfs1(i,adj,vis,order);
        }

        ArrayList<ArrayList<Integer>> revEdges = new ArrayList<>();
        for(int i=0;i<n;i++){
            revEdges.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            vis[i] = 0;
            for(int e: adj.get(i)){
                revEdges.get(e).add(i);
            }
        }

        int sCC = 0;
        for(int i=order.size()-1;i>=0;i--){
            if(vis[order.get(i)]==0){
                dfs2(order.get(i),revEdges,vis);
                sCC += 1;
            }
        }
       System.out.println(sCC);
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        l.add(new ArrayList<>( Arrays.asList(4,2)));
        l.add(new ArrayList<>(List.of(2)));
        l.add(new ArrayList<>(List.of(3)));
        l.add(new ArrayList<>(List.of()));
        l.add(new ArrayList<>(List.of()));

        optimal(l);
    }
}
