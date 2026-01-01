/*
Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][], where each entry edges[i] = [u, v] denotes a directed edge u -> v. Return the topological sort for the given graph.
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be true else false.
*/
package Graphs.TopologicalSortProblems;
import java.util.*;

public class TopoSort {
    static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] vis, Stack<Integer> s){
        vis[node] = 1;
        for(int e: adjList.get(node)){
            if(vis[e]==0)
                dfs(e,adjList,vis,s);
        }
        s.push(node);
    }
    static ArrayList<Integer> optimal1(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
        }
        int[] vis = new int[V];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0)
                dfs(i,adjList,vis,s);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!s.isEmpty()){
            res.add(s.pop());
        }
        return res;
    }










    //Using bfs also known as kahn's algorithm
    static ArrayList<Integer> optimal2(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[V];
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int vStart = edges[i][0];
            int vEnd = edges[i][1];
            adjList.get(vStart).add(vEnd);
            inDegree[vEnd] += 1;
        }

        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int curr = q.poll();
            res.add(curr);
            for (int e: adjList.get(curr)){
                inDegree[e] -= 1;
                if (inDegree[e]==0){
                    q.add(e);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,0},{2,0},{3,0}};
        System.out.println(optimal1(4,edges));
        System.out.println(optimal2(4,edges));
    }
}