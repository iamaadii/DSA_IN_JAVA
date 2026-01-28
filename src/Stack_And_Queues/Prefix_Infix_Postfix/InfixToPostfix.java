/*
You are given a string s representing an infix expression. Convert this infix expression to a postfix expression.
    Infix expression: The expression of the form a op b. When an operator is in between every pair of operands.
    Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
    Note: The precedence order is as follows: (^) has the highest precedence and is evaluated from right to left, (* and /) come next with left to right associativity, and (+ and -) have the lowest precedence with left to right associativity.
*/
package Stack_And_Queues.Prefix_Infix_Postfix;
import java.util.*;

public class InfixToPostfix {
    static int priority(char c){
        if(c=='^') return 3;
        else if(c=='*' || c=='/') return 2;
        else if(c=='+' || c=='-') return 1;
        else return 0;
    }

    public static String optimal(String s) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c>='a' && c<='z' || c>='A' && c<='Z' || c>='0' && c<='9'){
                postfix.append(c);
            }
            else if(c=='('){
                st.push(c);
            }
            else if(c==')'){
                while (!st.isEmpty() && st.peek() != '(') {
                    postfix.append(st.pop());
                }
                st.pop();
            }
            else{
                while (!st.isEmpty() && (priority(c) < priority(st.peek()) || (priority(c) == priority(st.peek()) && c != '^'))) {
                    postfix.append(st.pop());
                }
                st.push(c);
            }

        }
        while(!st.isEmpty()){
            postfix.append(st.pop());
        }
        return postfix.toString();
    }

    public static void main(String[] args) {
        System.out.println(optimal("a*(b+c)/d"));
    }
}
