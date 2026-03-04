/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
*/
package Recursion.SubsequencePattern;
import java.util.*;

public class Permutation2 {
    static void helper(List<Integer> curr, List<List<Integer>> res, int[] arr, boolean[] flag){
        if(curr.size()==arr.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(i>0 && arr[i]==arr[i-1] && !flag[i-1]){
                continue;
            }
            else if(flag[i]==false){
                curr.add(arr[i]);
                flag[i] = true;
                helper(curr,res,arr,flag);
                curr.removeLast();
                flag[i] = false;
            }
        }
    }
    static List<List<Integer>> optimal(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        Arrays.sort(nums);
        helper(new ArrayList<>(),res,nums,flag);
        return res;
    }



    public static void main(String[] args) {
        int[] nums = {1,1,2,2};
        System.out.println(optimal(nums));
    }
}
