package Stack_And_Queues.Prefix_Infix_Postfix;
import java.util.*;

public class PostfixToPrefix {
    static String optimal(String s){
        Stack<String> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c>='0' && c<='9' || c>='a'&&c<='z' || c>='A'&&c<='Z'){
                st.push(Character.toString(c));
            }
            else{
                String first = st.pop();
                String second = st.pop();
                String res = c + second + first;
                st.push(res);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        System.out.println(optimal("ABC/-AK/L-*"));
    }
}
