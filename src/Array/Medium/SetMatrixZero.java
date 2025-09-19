package Array.Medium;

import java.util.*;

public class SetMatrixZero {
//    public static void main(String[] args) {
//        int[][] arr = { {1,1,1},{1,0,1},{1,1,1}};
//
//        for(int i=0;i<arr.length;i++){
//            for (int j=0;j< arr[i].length;j++){
//                if(arr[i][j]==0){
//                    for(int col=0;col<arr[i].length;col++){
//                        if(arr[i][col]==1){
//                            arr[i][col]=-1;
//                        }
//                    }
//                    for(int row=0;row<arr.length;row++){
//                        if(arr[row][j]==1){
//                            arr[row][j]=-1;
//                        }
//                    }
//                }
//            }
//        }
//        for (int i=0;i< arr.length;i++){
//            for (int j=0;j<arr[i].length;j++){
//                if(arr[i][j]==-1){
//                    arr[i][j]=0;
//                }
//            }
//        }
//        for(int[] a:arr){
//            System.out.println(Arrays.toString(a));
//        }
//    }


//    public static void main(String[] args) {
//        int[][] arr = {{1, 1, 1,1}, {1, 0, 1,1}, {1, 1,0, 1},{1,0,0,1}};
//        int[] rows = new int[arr.length];
//        int[] columns = new int[arr[0].length];
//
//        for(int row=0;row<arr.length;row++){
//            for(int col=0;col<arr[row].length;col++){
//                if(arr[row][col]==0){
//                    if(rows[row]==0)
//                        rows[row]=1;
//                    if(columns[col]==0)
//                        columns[col] = 1;
//                }
//            }
//        }
//
//        for(int i=0;i<arr.length;i++){
//            for (int j=0;j<arr[i].length;j++){
//                if(arr[i][j]!=0 && (rows[i]==1 || columns[j]==1) )
//                    arr[i][j] = 0;
//            }
//        }
//
//        for (int[] ar: arr){
//            System.out.println(Arrays.toString(ar));
//        }
//    }


    public static void main(String[] args) {
        int[][] matrix = {{1,1,1,1},{1,0,1,1},{1,1,0,1},{0,1,1,1}};

        int col0 = 1;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    if(j==0)
                        col0 = 0;
                    else
                        matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i< matrix.length;i++){
            for (int j=1;j< matrix[0].length;j++){
                if(matrix[i][j]!=0){
                    if(matrix[0][j] ==0 || matrix[i][0]==0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        if(matrix[0][0]==0){
            for(int j=1;j<matrix[0].length;j++)
                matrix[0][j]=0;
        }
        if(col0==0){
            for (int j=0;j<matrix.length;j++)
                matrix[j][0]=0;
        }

        for (int[] arr:matrix)
            System.out.println(Arrays.toString(arr));
    }
}
