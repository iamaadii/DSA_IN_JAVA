/*
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
*/
package Graphs.ShortestPathProblems;
import java.util.*;
public class CheapestFlightsWithinkStops {
    static class Pair{
        int node, dist;
        Pair(int n, int d){
            node = n; dist = d;
        }
    }
    static class Pair1{
        int node, dist,step;
        Pair1(int n, int d,int s){
            node = n; dist = d; step = s;
        }
    }
    public static int optimal(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            int start = flights[i][0];
            int end = flights[i][1];
            int cost = flights[i][2];
            adj.get(start).add(new Pair(end,cost));
        }

        int[] prices = new int[n];
        Arrays.fill(prices,Integer.MAX_VALUE);
        Queue<Pair1> q = new LinkedList<>();
        q.add(new Pair1(src,0,-1));
        prices[src] = 0;

        while(!q.isEmpty()){
            Pair1 p = q.poll();
            int currNode = p.node;
            int currDist = p.dist;
            int currStep = p.step;
            if(currNode==dst){
                continue;
            }

            for(Pair s: adj.get(currNode)){
                int neiNode = s.node;
                int neiDist = s.dist;
                if(currStep+1 <= k){
                    if(prices[neiNode] > currDist+neiDist){
                        q.add(new Pair1(neiNode,currDist+neiDist,currStep+1));
                        prices[neiNode] = currDist+neiDist;
                    }
                }
            }
        }
        if(prices[dst]==Integer.MAX_VALUE)
            return -1;
        return prices[dst];
    }
    public static void main(String[] args) {

    }
}
