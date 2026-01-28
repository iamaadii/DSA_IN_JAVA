/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    An input string is valid if:
        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.
        Every close bracket has a corresponding open bracket of the same type.
*/
package Stack_And_Queues.Learning;
import java.util.*;

public class ValidParentheses {

    static boolean optimal(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                st.push(c);
            }
            else{
                if(st.isEmpty()) return false;
                char top = st.pop();
                if(c==')' && top=='(' || c=='}' && top=='{' || c==']' && top=='[') continue;
                else return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(optimal("()[]{}"));
    }
}
