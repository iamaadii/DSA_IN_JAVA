/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
*/
package Stack_And_Queues.Monotonic;

public class TrappingRainWater {
    static int bruteForce(int[] arr){
        int n = arr.length;

        int[] prefixMax = new int[n];
        prefixMax[0] = arr[0];
        for(int i=1;i<n;i++){
            prefixMax[i] = Math.max(prefixMax[i-1],arr[i]);
        }

        int[] suffixMax = new int[n];
        suffixMax[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            suffixMax[i] = Math.max(suffixMax[i+1],arr[i]);
        }

        int totalWater = 0;
        for(int i=1;i<n-1;i++){
            if(arr[i]<prefixMax[i] && arr[i]<suffixMax[i]){
                totalWater += Math.min(prefixMax[i],suffixMax[i])-arr[i];
            }
        }
        return totalWater;
    }

    static int better(int[] arr){
        int n = arr.length;
        int[] suffixMax = new int[n];
        suffixMax[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            suffixMax[i] = Math.max(suffixMax[i+1],arr[i]);
        }

        int prefixMax = arr[0];
        int totalWater = 0;
        for(int i=1;i<n-1;i++){
            prefixMax = Math.max(prefixMax,arr[i]);
            if(arr[i]<prefixMax && arr[i]<suffixMax[i]){
                totalWater += Math.min(prefixMax,suffixMax[i])-arr[i];
            }
        }
        return totalWater;
    }

    static int optimal(int[] arr){
        int left = 0, right=arr.length-1;
        int leftMax=-1, rightMax=-1;
        int totalWater = 0;
        while (left<right){
            if (arr[left]<arr[right]){
                if(leftMax>arr[left]) totalWater += leftMax-arr[left];
                leftMax = Math.max(leftMax,arr[left]);
                ++left;
            }
            else{
                if (rightMax>arr[right]) totalWater += rightMax-arr[right];
                rightMax = Math.max(rightMax,arr[right]);
                --right;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1, 0, 4, 0 ,2};
        System.out.println(bruteForce(arr));
        System.out.println(better(arr));
        System.out.println(optimal(arr));
    }
}
