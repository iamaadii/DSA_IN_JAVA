/*
Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge them in sorted order without using
any extra space. Modify a[] so that it contains the first n elements and modify b[] so that it contains the last m elements.
*/
package Array.Hard;
import java.util.Arrays;

public class MergeTwoSortedArray {
//    public static void main(String[] args) {
//        int[] arr1 = {1, 3, 5, 7};
//        int[] arr2 = {0, 2, 6, 8, 9};
//
//        int[] temp = new int[arr1.length + arr2.length];
//        int left = 0;
//        int right = 0;
//        int k = 0;
//
//        while (left < arr1.length && right < arr2.length) {
//            if(arr1[left]<=arr2[right])
//                temp[k++]=arr1[left++];
//            else
//                temp[k++]=arr2[right++];
//        }
//        while (left<arr1.length) temp[k++] = arr1[left++];
//        while (right<arr2.length) temp[k++] = arr2[right++];
//
//        for (int i=0;i<temp.length;i++){
//            if(i< arr1.length)
//                arr1[i]=temp[i];
//            else
//                arr2[i-arr1.length] = temp[i];
//        }
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));
//    }



//    public static void main(String[] args) {
//        int[] arr1 = {1, 3, 5, 7};
//        int[] arr2 = {0, 2, 6, 8, 9};
//
//        int i= arr1.length-1,j=0;
//        while(i>=0 && j< arr2.length){
//            if(arr1[i]>arr2[j]){
//                int temp = arr1[i];
//                arr1[i] = arr2[j];
//                arr2[j] = temp;
//                i--;j++;
//            }
//            else
//                break;
//        }
//        Arrays.sort(arr1);
//        Arrays.sort(arr2);
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));
//    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};
        int n = arr1.length, m = arr2.length;

        int len = n + m;
        int gap = (len + 1) / 2;
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                //arr1 & arr2
                if (left < n && right >= n) {
                    if (arr1[left] > arr2[right - n]) {
                        int temp = arr1[left];
                        arr1[left] = arr2[right - n];
                        arr2[right - n] = temp;
                    }
                }
                //arr2 & arr2
                else if (left >= n) {
                    if (arr2[left - n] > arr2[right - n]) {
                        int temp = arr2[left - n];
                        arr2[left - n] = arr2[right - n];
                        arr2[right - n] = temp;
                    }
                }
                //arr1 & arr1
                else {
                    if (arr1[left] > arr1[right]) {
                        int temp = arr1[left];
                        arr1[left] = arr1[right];
                        arr1[right] = temp;
                    }
                }
                left++;
                right++;
            }
            if (gap == 1) break;
            gap = (gap + 1) / 2;
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}