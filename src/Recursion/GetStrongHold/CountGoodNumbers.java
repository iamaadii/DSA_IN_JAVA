package Recursion.GetStrongHold;

public class CountGoodNumbers {
    static long power(long x, long even){
        long ans = 1;
        while(even>0) {
            if(even%2==0) {
                x = (x*x)%1_000_000_007;
                even = even/2;
            }
            else {
                ans = (ans*x)%1_000_000_007;
                even = even-1;
            }
        }
        return ans;
    }

    public static int optimal(long n) {
        long even = (n+1)/2;
        long odd = n/2;

        long part1 = power(5, even);
        long part2 = power(4, odd);
        return (int)((part1 * part2) % 1_000_000_007);
    }

    public static void main(String[] args) {
        System.out.println(optimal(4));
    }
}
