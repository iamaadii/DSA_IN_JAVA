package TwoPointer_And_SlidingWindow.Medium;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0}; int k = 2;
        System.out.println(optimal1(nums,k));
        System.out.println(optimal2(nums,k));
    }

    static int optimal1(int[] nums, int k) {
        int i=0,zeroes=0,maxLen=Integer.MIN_VALUE;
        for(int j=0;j<nums.length;j++){
            if(nums[j]==0) zeroes+=1;
            while(zeroes>k){
                if(nums[i]==0) zeroes-=1;
                i+=1;
            }
            maxLen = Math.max(maxLen,j-i+1);
        }
        return maxLen;
    }

    static int optimal2(int[] nums, int k) {
        int i=0,zeroes=0,maxLen=Integer.MIN_VALUE;
        for(int j=0;j<nums.length;j++){
            if(nums[j]==0) zeroes+=1;
            if(zeroes>k){
                if(nums[i]==0) zeroes-=1;
                i+=1;
            }
            if(zeroes<=k) maxLen = Math.max(maxLen,j-i+1);
        }
        return maxLen;
    }
}
