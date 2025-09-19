/*
Given a positive integer n, find the square root of n. If n is not a perfect square, then return the floor value.
Floor value of any number is the greatest Integer which is less than or equal to that number.

Constraints:
1 ≤ n ≤ 3*10^4
*/
package BinarySearch.OnAnswers;

public class FindSquareRootOfaNumber {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(bruteForce(n));
        System.out.println(optimalSolution(n));
    }
    static int bruteForce(int n){
        int ans = 1;
        for (int i=1;i<=n;i++){
            if(i*i<=n) ans = i;
            else break;
        }
        return ans;
    }


    static int optimalSolution(int n){
        int low = 1;
        int high = n;
        int res = 1;

        while (low<=high){
            int mid = low+(high-low)/2;
            if(mid*mid <= n) {
                res = mid;
                low = mid + 1;
            }
            else high = mid-1;
        }
        return res;
    }
}
