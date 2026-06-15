package BitManipulation.Learn;

public class NoOfSetBits {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(method1(n));
        System.out.println(method2(n));
    }


    static int method1(int n){
        int count=0;
        while (n>0){
            count += n & 1;
            n  = n >> 1;
        }
        return count;
    }

    static int method2(int n){
        int count = 0;
        while (n>0){
            n = n & (n-1);
            count+=1;
        }
        return count;
    }
}
