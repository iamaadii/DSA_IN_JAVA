package Stack_And_Queues.Prefix_Infix_Postfix;

import java.util.*;
public class InfixToPrefix {

    static void reverse(char[] arr){
        int i=0, j=arr.length-1;
        while(i<j){
            char start = arr[i];
            arr[i] = arr[j];
            arr[j] = start;
            i++; j--;
        }
        for(int iter=0;iter<arr.length;iter++){
            if(arr[iter]=='(') arr[iter]=')';
            else if(arr[iter]==')') arr[iter] = '(';
        }
    }
    static int priority(char c){
        if(c=='^') return 3;
        else if(c=='*'||c=='/') return 2;
        else if(c=='+'||c=='-') return 1;
        else return 0;
    }

    static String optimal(String s) {
        char[] arr = s.toCharArray();
        reverse(arr);
        System.out.println(Arrays.toString(arr));

        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<arr.length;i++){
            char c = arr[i];
            if(c>='a'&&c<='z' || c>='A'&&c<='Z' || c>='0' && c<='9'){
                sb.append(c);
            }
            else if(c=='(') st.push(c);
            else if(c==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    sb.append(st.pop());
                }
                if(!st.isEmpty()) st.pop();
            }
            else{
                if(c=='^'){
                    while(!st.isEmpty() && priority(c)<=priority(st.peek())){
                        sb.append(st.pop());
                    }
                }
                else{
                    while(!st.isEmpty() && priority(c)<priority(st.peek())){
                        sb.append(st.pop());
                    }
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        int i=0, j=sb.length()-1;
        while(i<j){
            char start = sb.charAt(i);
            sb.setCharAt(i,sb.charAt(j));
            sb.setCharAt(j,start);
            i++; j--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(optimal("a*(b+c)/d"));
        String a = "A";
        String b = "B";
        char c = '+';
        String res = "";
        res = res + '(' + b + c + a + ')';
//        System.out.println(res)
        System.out.println(res);

    }
}
