/*
We are given an array asteroids of integers representing asteroids in a row. The indices of the asteroid in the array represent their relative position in space.
For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
*/

package Stack_And_Queues.Monotonic;
import java.util.*;

public class AstroidsCollision {
    static int[] optimal(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            int ele = arr[i];
            if(ele>0){
                st.push(ele);
            }
            else if(ele<0){
                boolean flag = false;
                while(!st.isEmpty() && st.peek()>0){
                    if(st.peek() < Math.abs(ele))
                        st.pop();
                    else if(st.peek() > Math.abs(ele)){
                        flag=true;
                        break;
                    }
                    else{
                        st.pop();
                        flag=true;
                        break;
                    }
                }
                if(!flag){
                    st.push(ele);
                }
            }
        }

        int[] result = new int[st.size()];
        int i=st.size()-1;
        while(!st.isEmpty()){
            result[i--] = st.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {3,5,-6,2,-1,4};
        System.out.println(Arrays.toString(optimal(arr)));
    }
}
