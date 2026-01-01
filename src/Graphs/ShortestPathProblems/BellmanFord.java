/*
Given an weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by a 2d array edges[][], where edges[i] = [u, v, w] represents a direct edge from node u to v having w edge weight. You are also given a source vertex src.
Your task is to compute the shortest distances from the source to all other vertices. If a vertex is unreachable from the source, its distance should be marked as 108. Additionally, if the graph contains a negative weight cycle, return [-1] to indicate that shortest paths cannot be reliably computed.
*/
package Graphs.ShortestPathProblems;
import java.util.*;

public class BellmanFord {
    public static int[] optimal(int V, int[][] edges, int src) {
        int[] distances = new int[V];
        Arrays.fill(distances,(int)1e8);
        distances[src] = 0;

        for(int i=0;i<V;i++){
            for(int j=0;j<edges.length;j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];

                if(distances[u] != 1e8 && distances[u]+w < distances[v]){
                    distances[v] = distances[u]+w;
                }
            }
        }

        for(int j=0;j<edges.length;j++){
            int u = edges[j][0];
            int v = edges[j][1];
            int w = edges[j][2];

            if(distances[u] != 1e8 && distances[u]+w < distances[v]){
                return new int[] {-1};
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 4}, {1, 2, -6}, {2, 3, 5}, {3, 1, -2}};
        System.out.println(Arrays.toString(optimal(4,edges,0)));
    }
}
