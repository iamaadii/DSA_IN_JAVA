/*
You are given an undirected graph consisting of V vertices and E edges represented by a list edges[][], along with an integer m. Your task is to determine whether it is possible to color the graph using at most m different colors such that no two adjacent vertices share the same color. Return true if the graph can be colored with at most m colors, otherwise return false.

Note: The graph is indexed with 0-based indexing.
*/
package Recursion.Hard;
import java.util.*;
public class MColouringProblem {
    static boolean helper(int node, int m,int v,int[] color, List<List<Integer>> adjList){

        if(node==v){
            return true;
        }

        for(int i=1;i<=m;i++){
            boolean flag = true;
            for(int e: adjList.get(node)){
                if(color[e]==i){
                    flag=false;
                    break;
                }
            }
            if(flag){
                color[node]=i;
                if(helper(node+1,m,v,color,adjList)){
                    return true;
                }
                color[node]=0;
            }
        }
        return false;
    }

    static boolean optimal(int v, int[][] edges, int m) {

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<v;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] e: edges){
            int a = e[0];
            int b = e[1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        int[] color = new int[v];
        return helper(0,m,v,color,adjList);
    }


    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,3},{2,3},{3,0},{0,2}};
        System.out.println(optimal(4,edges,3));

        System.out.println((int)'.');
    }
}
