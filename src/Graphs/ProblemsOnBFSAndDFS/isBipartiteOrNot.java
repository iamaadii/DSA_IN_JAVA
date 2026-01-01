/*
Given an adjacency list of a graph adj of V no. of vertices having 0 based index. Graph may also contain multiple components. Check whether the graph is bipartite or not.
*/
package Graphs.ProblemsOnBFSAndDFS;
import java.util.*;

public class isBipartiteOrNot {

    static boolean bfs(int node, int[][] adjList, int[] coloured){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        coloured[node] = 0;
        while (!q.isEmpty()){
            int curr = q.poll();
            for (int e: adjList[curr]){
                if (coloured[e]==-1){
                    q.add(e);
                    coloured[e] = (coloured[curr]==0) ? 1 : 0;
                }
                else if (coloured[e]==coloured[curr]) return false;
            }
        }
        return true;
    }
    static boolean optimal1(int[][] adjList){
        int[] coloured = new int[adjList.length];
        Arrays.fill(coloured, -1); //tc = O(n)

        for (int i=0;i< coloured.length;i++){
            if (coloured[i]==-1) {
                if (!bfs(i,adjList,coloured)) return false;
            }
        }
       return true;
    }







    static boolean dfs(int node,int color,int[][] adjList,int[] coloured){
        coloured[node]=color;
        for (int e: adjList[node]){
            if (coloured[e]==-1){
                int tempColor = color==0 ? 1 : 0;
                if (!dfs(e,tempColor,adjList,coloured))  return false;
            }
            else if (coloured[e]==color) return false;
        }
        return true;
    }
    static boolean optimal2(int[][] adjList){
        int[] coloured = new int[adjList.length];
        Arrays.fill(coloured, -1); //tc = O(n)
        for (int i=0;i< coloured.length;i++){
            if (coloured[i]==-1) {
                if (!dfs(i,0,adjList,coloured))
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] adjList = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(optimal1(adjList));
        System.out.println(optimal2(adjList));
    }
}
