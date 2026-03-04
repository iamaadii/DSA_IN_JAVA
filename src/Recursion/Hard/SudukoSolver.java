package Recursion.Hard;

public class SudukoSolver {
    static boolean isSafe(char value,int row, int col,char[][] board){
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;
        for(int i=0;i<9;i++){
            if(board[row][i] == value){
                return false;
            }
            if(board[i][col] == value){
                return false;
            }
            if(board[rowStart+(i/3)][colStart+(i%3)]==value){
                return false;
            }
        }
        return true;
    }

    static boolean helper(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isSafe(c,i,j,board)){
                            board[i][j]=c;

                            if(helper(board)==true){
                                return true;
                            }
                            else{
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static void optimal(char[][] board) {
        helper(board);
    }
}
