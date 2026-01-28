package Stack_And_Queues.Learning;

import java.util.Stack;

public class MinStack_II {
    Stack<Integer> st;
    int minVal;

    MinStack_II(){
        st= new Stack<>();
        minVal = Integer.MAX_VALUE;
    }

    void push(int x){
        if(x<minVal){
            st.push(2*x-minVal);
            minVal = Math.min(minVal,x);
        }else{
            st.push(x);
        }
    }

    void pop(){
        int temp = st.pop();
        if (temp<minVal){
            minVal = 2*minVal-temp;
        }
    }

    int getMinVal(){
        return minVal;
    }

    int top(){
        return Math.max(st.peek(),minVal);
    }
}
