package TwoPointer_And_SlidingWindow.Medium;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};int goal = 2;
        System.out.println(bruteForce(nums,goal));
        System.out.println(better(nums,goal));
        System.out.println(optimal(nums,goal));
    }


    static int bruteForce(int[] arr, int goal) {
        int n = arr.length;
        int count=0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                if(sum==goal){
                    count+=1;
                }
            }
        }
        return count;
    }


    static  int better(int[] arr, int goal) {
        int n = arr.length;
        int count=0;
        int sum=0;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        for(int right=0;right<n;right++){
            sum+=arr[right];
            int req = sum-goal;

            if(mp.containsKey(req)){
                count+=mp.get(req);
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return count;
    }






    static int helper(int[] arr, int goal){
        if(goal<0) return 0;
        int left=0,sum=0,count=0;

        for(int right=0;right<arr.length;right++){
            sum+=arr[right];
            while(sum>goal){
                sum-=arr[left];
                left+=1;
            }
            if(sum<=goal){
                count+=(right-left+1);
            }
        }
        return count;
    }
    static int optimal(int[] arr, int goal) {
        return helper(arr,goal)-helper(arr,goal-1);
    }


}
