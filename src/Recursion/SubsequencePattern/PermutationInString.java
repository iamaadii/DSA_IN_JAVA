///*
//Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
//In other words, return true if one of s1's permutations is the substring of s2.
//*/
//
//package Recursion.SubsequencePattern;
//
//public class PermutationInString {
//    static boolean helper(StringBuilder curr, String s1, String s2, boolean[] used){
//        if(curr.length()==s1.length()){
//            if (s2.contains(curr.toString())){
//                return true;
//            }
//            return false;
//        }
//        for(int i=0;i<s1.length();i++){
//            if(!used[i]){
//                curr.append(s1.charAt(i));
//                used[i] = true;
//                if (helper(curr,s1,s2,used)){
//                    return true;
//                }
//                curr.deleteCharAt(curr.length()-1);
//                used[i] = false;
//            }
//        }
//        return false;
//    }
//    static boolean optimal(String s1, String s2) {
//        boolean[] visited = new boolean[s1.length()];
//        return helper(new StringBuilder(),s1,s2,visited);
//    }
//
//
//    public static void main(String[] args) {
//        System.out.println(optimal("ab","eidbaooo"));
//    }
//}
