/*
A celebrity is a person who is known to all but does not know anyone at a party. A party is being organized by some people. A square matrix mat[][] of size n*n is used to represent people at the party such that if an element of row i and column j is set to 1 it means ith person knows jth person. You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.
Note: Follow 0-based indexing.
*/
package Stack_And_Queues.ImplementationProblems;
import java.util.*;
public class CelebrityProblem {
    static int bruteForce(int[][] mat){
        int n = mat.length;
        int[] iKnow = new int[n];
        int[] knowsMe = new int[n];

        for(int i=0; i<n; i++){
            for(int j=0;j<n;j++){
                if(i!=j && mat[i][j]==1){
                    iKnow[i] += 1;
                    knowsMe[j] += 1;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(knowsMe[i]==n-1 && iKnow[i]==0){
                return i;
            }
        }
        return -1;
    }

    static int optimal(int[][] mat){
        int n = mat.length;
        int top=0, bottom=n-1;
        while (top<bottom){
            if(mat[top][bottom]==1){
                top=top+1;
            }
            else if(mat[bottom][top]==1){
                bottom=bottom-1;
            }
            else{
                top+=1;
                bottom-=1;
            }
        }
        if (top>bottom) return -1;
        for (int i = 0; i < n; i++) {
            if (i==top) continue;
            if (mat[top][i]!=0 || mat[i][top]!=1) {
                return -1;
            }
        }
        return top;
    }

    public static void main(String[] args) {
        int[][] mat =  {{1, 1, 0},
                {0, 1, 0},
                {0, 1, 1}};
        System.out.println(bruteForce(mat));
        System.out.println(optimal(mat));

        int[] nums = {9,8,5,7};
        Stack<Integer> st = new Stack<>();
        int[] pge = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pge[i] = -1;
            }
            else{
                pge[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();
        System.out.println(st);
        System.out.println(Arrays.toString(pge));
        int ans = 0;
        int first = -1,second=-1;
        for (int i = 0; i < pge.length; i++) {
            if (pge[i]!=-1){
                if (first==-1){
                    first=pge[i];
                }else{
                    second = pge[i];
                    ans = second + 2 - first;
                }
            }
        }
//        if (first==-1 && second==-1){
//            System.out.println(0);;
//        }
        System.out.println(ans);
    }
}
