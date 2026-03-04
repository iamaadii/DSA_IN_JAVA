/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
*/

package Recursion.SubsequencePattern;
import java.util.*;

public class LetterCombinationOfPhoneNumber {
    static void helper(int index,List<String> values,StringBuilder curr,List<String> res,String digits){
        if(curr.length()==digits.length()){
            res.add(curr.toString());
            return;
        }

        int val = digits.charAt(index)-'0';
        String temp = values.get(val);
        for(int i=0;i<temp.length();i++){
            curr.append(temp.charAt(i));
            helper(index+1,values,curr,res,digits);
            curr.deleteCharAt(curr.length()-1);
        }
    }

    static List<String> optimal(String digits) {
        List<String> values = new ArrayList<>();
        values.add("");
        values.add("");
        values.add("abc");
        values.add("def");
        values.add("ghi");
        values.add("jkl");
        values.add("mno");
        values.add("pqrs");
        values.add("tuv");
        values.add("wxyz");

        List<String> res = new ArrayList<>();
        helper(0,values,new StringBuilder(),res,digits);
        return res;
    }


    public static void main(String[] args) {
        System.out.println(optimal("23"));
    }
}
