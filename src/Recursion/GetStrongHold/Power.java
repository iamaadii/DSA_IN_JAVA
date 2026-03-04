/*
Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
*/
package Recursion.GetStrongHold;

import java.util.PriorityQueue;

public class Power {
    static double bruteForce(double x, int n){
        long power = Math.abs((long) n);
        double res = 1;
        for (long i=0;i<power;i++){
            res = res * x;
        }
        if(n<0){
            res = 1/res;
        }
        return res;
    }


    static double optimal(double x, int n){
        long power = Math.abs((long) n);
        double res = 1;
        while (power>0){
            if (power%2==0){
                x=x*x;
                power = power/2;
            }
            else{
                res = res*x;
                power = power-1;
            }
        }
        if (n<0){
            res = 1/res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(bruteForce(2.0000,10));
        System.out.println(optimal(2.0000,10));
    }
}
