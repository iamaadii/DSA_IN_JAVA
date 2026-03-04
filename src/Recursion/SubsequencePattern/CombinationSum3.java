/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
*/
package Recursion.SubsequencePattern;

import java.util.*;

public class CombinationSum3 {
    static void helper(int size, int maxSize, int maxSum,List<Integer> curr, List<List<Integer>> res, int sum){
        if(sum>maxSum){
            return;
        }
        else if(curr.size()==maxSize){
            if(sum==maxSum){
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        for(int i=size+1;i<=9;i++){
            if(sum+i>maxSum){
                break;
            }
            else if(sum+i<=maxSum){
                curr.add(i);
                helper(i,maxSize,maxSum,curr,res,sum+i);
                curr.removeLast();
            }
        }
    }
    static List<List<Integer>> optimal(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0,k,n,new ArrayList<>(),res,0);
        return res;
    }


    public static void main(String[] args) {
        System.out.println(optimal(3,9));
    }
}
