package Graphs.Learning;

import java.util.Arrays;

public class UsingAdjacencyMatrix {
    public static void main(String[] args) {
        int nodes = 5, edges = 6;

        int[][] adj = new int[nodes+1][nodes+1];

        //edge 1---2
        adj[1][2] = 1;
        adj[2][1] = 1;

        //edge 1---3
        adj[1][3]=1;
        adj[3][1]=1;

        //edge 2---4
        adj[2][4]=1;
        adj[4][2]=1;

        //edge 3---4
        adj[3][4]=1;
        adj[4][3]=1;

        //edge 2---5
        adj[2][5]=1;
        adj[5][2]=1;

        //edge 4---5
        adj[4][5]=1;
        adj[5][4]=1;

        for (int[] a: adj){
            System.out.println(Arrays.toString(a));
        }

    }
}
