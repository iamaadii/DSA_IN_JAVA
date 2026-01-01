/*
Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of 'W's (Water) and
'L's (Land). Find the number of islands.

Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally
or vertically or diagonally i.e., in all 8 directions.
*/
package Graphs.ProblemsOnBFSAndDFS;
import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {

    static class Pair{
        int row, col;

        Pair(int r,int c){
            row=r;
            col=c;
        }
    }

    static void traversal(int i, int j, char[][] matrix, int[][] visited){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        visited[i][j]=1;

        while (!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;

            for (int nrow=-1; nrow<=1; nrow++){
                for (int ncol = -1; ncol<=1; ncol++){
                    int n1 = r + nrow;
                    int n2 = c + ncol;

                    if(n1>=0 && n1<matrix.length && n2>=0 && n2<matrix[i].length){
                        if(matrix[n1][n2]=='L' && visited[n1][n2]==0){
                            q.add(new Pair(n1,n2));
                            visited[n1][n2]=1;
                        }
                    }
                }
            }
        }
    }

    static int optimal(char[][] matrix){
        int[][] visited = new int[matrix.length][matrix[0].length];

        int count=0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]=='L' && visited[i][j]==0){
                    count +=1;
                    traversal(i,j,matrix,visited);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] mat = {
                {'L', 'L', 'W', 'W', 'W'},
                {'W', 'L', 'W', 'W', 'L'},
                {'L', 'W', 'W', 'L', 'L'},
                {'W', 'W', 'W', 'W', 'W'},
                {'L', 'W', 'L', 'L', 'W'}
        };
        System.out.println(optimal(mat));
    }
}
