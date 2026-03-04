/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
*/

package Recursion.Hard;
import java.util.*;

public class PalindromePartitioning {
    static boolean isPalindrome(String s){
        int n = s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }
    static void helper(List<String> curr, List<List<String>> res, String s){
        if(s.isEmpty()){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<s.length();i++){
            String temp = s.substring(0,i+1);
            if(isPalindrome(temp)){
                curr.add(temp);
                helper(curr,res,s.substring(i+1));
                curr.removeLast();
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(new ArrayList<>(),res,s);
        return res;
    }



    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
