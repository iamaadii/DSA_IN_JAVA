/*
Given an undirected connected graph with V vertices and adjacency list adj. You are required to find all the vertices removing which (and edges through it) disconnects the graph into 2 or more components and return it in sorted manner.
Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph.
*/
package Graphs.OtherAlgorithm;
import java.util.*;
public class ArticulationPoint {

    static int[] visited;
    static int[] timeOfInsertion;
    static int[] lowestTime;
    static List<List<Integer>> adj;

    static void dfs(int curr,int parent, int timer,boolean[] articulationPoint){
        visited[curr] = 1;
        timeOfInsertion[curr] = timer;
        lowestTime[curr] = timer;

        int child=0;
        for(int nei: adj.get(curr)){
            if(nei==parent) continue;
            else if(visited[nei]==0){
                dfs(nei,curr,timer+1,articulationPoint);
                lowestTime[curr] = Math.min(lowestTime[nei],lowestTime[curr]);
                if(lowestTime[nei] >= timeOfInsertion[curr] && parent != -1 ){
                    articulationPoint[curr] = true;
                }
                child+=1;
            }
            else {
                lowestTime[curr] = Math.min(timeOfInsertion[nei],lowestTime[curr]);
            }
        }
        if(parent==-1 && child>1){
            articulationPoint[curr] = true;
        }
    }


    static ArrayList<Integer> optimal(int n, ArrayList<ArrayList<Integer>> adj) {
        visited = new int[n];
        timeOfInsertion = new int[n];
        lowestTime = new int[n];

        boolean[] articulationPoint = new boolean[n];
        dfs(0,-1,0,articulationPoint);

        ArrayList<Integer> ans = new ArrayList<>();
        for(int node=0;node<n;node++){
            if(articulationPoint[node]==true) {
                ans.add(node);
            }
        }
        if(ans.isEmpty()) ans.add(-1);
        return ans;
    }
}
