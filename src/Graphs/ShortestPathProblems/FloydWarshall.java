/*
You are given a weighted directed graph, represented by an adjacency matrix, dist[][] of size n x n, where dist[i][j] represents the weight of the edge from node i to node j. If there is no direct edge, dist[i][j] is set to a large value (i.e., 108) to represent infinity.
The graph may contain negative edge weights, but it does not contain any negative weight cycles.
Your task is to find the shortest distance between every pair of nodes i and j in the graph.

Note: Modify the distances for every pair in place.
*/

package Graphs.ShortestPathProblems;
import java.util.Arrays;

public class FloydWarshall {
    public static void optimal(int[][] dist) {
        for(int iter=0;iter<dist.length;iter++){
            for(int i=0;i<dist.length;i++){
                for(int j=0;j<dist.length;j++){
                    int u = dist[i][iter];
                    int v = dist[iter][j];
                    if( (u != (int)1e8 && v!=(int)1e8 )){
                        dist[i][j] = Math.min(dist[i][j],u+v);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int max = (int) 1e8;
        int[][] adjMat = {{0, 4, max, 5, max}, {max, 0, 1, max, 6}, {2, max, 0, 3, max}, {max, max, 1, 0, 2}, {1,max, max, 4, 0}};
        System.out.println(Arrays.deepToString(adjMat));
    }
}
