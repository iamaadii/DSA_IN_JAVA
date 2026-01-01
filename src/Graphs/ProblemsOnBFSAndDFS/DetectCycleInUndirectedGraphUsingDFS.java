/*
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge from vertices u to v.
*/
package Graphs.ProblemsOnBFSAndDFS;
import java.util.ArrayList;

public class DetectCycleInUndirectedGraphUsingDFS {

    static boolean traversal(int curr, int parent, ArrayList<ArrayList<Integer>> adjList, int[] visited){
        visited[curr] = 1;
        for (int e : adjList.get(curr)){
            if (visited[e]==0){
                if (traversal(e,curr,adjList,visited))
                    return true;
            }
            else if (visited[e]==1 && e!=parent){
                return true;
            }
        }
        return false;
    }

    static boolean optimal(int nodes, int[][] edges){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
        }
        for (int i=0;i<edges.length;i++){
            int e1 = edges[i][0];
            int e2 = edges[i][1];

            adjList.get(e1).add(e2);
            adjList.get(e2).add(e1);
        }

        int[] visited = new int[nodes];
        for(int i=0;i<nodes;i++){
            if(visited[i]==0){
                if(traversal(i,-1,adjList,visited))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        System.out.println(optimal(4,edges));
    }
}
