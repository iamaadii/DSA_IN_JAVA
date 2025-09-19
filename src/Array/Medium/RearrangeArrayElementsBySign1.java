// Equal number of positive & negative numbers
package Array.Medium;

import java.util.Arrays;

public class RearrangeArrayElementsBySign1 {
//    public static void main(String[] args) {
//        int[] arr = {3,1,-2,-5,2,-4};
//
//        int[] positive = new int[arr.length/2];
//        int[] negative = new int[arr.length/2];
//
//        int j=0;
//        int k=0;
//        for(int i=0;i< arr.length;i++){
//            if(arr[i]<0){
//                negative[j++]=arr[i];
//            }
//            else{
//                positive[k++] = arr[i];
//            }
//        }
//
//        for(int i=0;i<positive.length;i++){
//            arr[2*i] = positive[i];
//            arr[2*i+1] = negative[i];
//        }
//        System.out.println(Arrays.toString(arr));
//    }


    public static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};

        int[] duplicate = new int[arr.length];
        int positive = 0;
        int negative = 1;
        for(int e:arr){
            if(e>0) {
                duplicate[positive] = e;
                positive+=2;
            }
            else {
                duplicate[negative] = e;
                negative+=2;
            }
        }
        System.out.println(Arrays.toString(duplicate));
    }
}
