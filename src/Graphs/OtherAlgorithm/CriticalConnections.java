/*
There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.
A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
Return all critical connections in the network in any order.
*/

package Graphs.OtherAlgorithm;
import java.util.*;
public class CriticalConnections {
    static void dfs(int curr,int parent,List<List<Integer>> adj,int[] vis,int[] timeOfInsertion,int[] lowestTime, int[] count, List<List<Integer>> ans){
        vis[curr] = 1;
        timeOfInsertion[curr] = lowestTime[curr] = count[0];
        count[0]+=1;
        for(int nei: adj.get(curr)){
            if(nei==parent) continue;
            else if(vis[nei]==0){
                dfs(nei,curr,adj,vis,timeOfInsertion,lowestTime,count,ans);
                lowestTime[curr] = Math.min(lowestTime[nei],lowestTime[curr]);
                if(timeOfInsertion[curr] < lowestTime[nei]){
                    ans.add(new ArrayList<>(Arrays.asList(curr,nei)));
                }
            }
            else lowestTime[curr] = Math.min(lowestTime[nei],lowestTime[curr]);
        }
    }
    static List<List<Integer>> optimal(int n, List<List<Integer>> arr) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<arr.size();i++){
            int u = arr.get(i).get(0);
            int v = arr.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis  = new int[n];
        int[] timeOfInsertion = new int[n];
        int[] lowestTime = new int[n];
        List<List<Integer>> ans = new ArrayList<>();
        int[] count = {0};
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,-1,adj,vis,timeOfInsertion,lowestTime,count,ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(new ArrayList<>(Arrays.asList(0,1)));
        l.add(new ArrayList<>(Arrays.asList(1,2)));
        l.add(new ArrayList<>(Arrays.asList(2,0)));
        l.add(new ArrayList<>(Arrays.asList(1,3)));
        System.out.println(optimal(4,l));
    }
}
