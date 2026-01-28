/*
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
*/
package Stack_And_Queues.Monotonic;
import java.util.*;
public class RemoveKDigits {

    static String  optimal(String nums, int k){
        int count = 0;
        if(k==nums.length()) return "0";
        Stack<Character> st = new Stack<>();
        for(char c: nums.toCharArray()){
            while(!st.isEmpty() && (st.peek()-'0' > c-'0' && count != k)){
                st.pop();
                count += 1;
            }
            st.push(c);
        }
        while(count != k){
            st.pop();
            count += 1;
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }

        int j=res.length() - 1;
        while(!res.isEmpty() && res.charAt(j)=='0'){
            res.deleteCharAt(j);
            --j;
        }
        if(res.isEmpty()) return "0";

        int i=0;
        while(i<res.length()/2){
            char temp = res.charAt(i);
            res.setCharAt(i,res.charAt(res.length()-i-1));
            res.setCharAt(res.length()-i-1,temp);
            i++;
        }
        return res.toString();

    }

    public static void main(String[] args) {
        String str = "10200";
        System.out.println(optimal(str, 1));

        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(10);
        dq.push(20);
        dq.push(30);
        System.out.println(dq);
        dq.addFirst(15);
        dq.addLast(12);
        System.out.println(dq);

    }
}
