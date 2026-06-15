package TwoPointer_And_SlidingWindow.Hard;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3}; int k=2;
        System.out.println(optimal(arr,k));
    }


    static int helper(int[] arr, int k){
        int left=0,right=0,count=0;
        Map<Integer,Integer> mp = new HashMap<>();
        for(right=0;right<arr.length;right++){
            mp.put(arr[right],mp.getOrDefault(arr[right],0)+1);
            while(mp.size()>k){
                mp.put(arr[left],mp.get(arr[left])-1);
                if(mp.get(arr[left])==0){
                    mp.remove(arr[left]);
                }
                left+=1;
            }
            if(mp.size()<=k){
                count+=(right-left+1);
            }
        }
        return count;
    }
    static int optimal(int[] arr, int k) {
        return helper(arr,k) - helper(arr,k-1);
    }
}
