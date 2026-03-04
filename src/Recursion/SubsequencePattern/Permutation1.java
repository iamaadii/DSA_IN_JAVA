/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
*/

package Recursion.SubsequencePattern;
import java.util.*;

public class Permutation1 {

    static void helper1(List<Integer> curr, List<List<Integer>> res, int[] arr, boolean[] used){
        if(curr.size()==arr.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!used[i]){
                curr.add(arr[i]);
                used[i] = true;
                helper1(curr,res,arr,used);
                curr.removeLast();
                used[i] = false;
            }
        }
    }
    static List<List<Integer>> optimal1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        helper1(new ArrayList<>(),res,nums,used);
        return res;
    }







    static void swap(int start, int end,int[] arr){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    static void helper2(int index,List<List<Integer>> res, int[] arr){
        if(index==arr.length){
            List<Integer> temp = new ArrayList<>();
            for (int e: arr){
                temp.add(e);
            }
            res.add(temp);
            return;
        }
        for(int i=index;i<arr.length;i++){
            swap(index,i,arr);
            helper2(index+1,res,arr);
            swap(index,i,arr);
        }
    }
    static List<List<Integer>> optimal2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper2(0,res,nums);
        return res;
    }



    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(optimal1(arr));
        System.out.println(optimal2(arr));
    }
}
