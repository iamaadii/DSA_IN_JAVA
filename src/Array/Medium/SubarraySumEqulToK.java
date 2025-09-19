package Array.Medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqulToK {
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
//        int k = 3;
//        int count = 0;
//
//        for(int i=0;i<arr.length;i++){
//            int temp = 0;
//            for(int j=i;j<arr.length;j++){
//                temp += arr[j];
//                if(temp==k){
//                    count+=1;
//                }
//            }
//        }
//        System.out.println(count);
//    }



    public static void main(String[] args) {
        int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
        int k = 3;

        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int prefixSum = 0;

        map.put(0,1);
        for (int i=0;i< arr.length;i++){
            prefixSum+=arr[i];

            int req = prefixSum-k;
            if(map.containsKey(req))
                count+=map.get(req);

            if(map.containsKey(prefixSum))
                map.put(prefixSum,map.get(prefixSum)+1);
            else
                map.put(prefixSum,1);
        }
        System.out.println(count);
    }
}
