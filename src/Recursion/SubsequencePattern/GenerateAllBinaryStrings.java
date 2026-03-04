package Recursion.SubsequencePattern;

import java.util.ArrayList;

public class GenerateAllBinaryStrings {
    static void function(int length, ArrayList<String> res, StringBuilder sb){
        if(sb.length()==length){
            res.add(sb.toString());
            return;
        }

        sb.append('0');
        function(length,res,sb);
        sb.deleteCharAt(sb.length()-1);

        sb.append('1');
        function(length,res,sb);
        sb.deleteCharAt(sb.length()-1);

    }

    static ArrayList<String> optimal(int n) {
        ArrayList<String> res = new ArrayList<>();
        function(n,res,new StringBuilder());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(optimal(3));
    }
}
