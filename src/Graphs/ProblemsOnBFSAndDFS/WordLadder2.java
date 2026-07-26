/*
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
*/
package Graphs.ProblemsOnBFSAndDFS;
import java.util.*;

public class WordLadder2 {

    static List<List<String>> optimal(String beginWord, String endWord, List<String> wordList){
        List<List<String>> result = new ArrayList<>();
        if(!wordList.contains(endWord)) return result ;
        Set<String> set = new HashSet<>(wordList);
        Queue<List<String>> q = new LinkedList<>();
        q.add(new ArrayList<>(List.of(beginWord)));
        set.remove(beginWord);
        while (!q.isEmpty()){
            int s = q.size();
            Set<String> usedWords = new HashSet<>();
            for (int i=0;i<s;i++){
                List<String> curr = q.poll();
                String lastWord = curr.getLast();
                if (lastWord.equals(endWord)){
                    result.add(curr);
                    continue;
                }
                char[] arr = lastWord.toCharArray();
                for (int j=0;j<lastWord.length();j++) {
                    char original = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String newWord = new String(arr);
                        if (set.contains(newWord)) {
                            usedWords.add(newWord);
                            List<String> newPath = new ArrayList<>(curr);
                            newPath.add(newWord);
                            q.add(newPath);
                        }
                    }
                    arr[j] = original;
                }
            }
            for (String e: usedWords) {
                set.remove(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        System.out.println(optimal("hit","cog",wordList));
    }
}
