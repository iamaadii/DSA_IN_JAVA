package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2,6,5,8,6};
        int sum = 8;
        int[] res = {-1,-1};

        Map<Integer,Integer> m = new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            int req = sum - arr[i];
            if (m.containsKey(req)) {
                res[0] = i;
                res[1] = m.get(req);
                break;
            }
            m.put(arr[i], i);
        }
        System.out.println(Arrays.toString(res));
    }


    //Works only if array is sorted
//    public static void main(String[] args) {
//        int[] arr = {2,5,6,8,11};
//        int target = 14;
//        int left = 0;
//        int right = arr.length-1;
//
//        int[] res = {-1,-1};
//
//        while(left<=right){
//            int sum = arr[left] + arr[right];
//
//            if(sum<target){
//                left+=1;
//            }
//            else if(sum>target){
//                right-=1;
//            }
//            else{
//                res[0] = left;
//                res[1] = right;
//                break;
//            }
//        }
//        System.out.println(Arrays.toString(res));
//    }
}
