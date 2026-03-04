/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
*/
package Recursion.SubsequencePattern;
import java.util.*;

public class CombinationSum1 {
    static void helper(List<List<Integer>> res,int index, int[] arr, int target,List<Integer> current){
        if(target==0){
            res.add(new ArrayList<>(current));
            return;
        }
        else if(index == arr.length){
            return;
        }
        else if(arr[index]>target){
            helper(res,index+1,arr,target,current);
            return;
        }
        current.add(arr[index]);
        helper(res,index,arr,target-arr[index],current);

        current.removeLast();
        helper(res,index+1,arr,target,current);
    }
    static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,0,arr,target,new ArrayList<>() );
        return res;
    }


    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] {1, 2, 3},4));
    }

}
