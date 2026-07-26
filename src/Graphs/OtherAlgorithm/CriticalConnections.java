/*
There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.
A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
Return all critical connections in the network in any order.
*/

package Graphs.OtherAlgorithm;
import java.util.*;
public class CriticalConnections {
    static int[] visited;
    static int[] timeOfInsertion;
    static int[] lowestTime;
    static List<List<Integer>> adj;

    static void dfs(int curr,int parent, int timer, List<List<Integer>> ans){
        visited[curr] = 1;
        timeOfInsertion[curr] = timer;
        lowestTime[curr] = timer;

        for(int nei: adj.get(curr)){
            if(nei==parent) continue;
            else if(visited[nei]==0){
                dfs(nei,curr,timer+1,ans);
                lowestTime[curr] = Math.min(lowestTime[nei],lowestTime[curr]);
                if(lowestTime[nei] > timeOfInsertion[curr]){
                    ans.add(new ArrayList<>(Arrays.asList(curr,nei)));
                }
            }
            else lowestTime[curr] = Math.min(lowestTime[nei],lowestTime[curr]);
        }
    }


    static List<List<Integer>> optimal(int n, List<List<Integer>> connections) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        visited = new int[n];
        timeOfInsertion = new int[n];
        lowestTime = new int[n];

        List<List<Integer>> criticals = new ArrayList<>();
        dfs(0,-1,0,criticals);

        return criticals;
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
