/*
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
*/
package Graphs.ShortestPathProblems;
import java.util.*;

public class NetworkDelayTime {
    static class Pair{
        int node,time;
        Pair(int n, int t){
            node = n; time = t;
        }
    }
    public static int optimal(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int u = times[i][0];
            int v = times[i][1];
            int t = times[i][2];
            adj.get(u).add(new Pair(v,t));
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)-> a.time-b.time);
        q.add(new Pair(k,0));
        dist[k] = 0;

        while(!q.isEmpty()){
            Pair p = q.poll();
            int currNode = p.node;
            int currTime = p.time;

            for(Pair nei : adj.get(currNode)){
                int nNode = nei.node;
                int nTime = nei.time;
                if(dist[nNode]> nTime+currTime){
                    q.add(new Pair(nNode,nTime + currTime));
                    dist[nNode] = nTime + currTime;
                }
            }
        }
        for(int i=1;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
        }
        int max = -1;
        for(int i=1;i<dist.length;i++){
            if(dist[i] > max){
                max = dist[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2,8},{1,3,15},{2,7,10},{2,8,12},{3,4,3},{3,5,17},{8,4,1},{8,6,2},{4,6,7},{4,5,1}};
        System.out.println(optimal(edges,8,1));
    }

}
