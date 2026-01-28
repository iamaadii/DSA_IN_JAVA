/*
You are given a 2D binary matrix mat[][], where each cell contains either 0 or 1. Your task is to find the maximum area of a rectangle that can be formed using only 1's within the matrix.
*/
package Stack_And_Queues.Monotonic;
import java.util.*;

public class MaximalRectangle {

    static int largestRectangleArea(int[] arr){
        Stack<Integer> st = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() &&  arr[st.peek()] > arr[i]){
                int element = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                int area = (nse - pse - 1) * arr[element];
                maxArea = Math.max(maxArea,area);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int element = st.pop();
            int nse = arr.length;
            int pse = st.isEmpty() ? -1 : st.peek();
            int area = (nse - pse - 1) * arr[element];
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
    static int optimal(int[][] arr){
        int[][] prefixSum = new int[arr.length][arr[0].length];
        for (int j = 0; j < arr[0].length;j++) {
            int sum = 0;
            for(int i=0;i<arr.length;i++){
                if(arr[i][j]==0){
                    sum = 0;
                }
                else{
                    sum += 1;
                    prefixSum[i][j] = sum;
                }
            }
        }

        int maxArea = Integer.MIN_VALUE;
        for (int i=0;i<prefixSum.length;i++){
            int res = largestRectangleArea(prefixSum[i]);
            maxArea = Math.max(maxArea,res);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,0,1,0,1},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        System.out.println(optimal(arr));
    }
}
