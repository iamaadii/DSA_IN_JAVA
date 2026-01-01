/*
Given a directed graph with V vertices and E edges, represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and v, determine whether the graph contains a cycle or not. The graph can have multiple components.
*/
package Graphs.ProblemsOnBFSAndDFS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDirectedGraph {

    static boolean DFS(int node, ArrayList<ArrayList<Integer>> adjList, int[] visited){
        visited[node] = 1;
        for (int e: adjList.get(node)){
            if (visited[e]==0){
                if (DFS(e, adjList, visited)) return true;
            }
            else if (visited[e]==1) return true;
        }
        visited[node] = 2;
        return false;
    }
    static boolean optimal1(int nodes, int[][] edges){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
        }
        for (int i=0;i<edges.length;i++){
            int e1 = edges[i][0];
            int e2 = edges[i][1];
            adjList.get(e1).add(e2);
        }

        int[] visited = new int[nodes];
        for (int i=0;i<nodes;i++){
            if (visited[i]==0){
                if(DFS(i,adjList,visited))
                    return true;
            }
        }
        return false;
    }







    static boolean BFS(int node, ArrayList<ArrayList<Integer>> adjList, int[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = 1;

        while (!q.isEmpty()){
            int curr = q.poll();
            for (int e: adjList.get(curr)){
                if (visited[e]==0){
                    if(BFS(e,adjList,visited))
                        return true;
                }
                else if(visited[e]==visited[curr]){
                    return true;
                }
            }
        }
        visited[node] = 2;
        return false;
    }
    static boolean optimal2(int nodes, int[][] edges){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
        }
        for (int i=0;i<edges.length;i++){
            int e1 = edges[i][0];
            int e2 = edges[i][1];
            adjList.get(e1).add(e2);
        }

        int[] visited = new int[nodes];
        for (int i=0;i<nodes;i++){
            if (visited[i]==0){
                if(BFS(i,adjList,visited))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{3,0},{4,2},{2,1}};
        System.out.println(optimal1(5,edges));
        System.out.println(optimal2(5,edges));
    }
}
