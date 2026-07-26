package Graphs.ProblemsOnBFSAndDFS;
import java.util.*;

public class WordLadder2_Optimal {
    static List<List<String>> ans;
    static Map<String,Integer> mp;

    static void dfs(String word,List<String> seq,String beginWord){
        if(word.equals(beginWord)){
            List<String> temp = new ArrayList<>(seq);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }
        char[] arr = word.toCharArray();
        for(int i=0;i<word.length();i++){
            char original = arr[i];
            for(char c='a';c<='z';c++){
                arr[i] = c;
                String newWord = new String(arr);
                if(mp.containsKey(newWord) && mp.get(newWord)+1==mp.get(word)){
                    seq.add(newWord);
                    dfs(newWord,seq,beginWord);
                    seq.removeLast();
                }
            }
            arr[i] = original;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans = new ArrayList<>();
        Set<String> st = new HashSet<>(wordList);
        if(!st.contains(endWord)){
            return ans;
        }

        Queue<String> q = new LinkedList<>();
        mp = new HashMap<>();
        mp.put(beginWord,0);
        q.add(beginWord);
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.poll();
            if(word.equals(endWord)){
                break;
            }
            char[] arr = word.toCharArray();
            for(int i=0;i<word.length();i++){
                char original = arr[i];
                for(char c='a';c<='z';c++){
                    arr[i] = c;
                    String newWord = new String(arr);
                    if(st.contains(newWord)){
                        mp.put(newWord,mp.get(word)+1);
                        q.add(newWord);
                        st.remove(newWord);
                    }
                }
                arr[i] = original;
            }
        }

        if(mp.containsKey(endWord)){
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord,seq,beginWord);
        }
        return ans;
    }
}
