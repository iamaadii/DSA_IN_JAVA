/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
*/
package Recursion.Hard;

public class WordSearch {
    static boolean helper(int row, int col, char[][] board, String target, int[] neiRows, int[] neiCols, int index, int[][] vis){
        if(board[row][col] != target.charAt(index)){
            return false;
        }

        if(index == target.length() - 1){
            return true;
        }

        vis[row][col] = 1;

        for(int i = 0; i < 4; i++){
            int neiRow = row + neiRows[i];
            int neiCol = col + neiCols[i];

            if(neiRow >= 0 && neiRow < board.length &&
                    neiCol >= 0 && neiCol < board[0].length &&
                    vis[neiRow][neiCol] == 0){

                if(helper(neiRow, neiCol, board, target,
                        neiRows, neiCols, index + 1, vis)){
                    return true;
                }
            }
        }

        vis[row][col] = 0;
        return false;
    }

    static boolean exist(char[][] board, String word) {
        int[] neiRows = {-1,0,1,0};
        int[] neiCols = {0,1,0,-1};

        int[][] vis = new int[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(helper(i, j, board, word, neiRows, neiCols, 0, vis)){
                    return true;
                }
            }
        }
        return false;
    }
}
