/*
Given an array of integers arr[]. You have to find the Inversion Count of the array.
Note : Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].
*/

package Array.Hard;
import java.util.Arrays;

public class InversionCount {
//    public static void main(String[] args) {
//        int[] arr = {2,4,1,3,5};
//        int count=0;
//        for(int i=0;i<arr.length;i++){
//            for (int j=i+1;j< arr.length;j++){
//                if(arr[i]>arr[j]){
//                    count+=1;
//                }
//            }
//        }
//        System.out.println(count);
//    }


    public static void main(String[] args) {
        int[] arr = {2,4,1,3,5};
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
        int[] temp = new int[end-start+1];
        int left = start;
        int right = mid+1;
        int k = 0;

        int count=0;
        while(left<=mid && right<=end){
            if(arr[left]<=arr[right])
                temp[k++] = arr[left++];
            else {
                count += (mid-left+1);
                temp[k++] = arr[right++];
            }
        }
        while (left<=mid) temp[k++] = arr[left++];
        while(right<=end) temp[k++] = arr[right++];
        for (int i = 0; i < temp.length; i++)
            arr[start + i] = temp[i];
        return count;
    }
}
