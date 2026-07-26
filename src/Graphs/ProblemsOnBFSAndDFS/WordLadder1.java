/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList. sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
*/
package Graphs.ProblemsOnBFSAndDFS;
import java.util.*;

public class WordLadder1 {

    static class Pair{
        String s;
        int level;
        Pair(String str, int l){
            s=str;
            level = l;
        }
    }
    static int optimal(String beginWord, String endWord, List<String> wordList){
        if(!wordList.contains(endWord))
            return 0;

        Set<String> set = new HashSet<>(wordList);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);

        int count = 0;
        while (!q.isEmpty()){
            Pair p = q.poll();
            String word = p.s;
            int dist = p.level;
            if(word.equals(endWord)){
                count=dist;
                break;
            }
            char[] arr = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char original = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String next = new String(arr);
                    if (set.contains(next)) {
                        q.add(new Pair(next, dist + 1));
                        set.remove(next);
                    }
                }
                arr[i] = original;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        System.out.println(optimal("hit","cog",wordList));
    }
}
