/*
Given an undirected connected graph with V vertices and adjacency list adj. You are required to find all the vertices removing which (and edges through it) disconnects the graph into 2 or more components and return it in sorted manner.
Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph.
*/
package Graphs.OtherAlgorithm;
import java.util.*;
public class ArticulationPoint {
    static void dfs(int curr,int parent, ArrayList<ArrayList<Integer>> adj,int[] vis,int[] timeOfInsertion,int[] lowestTime, int[] count, boolean[] articulationPoint){
        vis[curr] = 1;
        timeOfInsertion[curr] = lowestTime[curr] = count[0];
        count[0]+=1;
        int child=0;
        for(int nei: adj.get(curr)){
            if(nei==parent) continue;
            else if(vis[nei]==0){
                dfs(nei,curr,adj,vis,timeOfInsertion,lowestTime,count,articulationPoint);
                lowestTime[curr] = Math.min(lowestTime[nei],lowestTime[curr]);
                if(lowestTime[nei] >= timeOfInsertion[curr] && parent != -1 ){
                    articulationPoint[curr] = true;
                }
                child+=1;
            }
            else lowestTime[curr] = Math.min(timeOfInsertion[nei],lowestTime[curr]);
        }
        if(parent==-1 && child>1){
            articulationPoint[curr] = true;
        }
    }
    static ArrayList<Integer> optimal(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] vis  = new int[n];
        int[] timeOfInsertion = new int[n];
        int[] lowestTime = new int[n];
        int[] count = {0};
        boolean[] articulationPoint = new boolean[n];
        Arrays.fill(articulationPoint,false);
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,-1,adj,vis,timeOfInsertion,lowestTime,count,articulationPoint);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(articulationPoint[i]) ans.add(i);
        }
        if(ans.isEmpty()) ans.add(-1);
        return ans;
    }

    public static void main(String[] args) {

    }
}
