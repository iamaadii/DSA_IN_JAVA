package TwoPointer_And_SlidingWindow.Medium;
import java.util.*;
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABAB"; int k = 2;
        System.out.println(bruteForce(s,k));
        System.out.println(better1(s,k));
        System.out.println(better2(s,k));
        System.out.println(optimal1(s,k));
        System.out.println(optimal2(s,k));
    }


    static int bruteForce(String s, int k) {
        int maxLen = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            int[] freq = new int[26];
            int maxFreq = 0;
            for(int j=i;j<n;j++){
                char c= s.charAt(j);
                freq[c-'A'] += 1;
                maxFreq = Math.max(maxFreq,freq[c-'A']);
                int minSwapReq = (j-i+1) - maxFreq;

                if(minSwapReq<=k){
                    maxLen = Math.max(maxLen,j-i+1);
                }
                else break;
            }
        }
        return maxLen;
    }




    static int better1(String s, int k) {
        int maxLen = 0;
        int n = s.length();
        int maxFreq = 0;
        int left = 0;

        int[] freq = new int[26];
        for(int right=0;right<n;right++){
            char c = s.charAt(right);
            freq[c-'A'] += 1;
            maxFreq = Math.max(maxFreq,freq[c-'A']);

            while((right-left+1) - maxFreq > k){
                char ch = s.charAt(left);
                freq[ch-'A']-=1;
                maxFreq=0;
                for(int i=0;i<26;i++){
                    maxFreq = Math.max(maxFreq,freq[i]);
                }
                left+=1;
            }
            if((right-left+1) - maxFreq<=k){
                maxLen = Math.max(maxLen,right-left+1);
            }
        }
        return maxLen;
    }


    static int better2(String s, int k) {
        int maxLen = 0;
        int n = s.length();
        int maxFreq = 0;
        int left = 0;

        int[] freq = new int[26];
        for(int right=0;right<n;right++){
            char c = s.charAt(right);
            freq[c-'A'] += 1;
            maxFreq = Math.max(maxFreq,freq[c-'A']);

            while((right-left+1) - maxFreq > k){
                char ch = s.charAt(left);
                freq[ch-'A']-=1;
                left+=1;
            }
            if((right-left+1) - maxFreq<=k){
                maxLen = Math.max(maxLen,right-left+1);
            }
        }
        return maxLen;
    }






    static int optimal2(String s, int k) {
        int maxLen = 0;
        int n = s.length();
        int maxFreq = 0;
        int left = 0;

        int[] freq = new int[26];
        for(int right=0;right<n;right++){
            char c = s.charAt(right);
            freq[c-'A'] += 1;
            maxFreq = Math.max(maxFreq,freq[c-'A']);
            int minSwapReq = (right-left+1)-maxFreq;

            if(minSwapReq>k){
                char ch = s.charAt(left);
                freq[ch-'A']-=1;
                maxFreq=0;
                for(int i=0;i<26;i++){
                    maxFreq = Math.max(maxFreq,freq[i]);
                }
                left+=1;
            }
            else{
                maxLen = Math.max(maxLen,right-left+1);
            }
        }
        return maxLen;
    }



    static int optimal1(String s, int k) {
        int maxLen = 0;
        int n = s.length();
        int maxFreq = 0;
        int left = 0;

        int[] freq = new int[26];
        for(int right=0;right<n;right++){
            char c = s.charAt(right);
            freq[c-'A'] += 1;
            maxFreq = Math.max(maxFreq,freq[c-'A']);
            int minSwapReq = (right-left+1)-maxFreq;
            if(minSwapReq>k){
                char ch = s.charAt(left);
                freq[ch-'A']-=1;
                left+=1;
            }
            else{
                maxLen = Math.max(maxLen,right-left+1);
            }
        }
        return maxLen;
    }


}
