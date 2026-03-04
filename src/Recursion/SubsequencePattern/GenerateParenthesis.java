/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
*/

package Recursion.SubsequencePattern;
import java.util.*;

public class GenerateParenthesis {
    static boolean isValid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }
    static void helper(int n, List<String> result,StringBuilder sb){
        if(sb.length()==2*n){
            if(isValid(sb.toString())){
                result.add(sb.toString());
            }
            return;
        }
        sb.append('(');
        helper(n,result,sb);
        sb.deleteCharAt(sb.length()-1);

        sb.append(')');
        helper(n,result,sb);
        sb.deleteCharAt(sb.length()-1);
    }
    static List<String> bruteForce(int n) {
        List<String> result = new ArrayList<>();
        helper(n,result,new StringBuilder());
        return result;
    }




    static void backtrack(String curr, int open, int close, int n, List<String> res) {
        if (curr.length() == 2 * n) {
            res.add(curr);
            return;
        }
        if (open < n) backtrack(curr + "(", open + 1, close, n, res);
        if (close < open) backtrack(curr + ")", open, close + 1, n, res);
    }
    static List<String> optimal(int n) {
        List<String> res = new ArrayList<>();
        backtrack("", 0, 0, n, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(bruteForce(3));
        System.out.println(optimal(3));
    }
}
