package BitManipulation.Interview;

public class XorInGivenRange {
    public static void main(String[] args) {
        System.out.println(findXOR(4,7));
    }

    static int helper(int n){
        if(n%4==1) return 1;
        else if(n%4==2) return n+1;
        else if(n%4==3) return 0;
        return n;
    }

    public static int findXOR(int l, int r) {
        // code here
        return helper(l-1)^helper(r);
    }
}
