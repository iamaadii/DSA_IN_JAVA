/*
Given a array arr of integers, return the sums of all subsets in the list.  Return the sums in any order.
*/
package Recursion.SubsequencePattern;

import java.util.*;

public class Subset1 {
    static void helper(int i, int[] arr, ArrayList<Integer> res, int sum){
        if(i==arr.length){
            res.add(sum);
            return;
        }
        helper(i+1,arr,res,sum);
        helper(i+1,arr,res,sum+arr[i]);
    }

    static ArrayList<Integer> optimal(int[] arr) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        helper(0,arr,res,0);
        Collections.sort(res);
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {2,3,5};
        System.out.println(optimal(arr));
    }
}
