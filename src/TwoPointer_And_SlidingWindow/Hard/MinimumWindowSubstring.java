package TwoPointer_And_SlidingWindow.Hard;
import java.util.*;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(bruteForce(s,t));
        System.out.println(better(s,t));
        System.out.println(optimal(s,t));
    }




    static String bruteForce(String s, String t){
        if(s.equals(t)){
            return s;
        }

        int m = s.length();
        Map<Character,Integer> tMap = new HashMap<>();
        for(char ch: t.toCharArray()){
            tMap.put(ch,tMap.getOrDefault(ch,0)+1);
        }

        int startInd = -1;
        int minSize = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            Map<Character,Integer> sMap = new HashMap<>();
            for(int j=i;j<m;j++){
                char ch = s.charAt(j);
                sMap.put(ch,sMap.getOrDefault(ch,0)+1);

                boolean flag = true;
                for(Map.Entry<Character,Integer> entry: tMap.entrySet()){
                    char c = entry.getKey();
                    if(!sMap.containsKey(c) || sMap.get(c)<tMap.get(c)){
                        flag=false;
                        break;
                    }
                }

                if(flag){
                    if((j-i+1 < minSize) ){
                        minSize = j-i+1;
                        startInd = i;
                    }
                    break;
                }
            }
        }
        if(startInd==-1){
            return "";
        }
        return s.substring(startInd,startInd+minSize);
    }





    static String better(String s, String t) {
        int n = s.length();
        int m = t.length();
        int minSize = Integer.MAX_VALUE;

        Map<Character,Integer> tMap = new HashMap<>();
        for(char ch : t.toCharArray()){
            tMap.put(ch,tMap.getOrDefault(ch,0)+1);
        }

        int startInd = -1;
        Map<Character,Integer> sMap = new HashMap<>();
        int count = m;
        int left=0;
        for(int right=0;right<n;right++){
            char ch = s.charAt(right);
            sMap.put(ch,sMap.getOrDefault(ch,0)+1);
            if(tMap.containsKey(ch) && sMap.get(ch)<=tMap.get(ch)){
                count-=1;
            }

            while(count==0){
                if(right-left+1<minSize){
                    minSize = right-left+1;
                    startInd = left;
                }
                char leftChar = s.charAt(left);
                sMap.put(leftChar,sMap.get(leftChar)-1);
                if(tMap.containsKey(leftChar) && sMap.get(leftChar)<tMap.get(leftChar)){
                    count += 1;
                }
                left += 1;
            }
        }
        if(startInd==-1){
            return "";
        }
        return s.substring(startInd,startInd+minSize);
    }







    static String optimal(String s, String t){
        int n = s.length();
        int minSize = Integer.MAX_VALUE;
        int count = 0;
        int startInd = -1;

        int[] freq = new int[128];
        for(char ch : t.toCharArray()){
            freq[ch]+=1;
        }

        int left=0;
        for(int right=0;right<n;right++){
            char ch = s.charAt(right);
            if(freq[ch]>0){
                count+=1;
            }
            freq[ch]-=1;

            while(count==t.length()){
                if(right-left+1<minSize){
                    minSize = right-left+1;
                    startInd = left;
                }
                char leftChar = s.charAt(left);
                freq[leftChar] += 1;
                if(freq[leftChar]>0){
                    count -= 1;
                }
                left += 1;
            }
        }
        if(startInd==-1){
            return "";
        }
        return s.substring(startInd,startInd+minSize);
    }
}
