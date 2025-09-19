package Array.Hard;

import java.util.HashMap;
import java.util.Map;

public class NumberofSubarrayWithXORk {
//    public static void main(String[] args) {
//        int[] arr = {4,2,2,6,4};
//        int target=6;
//        int count=0;
//        for (int i=0;i<arr.length;i++){
//            for (int j=i;j<arr.length;j++){
//                int xor=0;
//                for (int k=i;k<=j;k++){
//                    xor=xor^arr[k];
//                }
//                if(xor==target) count+=1;
//            }
//        }
//        System.out.println(count);
//    }



//    public static void main(String[] args) {
//        int[] arr = {4,2,2,6,4};
//        int target=6;
//        int count=0;
//        for (int i=0;i<arr.length;i++){
//            int xor=0;
//            for (int j=i;j<arr.length;j++){
//                xor=xor^arr[j];
//                if(xor==target) count+=1;
//            }
//        }
//        System.out.println(count);
//    }



    public static void main(String[] args) {
        int[] arr = {4,2,2,6,4};
        int k=6;
        int count=0;

        int xor = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        for (int i=0;i<arr.length;i++){
            xor ^= arr[i];
            int x = xor^k;
            if(mp.containsKey(x))
                count+=mp.get(x);
            if(mp.containsKey(xor))
                mp.put(xor,mp.get(xor)+1);
            else
                mp.put(xor,1);
        }
        System.out.println(count);
    }
}
