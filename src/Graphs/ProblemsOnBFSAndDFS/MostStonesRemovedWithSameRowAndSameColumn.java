/*
On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.

A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.

Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.
*/

package Graphs.ProblemsOnBFSAndDFS;

public class MostStonesRemovedWithSameRowAndSameColumn {
    static void dfs(int node,int[] vis,int[][] stones){
        vis[node]=1;
        int r = stones[node][0];
        int c = stones[node][1];

        for(int i=0;i<stones.length;i++){
            if((vis[i]==0) && (stones[i][0]==r || stones[i][1]==c)){
                dfs(i,vis,stones);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int totalComp = 0;
        int[] vis = new int[n];

        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,vis,stones);
                totalComp+=1;
            }
        }
        return n-totalComp;
    }
}
