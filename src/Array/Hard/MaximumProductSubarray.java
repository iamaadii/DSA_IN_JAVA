/*
Given an integer array nums, find a subarray that has the largest product, and return the product.
*/

package Array.Hard;

public class MaximumProductSubarray {
//    public static void main(String[] args) {
//        int[] arr = {2,3,-2,4};
//        int res = Integer.MIN_VALUE;
//        for(int i=0;i<arr.length;i++){
//            int product = 1;
//            for (int j=i;j<arr.length;j++){
//                product*=arr[j];
//                res = Math.max(res,product);
//            }
//        }
//        System.out.println(res);
//    }


    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        int res = Integer.MIN_VALUE;

        int prefix = 1,suffix=1;
        for (int i=0;i< arr.length;i++){
            if(prefix==0) prefix=1;
            if (suffix==0) suffix=1;

            prefix=prefix*arr[i];
            suffix=suffix*arr[arr.length-1-i];
            res = Math.max(res,Math.max(prefix,suffix));
        }
        System.out.println(res);
    }
}
