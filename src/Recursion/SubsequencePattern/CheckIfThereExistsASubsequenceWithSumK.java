package Recursion.SubsequencePattern;

public class CheckIfThereExistsASubsequenceWithSumK {
    static boolean helper(int index,int[] arr, int target, int sum){
        if(sum>target){
            return false;
        }
        else if(sum==target){
            return true;
        }
        else if(index==arr.length){
            if(sum==target){
                return true;
            }
            return false;
        }

        boolean take = helper(index+1,arr,target,sum+arr[index]);
        if(take){
            return true;
        }
        boolean notTake = helper(index+1,arr,target,sum);

        return take || notTake;
    }
    public static boolean checkSubsequenceSum(int[] arr, int K) {
        // code here
        return helper(0,arr,K,0);
    }

    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        System.out.println(checkSubsequenceSum(arr,8));
    }
}
