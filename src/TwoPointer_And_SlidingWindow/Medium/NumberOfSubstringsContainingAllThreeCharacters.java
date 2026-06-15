package TwoPointer_And_SlidingWindow.Medium;

public class NumberOfSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
        System.out.println(bruteForce("abcabc"));
        System.out.println(better("abcabc"));
    }

    static int bruteForce(String s){
        int count=0;
        int n = s.length();

        for(int i=0;i<n;i++){
            int[] freq = {-1,-1,-1};
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a'] = 1;
                if(freq[0]!=-1 && freq[1]!=-1 && freq[2]!=-1){
                    count+=(n-j);
                    break;
                }
            }
        }
        return count;
    }


    static int better(String  s){
        int i=0,count=0;
        int n = s.length();
        int[] freq = {0,0,0};
        int left=0;
        for(int right=0;right<n;right++){
            char c = s.charAt(right);
            freq[c-'a'] += 1;
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                count += (n-right);
                freq[s.charAt(left)-'a']-=1;
                left+=1;
            }
        }
        return count;
    }


    static int numberOfSubstrings(String s) {
        int count=0;
        int n = s.length();
        int[] freq = {-1,-1,-1};

        for(int i=0;i<n;i++){
            char c= s.charAt(i);
            freq[c-'a'] = i;

            if(freq[0]!=-1 && freq[1]!=-1 && freq[2]!=-1){
                int start = Math.min(freq[0],Math.min(freq[1],freq[2]));
                count += (start+1);
            }
        }
        return count;
    }
}
