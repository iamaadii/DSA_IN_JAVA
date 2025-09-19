package Array.Medium;

import java.util.Arrays;

public class SortArraysOf_0_1_2 {
//    public static void main(String[] args) {
//        int[] arr = {0,1,2,0,1,2,1,2,0,0,0,1};
//        int count0=0;
//        int count1=0;
//        int count2 =0;
//        for(int e:arr){
//            if(e==0){
//                count0+=1;
//            }
//            else if (e==1){
//                count1+=1;
//            }
//            else{
//                count2+=1;
//            }
//        }
//
//        for(int i=0;i<count0;i++){
//            arr[i]=0;
//        }
//        for(int i=count0;i<count0+count1;i++){
//            arr[i]=1;
//        }
//        for (int i=count0+count1;i< arr.length;i++){
//            arr[i]=2;
//        }
//
//        System.out.println(Arrays.toString(arr));
//    }

    public static void main(String[] args) {
        int[] arr = {1,0,2,0,1,2};
        int mid=0;
        int high =arr.length-1;
        int low=0;

        while (mid<=high) {
            if (arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                mid += 1;
                low += 1;
            } else if (arr[mid] == 1) {
                mid += 1;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high -= 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
