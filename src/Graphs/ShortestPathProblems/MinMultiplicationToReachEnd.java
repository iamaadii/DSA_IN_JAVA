/*
Given start, end and an array arr of n numbers. At each step, start is multiplied with any number in the array and then mod operation with 100000 is done to get the new start.
Your task is to find the minimum steps in which end can be achieved starting from start. If it is not possible to reach end, then return -1.
*/
package Graphs.ShortestPathProblems;
import java.util.*;
public class MinMultiplicationToReachEnd {
    static class Pair{
        int num,step;
        Pair(int n, int s){
            num = n; step=s;
        }
    }
    static int optimal(int[] arr, int start, int end) {

        if (start == end) return 0;

        int[] dist = new int[100000];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,0));
        dist[start] = 0;

        while(!q.isEmpty()){
            Pair p = q.poll();
            int currNum = p.num;
            int currStep = p.step;

            for(int e: arr){
                int newNum = (currNum * e)%100000;
                if(currStep+1 < dist[newNum]) {
                    q.add(new Pair(newNum,currStep+1));
                    dist[newNum] = currStep+1;
                    if(newNum==end) return currStep+1;
                }
            }
        }
        return -1;
    }

    public int minSteps(int[] arr, int start, int end) {
        if (start == end) return 0;
        int[] vis = new int[1000];
        Arrays.fill(vis,-1);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,0));
        vis[start] = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int currNum = p.num;
            int currStep = p.step;

            for(int e: arr){
                int newNum = (currNum * e)%1000;
                if(vis[newNum]==-1) {
                    q.add(new Pair(newNum,currStep+1));
                    vis[newNum] = currStep+1;
                    if(newNum==end) return currStep+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,7};
        System.out.println(optimal(arr,3,30));
    }
}
