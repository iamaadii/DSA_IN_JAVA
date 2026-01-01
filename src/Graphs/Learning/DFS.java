package Graphs.Learning;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        int n = 8;
        int[][] edges = new int[][] {{1,2},{1,6},{2,3},{2,4},{6,7},{6,8},{4,5},{7,5}};

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }

        for (int i=0;i<edges.length;i++){
            int n1 = edges[i][0];
            int n2 = edges[i][1];

            adjList.get(n1).add(n2);
            adjList.get(n2).add(n1);
        }

        ArrayList<Integer> traversal = new ArrayList<>();
        int[] visited = new int[n+1];

        int startingNode = 1;
        Stack<Integer> st = new Stack<>();
        st.push(startingNode);
        visited[startingNode] = 1;

        while (!st.isEmpty()){
            int curr = st.pop();
            traversal.add(curr);
            for ( int e: adjList.get(curr)){
                if (visited[e] == 0){
                    st.push(e);
                    visited[e] = 1;
                }
            }
        }
        System.out.println(traversal);
    }
}
