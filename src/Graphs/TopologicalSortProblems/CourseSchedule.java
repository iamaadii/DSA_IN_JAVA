/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
*/
package Graphs.TopologicalSortProblems;
import java.util.*;

public class CourseSchedule {
    static  boolean dfs(int node,ArrayList<ArrayList<Integer>> adjList, int[] vis){
        vis[node] = 1;
        for(int e: adjList.get(node)){
            if(vis[e]==0){
                if(dfs(e,adjList,vis))
                    return true;
            }
            else if(vis[e]==1 && vis[node]==1)
                return true;
        }
        vis[node]=2;
        return false;
    }
    static boolean optimal1(int V, int[][] edges){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int e1 = edges[i][0];
            int e2 = edges[i][1];
            adjList.get(e2).add(e1);
        }

        int[] vis = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,adjList,vis))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] edges = { {0,1},{2,1},{3,1},{2,0},{2,4},{1,4} };
        System.out.println(optimal1(5,edges));
    }
}
