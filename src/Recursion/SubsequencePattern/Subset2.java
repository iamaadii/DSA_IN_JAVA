/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
*/
package Recursion.SubsequencePattern;
import java.util.*;

public class Subset2 {
    static void function1(int index,int[] arr, List<List<Integer>> res, List<Integer> curr){
        if(index==arr.length){
            ArrayList<Integer> temp = new ArrayList<>(curr);
            if (!res.contains(temp)){
                res.add(temp);
            }
            return;
        }
        curr.add(arr[index]);
        function1(index+1,arr,res,curr);
        curr.removeLast();

        function1(index+1,arr,res,curr);

    }
    static List<List<Integer>> bruteForce(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        function1(0,nums,res,new ArrayList<>());
        return res;
    }


    static void function2(int index,int[] arr, Set<List<Integer>> res, List<Integer> curr){
        if(index==arr.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(arr[index]);
        function2(index+1,arr,res,curr);
        curr.removeLast();

        function2(index+1,arr,res,curr);

    }
    static List<List<Integer>> better(int[] nums) {
        Set<List<Integer>> temp = new HashSet<>();
        function2(0,nums,temp,new ArrayList<>());

        List<List<Integer>> result = new ArrayList<>();
        result.addAll(temp);
        return result;
    }


    static void function3(int index,int[] arr, List<List<Integer>> res, List<Integer> curr){
        res.add(new ArrayList<>(curr));
        if(index==arr.length){
            return;
        }

        for(int i=index;i<arr.length;i++){
            if(i<=index || arr[i]!=arr[i-1]){
                curr.add(arr[i]);
                function3(i+1,arr,res,curr);
                curr.removeLast();
            }
        }
    }
    static List<List<Integer>> optimal(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        function3(0,nums,res,new ArrayList<>());
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,2};
        System.out.println(bruteForce(arr));
        System.out.println(bruteForce(arr));
        System.out.println(optimal(arr));
    }
}
