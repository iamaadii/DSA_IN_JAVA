/*
Given an integer array nums, return the number of reverse pairs in the array.
A reverse pair is a pair (i, j) where: 0 <= i < j < nums.length and nums[i] > 2 * nums[j].
*/

package Array.Hard;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {
//    public static void main(String[] args) {
//        int[] arr = {1,3,2,3,1};
//        List<Integer> res = new ArrayList<>();
//        for (int i=0;i< arr.length;i++){
//            for (int j=i+1;j<arr.length;j++){
//                if(arr[i] > 2*arr[j]) System.out.println(arr[i]+" "+arr[j]);
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] arr = {40,25,19,12,9,6,2};
        System.out.println(splitArray(arr,0,arr.length-1));
    }
    static int splitArray(int[] arr,int start,int end){
        int count = 0;
        if (start<end){
            int mid = start+(end-start)/2;
            count += splitArray(arr,start,mid);
            count += splitArray(arr,mid+1,end);
            count += merge(arr,start,mid,end);
        }
        return count;
    }

    static int merge(int[] arr, int start, int mid, int end) {
        int count=0; int j = mid+1;
        for (int i=start;i<=mid;i++){
            while (j<=end && (long)arr[i] > 2L * arr[j]) {
                j++;
            }
            count += (j - (mid+1));
        }

        int[] temp = new int[end-start+1];
        int left = start;
        int right = mid+1;
        int k = 0;
        while(left<=mid && right<=end){
            if(arr[left]<=arr[right])
                temp[k++] = arr[left++];
            else
                temp[k++] = arr[right++];
        }
        while (left<=mid) temp[k++] = arr[left++];
        while(right<=end) temp[k++] = arr[right++];

        for (int i = 0; i < temp.length; i++)
            arr[start + i] = temp[i];
        return count;
    }
}
