/*
There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
*/
package Graphs.TopologicalSortProblems;
import java.lang.reflect.Array;
import java.util.*;

public class FindSafeNodes {
    static boolean DFS(int node, int[][] adjList, int[] visited){
        visited[node] = 1;
        for (int e: adjList[node]){
            if (visited[e]==0){
                if (DFS(e, adjList, visited)) return true;
            }
            else if (visited[e]==1) return true;
        }
        visited[node] = 2;
        return false;
    }
    static List<Integer> optimal1(int[][] adjList){
        int[] visited = new int[adjList.length];
        for (int i=0;i< adjList.length;i++){
            if (visited[i]==0){
                DFS(i,adjList,visited);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i=0;i<visited.length;i++){
            if (visited[i]==2)
                res.add(i);
        }
        return res;
    }











    static ArrayList<Integer> optimal2(int[][] adjList){
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for (int i=0;i<adjList.length;i++){
            revAdj.add(new ArrayList<>());
        }
        int[] inDegree = new int[adjList.length];
        for (int i=0;i<adjList.length;i++){
            for (int e: adjList[i]){
                revAdj.get(e).add(i);
                inDegree[i] +=1;
            }
        }

        Queue<Integer>  q = new LinkedList<>();
        for (int i=0;i<inDegree.length;i++){
            if (inDegree[i]==0)
                q.add(i);
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()){
            int curr = q.poll();
            res.add(curr);
            for (int e: revAdj.get(curr)){
                inDegree[e] -= 1;
                if (inDegree[e]==0)
                    q.add(e);
            }
        }
        Collections.sort(res);
        return res;
    }



    public static void main(String[] args) {
        int[][] adjList = { {1,2},{2,3},{5},{0},{5},{},{} };
        System.out.println(optimal1(adjList));
        System.out.println(optimal2(adjList));
    }
}
