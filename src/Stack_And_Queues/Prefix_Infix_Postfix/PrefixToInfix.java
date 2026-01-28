package Stack_And_Queues.Prefix_Infix_Postfix;

import java.util.Stack;

public class PrefixToInfix {
    static String optimal(String s) {
        Stack<String> st = new Stack<>();
        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(c>='0'&&c<='9' || c>='A'&&c<='Z' || c>='a'&&c<='z'){
                st.push(Character.toString(c));
            }
            else{
                String first = st.pop();
                String second = st.pop();
                String res = '(' + first + c + second + ')';
                st.push(res);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        System.out.println(optimal("*-A/BC-/AKL"));
    }
}
