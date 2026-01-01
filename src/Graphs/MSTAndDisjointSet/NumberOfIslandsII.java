/*
You are given a n,m which means the row and column of the 2D matrix and an array of  size k denoting the number of operations. Matrix elements is 0 if there is water or 1 if there is land. Originally, the 2D matrix is all 0 which means there is no land in the matrix. The array has k operator(s) and each operator has two integer A[i][0], A[i][1] means that you can change the cell matrix[A[i][0]][A[i][1]] from sea to island. Return how many island are there in the matrix after each operation.You need to return an array of size k.
Note : An island means group of 1s such that they share a common side.
*/
package Graphs.MSTAndDisjointSet;
import java.util.*;
public class NumberOfIslandsII {
    static class Disjoint {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        Disjoint(int n) {
            for (int i = 0; i < n; i++) {
                size.add(1);
                parent.add(i);
            }
        }
        int findUltimateParent(int node){
            if (node== parent.get(node)) return node;
            int up = findUltimateParent(parent.get(node));
            parent.set(node,up);
            return parent.get(node);
        }
        void unionBySize(int u, int v){
            int ultimateU = findUltimateParent(u); int ultimateV = findUltimateParent(v);
            if (ultimateV==ultimateU) return;

            int sizeU = size.get(ultimateU); int sizeV = size.get(ultimateV);
            if(sizeV < sizeU){
                parent.set(ultimateV,ultimateU);
                size.set(ultimateU,sizeU+sizeV);
            }
            else{
                parent.set(ultimateU,ultimateV);
                size.set(ultimateV,sizeV+sizeU);
            }
        }

    }

    static List<Integer> optimal(int n, int m, int[][] matrix) {
        int[][] vis = new int[n][m];
        Disjoint obj = new Disjoint(n*m);
        List<Integer> ans = new ArrayList<>();
        int[] rows = {0,-1,0,1}; int[] cols = {-1,0,1,0};
        int count = 0;
        for(int i=0;i<matrix.length;i++){
            int r = matrix[i][0];
            int c = matrix[i][1];
            if(vis[r][c]==1){
                ans.add(count);
                continue;
            }
            count += 1;
            vis[r][c] = 1;
            for(int iter=0;iter<4;iter++){
                int neiRow = r + rows[iter];
                int neiCol = c + cols[iter];
                if(neiRow>=0 && neiRow<n && neiCol>=0 && neiCol<m){
                    int u = r*m + c; int v = neiRow*m+neiCol;
                    if(vis[neiRow][neiCol]==1 && obj.findUltimateParent(u) != obj.findUltimateParent(v)){
                        obj.unionBySize(u,v);
                        count -= 1;
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] edges = {{1,1},{0,1},{3,3},{3,4}};
        System.out.println(optimal(4,5,edges));
    }
}
