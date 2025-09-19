package Array.Medium;

import java.util.Arrays;

public class RotateMatrixBy90Degree {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        for(int i=0;i< matrix.length-1;i++){
            for (int j=i+1;j< matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i=0;i< matrix.length;i++){
            int start = 0;
            int end = matrix.length-1;
            while(start<end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }

        for (int[] arr:matrix)
            System.out.println(Arrays.toString(arr));
    }
}
