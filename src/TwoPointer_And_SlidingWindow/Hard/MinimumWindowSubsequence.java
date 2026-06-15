package TwoPointer_And_SlidingWindow.Hard;

public class MinimumWindowSubsequence {
    public static void main(String[] args) {
        System.out.println(bruteForce("geeksforgeeks","eksrg"));
    }

    static String bruteForce(String s1, String s2) {
        // code here
        int n = s1.length(), m = s2.length();

        int startInd = -1, minLen = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int k=0;
            for(int j=i;j<n;j++){
                if(s1.charAt(j)==s2.charAt(k)){
                    k+=1;
                }
                if(k==m){
                    if(j-i+1 < minLen){
                        minLen = j-i+1;
                        startInd = i;
                    }
                    break;
                }
            }
        }

        if(startInd==-1) return "";
        return s1.substring(startInd,startInd+minLen);
    }
}
