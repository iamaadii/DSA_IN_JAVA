package Array.Medium;

import java.awt.*;
import java.util.ArrayList;

public class SpiralMatrixTraversal {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int top = 0; int bottom = matrix.length-1;
        int left = 0; int right = matrix[0].length-1;

        ArrayList<Integer> res = new ArrayList<>();
        while (top<=bottom && left<=right){
            for(int i=left;i<=right;i++)
                res.add(matrix[top][i]);
            top++;

            for (int i=top;i<=bottom;i++)
                res.add(matrix[i][right]);
            right--;

            //prevents from re-traversing rows
            if(top<=bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //prevents from re-traversing columns
            if(left<=right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        System.out.println(res);
    }
}
