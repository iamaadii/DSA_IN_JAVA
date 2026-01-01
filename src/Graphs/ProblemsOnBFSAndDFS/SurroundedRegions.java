/*
Given a matrix mat of size N x M where every element is either ‘O’ or ‘X’. Replace all ‘O’ with ‘X’ that is surrounded by ‘X’. An ‘O’ (or a set of ‘O’) is considered to be surrounded by ‘X’ if there are ‘X’ at locations just below, just above just left, and just right of it.
*/
package Graphs.ProblemsOnBFSAndDFS;
import java.util.Arrays;

public class SurroundedRegions {

    static void dfs(int row,int col,char[][] mat,int[][] visited,int[] nrows, int[] ncols){
        visited[row][col] = 1;
        for (int i=0;i<4;i++) {
            int r = row + nrows[i];
            int c = col + ncols[i];
            if (r >= 0 && r < mat.length && c >= 0 && c < mat[row].length) {
                if (mat[r][c] == 'O' && visited[r][c] == 0)
                    dfs(r, c, mat, visited, nrows, ncols);
            }
        }
    }

    static void optimal(char[][] mat){
        int[][] visited = new int[mat.length][mat[0].length];
        int[] rows = {0,mat.length-1};
        int[] cols = {0,mat[0].length-1};
        int[] nrows = {-1,0,1,0};
        int[] ncols = {0,1,0,-1};

        for(int r:rows){
            for (int c=0;c<mat[r].length;c++){
                char curr = mat[r][c];
                if(curr == 'O' && visited[r][c]==0)
                    dfs(r,c,mat,visited,nrows,ncols);
            }
        }
        for(int c:cols){
            for (int r=1;r<mat.length-1;r++){
                char curr = mat[r][c];
                if(curr == 'O' && visited[r][c]==0)
                    dfs(r,c,mat,visited,nrows,ncols);
            }
        }
        for (int i=0;i<visited.length;i++){
            for (int j=0;j<visited[i].length;j++){
                if(mat[i][j]=='O' && visited[i][j]==0)
                    mat[i][j]='X';
            }
        }
    }

    public static void main(String[] args) {
        char[][] mat = {{'X','X','X','X'},{'X','X','X','X'},{'X','O','O','X'},{'X','O','O','X'},{'X','X','X','X'}};
        optimal(mat);
        System.out.println(Arrays.deepToString(mat));
    }
}
