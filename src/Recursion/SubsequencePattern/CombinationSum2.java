/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.
*/

package Recursion.SubsequencePattern;
import java.util.*;
public class CombinationSum2 {
    static void helper(List<List<Integer>> res,int index, int[] arr, int target,List<Integer> current){
        if(target==0){
            res.add(new ArrayList<>(current));
            return;
        }
        else if(index == arr.length || arr[index]>target){
            return;
        }
        for(int i=index;i<arr.length;i++){
            current.add(arr[i]);
            if(i<=index || arr[i]!=arr[i-1]) {
                helper(res,i+1,arr,target-arr[i],current);
            }
            current.removeLast();
        }
    }
    static public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        helper(res,0,arr,target,new ArrayList<>() );
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(arr,8));
    }
}
