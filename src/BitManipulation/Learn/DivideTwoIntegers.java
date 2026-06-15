package BitManipulation.Learn;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(optimal(3,22));
    }

    static int optimal(int divisor, int dividend){
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if(dividend == Integer.MIN_VALUE && divisor == 1){
            return Integer.MIN_VALUE;
        }

        boolean sign = true;
        if(dividend<0 && divisor>0) sign=false;
        if(dividend>0 && divisor<0) sign=false;

        long n = Math.abs(dividend);
        long d = Math.abs(divisor);
        long ans=0;

        while(n>=d){
            int count = 0;
            while(n >= (d << (count + 1))){
                count+=1;
            }
            ans += (1L <<count);
            n = n - (d<<count);
        }
        return sign ? (int) ans : -(int)ans;
    }
}
