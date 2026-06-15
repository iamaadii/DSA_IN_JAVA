package TwoPointer_And_SlidingWindow.Medium;
import  java.util.*;
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    static int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int maxSize = 0;
        Map<Character,Integer> mp = new HashMap<>();
        int left = 0;
        for(int right=0;right<n;right++){
            char c = s.charAt(right);
            if(mp.containsKey(c)){
                left = Math.max(left,mp.get(c)+1);
            }
            mp.put(c,right);
            maxSize = Math.max(maxSize,right-left+1);
        }
        return maxSize;
    }
}
