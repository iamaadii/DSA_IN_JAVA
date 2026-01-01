/*
Given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where each
entry edges[i] = [u, v] denotes an edge between vertices u and v.
Your task is to return a list of all connected components. Each connected component should be represented as a list of its
vertices, with all components returned in a collection where each component is listed separately.
*/
package Graphs.ProblemsOnBFSAndDFS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NoOfConnectedComponents {
    static ArrayList<Integer> traversal(int node,int[] visited, ArrayList<ArrayList<Integer>> adjList){
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> l = new ArrayList<>();
        q.add(node);
        visited[node]=1;
        while(!q.isEmpty()){
            int curr = q.poll();
            l.add(curr);
            for (int e: adjList.get(curr)){
                if (visited[e] == 0){
                    q.add(e);
                    visited[e] = 1;
                }
            }
        }
        return l;
    }

    public static ArrayList<ArrayList<Integer>> getComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i=0;i<n;i++) adjList.add(new ArrayList<>());
        for (int i=0;i<edges.length;i++){
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            adjList.get(n1).add(n2);
            adjList.get(n2).add(n1);
        }
        int[] visited = new int[n];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                ArrayList<Integer> l = traversal(i,visited,adjList);
                res.add(l);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] edges = {{0,1},{2,1},{3,4}};
        ArrayList<ArrayList<Integer>> res = getComponents(5,edges);
        System.out.println(res);
    }
}
