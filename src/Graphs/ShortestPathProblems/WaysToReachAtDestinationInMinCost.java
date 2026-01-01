/*
You are in a city that consists of n intersections numbered from 0 to n - 1 with by-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.
You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.
Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.
*/

package Graphs.ShortestPathProblems; 
import java.util.*;

public class WaysToReachAtDestinationInMinCost {
    static class Pair {
        int node;
        long dist;
        Pair(int n, long d) {
            node = n;
            dist = d;
        }
    }

    public static int optimal(int n, int[][] roads) {
        int MOD = 1000000007;

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] r : roads) {
            int u = r[0], v = r[1], t = r[2];
            adj.get(u).add(new Pair(v, t));
            adj.get(v).add(new Pair(u, t));
        }

        long[] distances = new long[n];
        Arrays.fill(distances, Long.MAX_VALUE);

        int[] noOfWays = new int[n];

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        distances[0] = 0;
        noOfWays[0] = 1;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int currNode = p.node;
            long currDist = p.dist;

            // if (currDist > distances[currNode]) continue;

            for (Pair nei : adj.get(currNode)) {
                int nextNode = nei.node;
                long newDist = currDist + nei.dist;

                if (newDist < distances[nextNode]) {
                    distances[nextNode] = newDist;
                    noOfWays[nextNode] = noOfWays[currNode];
                    pq.add(new Pair(nextNode, newDist));
                }
                else if (newDist == distances[nextNode]) {
                    noOfWays[nextNode] =
                            (noOfWays[nextNode] + noOfWays[currNode]) % MOD;
                }
            }
        }

        return noOfWays[n - 1];
    }
    public static void main(String[] args) {
        int[][] edges = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        System.out.println(optimal(7,edges));
    }
}
