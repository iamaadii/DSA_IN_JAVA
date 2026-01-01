/*
A new alien language uses the English alphabet, but the order of letters is unknown. You are given a list of words[] from the alien language’s dictionary, where the words are claimed to be sorted lexicographically according to the language’s rules.
Your task is to determine the correct order of letters in this alien language based on the given words. If the order is valid, return a string containing the unique letters in lexicographically increasing order as per the new language's rules. If there are multiple valid orders, return any one of them.
However, if the given arrangement of words is inconsistent with any possible letter ordering, return an empty string ("").
A string a is lexicographically smaller than a string b if, at the first position where they differ, the character in a appears earlier in the alien language than the corresponding character in b. If all characters in the shorter word match the beginning of the longer word, the shorter word is considered smaller.
*/
package Graphs.TopologicalSortProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    static String optimal(String[] words){
        ArrayList<ArrayList<Integer>> adList = new ArrayList<>();
        int[] inDegree = new int[26];
        int[] present = new int[26];

        for (int i=0;i<26;i++){
            adList.add(new ArrayList<>());
        }
        for (String w : words) {
            for (char c : w.toCharArray()) {
                present[c - 'a'] = 1;
            }
        }

        for(int i=0;i< words.length-1;i++){
            String w1 = words[i], w2 = words[i+1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int l = Math.min(w1.length(), w2.length());
            for (int j=0;j<l;j++){
                if (w1.charAt(j) != w2.charAt(j)){
                    int u = w1.charAt(j) - 'a';
                    int v = w2.charAt(j) - 'a';
                    adList.get(u).add(v);
                    inDegree[v] += 1;
                    break;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int totalChars = 0;
        for (int i=0;i<26;i++){
            if (present[i]==1){
                totalChars += 1;
                if (inDegree[i]==0) q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()){
            int curr = q.poll();
            sb.append((char) (curr+97));
            for (int nei: adList.get(curr)){
                inDegree[nei] -= 1;
                if (inDegree[nei]==0) q.add(nei);
            }
        }
        if (sb.length() != totalChars) return "";
        return sb.toString();
    }


    public static void main(String[] args) {
        String[] words = {"dddc", "a", "ad", "ab", "b", "be", "cd", "cded"};
        System.out.println(optimal(words));
    }
}
