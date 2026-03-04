/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
*/

package Recursion.Hard;
import java.util.*;

public class N_Queens {
    static boolean isValid(int row, int col, List<String> curr){
        for(int j=0;j<col;j++){
            if(curr.get(row).charAt(j)=='Q'){
                return false;
            }
        }

        int dupRow = row-1;
        int dupCol = col-1;
        while(dupRow>=0 && dupCol>=0){
            if(curr.get(dupRow).charAt(dupCol)=='Q'){
                return false;
            }
            dupRow -= 1;
            dupCol -= 1;
        }

        dupRow = row+1;
        dupCol = col-1;

        while (dupCol >= 0 && dupRow<curr.size()){
            if (curr.get(dupRow).charAt(dupCol)=='Q'){
                return false;
            }
            dupRow += 1;
            dupCol -= 1;
        }
        return true;
    }
    static void helper(int col, int n, List<List<String>> res, List<String> curr){
        if(col==n){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int row=0;row<n;row++){
            if(isValid(row,col,curr)){
                StringBuilder sb = new StringBuilder(curr.get(row));
                sb.setCharAt(col,'Q');
                curr.set(row,sb.toString());

                helper(col+1,n,res,curr);
                sb.setCharAt(col,'.');
                curr.set(row,sb.toString());
            }
        }
    }
    static List<List<String>> bruteForce(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(".");
            }
            curr.add(sb.toString());
        }
        System.out.println(curr);
        helper(0,n,res,curr);
        return res;
    }







    static boolean isSafe(int n,int row, int col, List<String> curr, int[] rowFlag, int[] topDiagonal, int[] bottomDiagonal){
        if (rowFlag[row]==1 || bottomDiagonal[row+col]==1 ||  topDiagonal[n-1+(col-row)]==1){
            return false;
        }
        return true;
    }
    static void function(int col, int n, List<List<String>> res, List<String> curr, int[] rowFlag, int[] topDiagonal, int[] bottomDiagonal){
        if(col==n){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int row=0;row<n;row++){
            if(isSafe(n,row,col,curr,rowFlag,topDiagonal,bottomDiagonal)){
                StringBuilder sb = new StringBuilder(curr.get(row));
                sb.setCharAt(col,'Q');
                curr.set(row,sb.toString());
                rowFlag[row] = 1;
                bottomDiagonal[row+col]=1;
                topDiagonal[n-1+(col-row)]=1;

                function(col+1,n,res,curr,rowFlag,topDiagonal,bottomDiagonal);
                sb.setCharAt(col,'.');
                curr.set(row,sb.toString());
                rowFlag[row] = 0;
                bottomDiagonal[row+col]=0;
                topDiagonal[n-1+(col-row)]=0;
            }
        }
    }
    static List<List<String>> optimal(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] rowFlag = new int[n];
        int[] topDiagonal = new int[2*n-1];
        int[] bottomDiagonal = new int[2*n-1];

        List<String> curr = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(".");
            }
            curr.add(sb.toString());
        }
        System.out.println(curr);
        function(0,n,res,curr,rowFlag,topDiagonal,bottomDiagonal);
        return res;
    }


    public static void main(String[] args) {
        System.out.println(bruteForce(4));
        System.out.println(optimal(4));


        int[][] arr= {{1,4},{10,15},{7,10}};

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));


        for (int[] e: arr){
            System.out.println(Arrays.toString(e));;
        }
    }
}
