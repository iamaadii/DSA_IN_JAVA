/*
Given an array arr of non-negative integers and an integer target, the task is to count all subsets of the array whose sum is equal to the given target.
*/
package Recursion.SubsequencePattern;

public class CountAllSubsequencesWithSumk {
    static void helper(int index,int[] arr, int target, int sum,int[] count){
        if(index==arr.length){
            if(sum==target){
                count[0] =  count[0]+1;
            }
            return;
        }
        helper(index+1,arr,target,sum+arr[index],count);
        helper(index+1,arr,target,sum,count);
    }
    static int optimal(int[] nums, int target) {
        int[] count = {0};
        helper(0,nums,target,0,count);
        return count[0];
    }


    public static void main(String[] args) {
        int[] arr = {0,10,0};
        System.out.println(optimal(arr,0));
    }
}
