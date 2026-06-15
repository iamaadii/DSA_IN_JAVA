package BitManipulation.Interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3,1,2};
        System.out.println(usingMap(arr));
        System.out.println(usingBitManipulation(arr));
        System.out.println(usingSorting(arr));
        System.out.println(usingBuckets(arr));
    }

    static int usingMap(int[] nums){
        Map<Integer,Integer> mp = new HashMap<>();

        for (int e : nums) {
            mp.put(e, mp.getOrDefault(e, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }




    static int usingBitManipulation(int[] nums){
        int ans=0;
        for(int i=0;i<=31;i++){
            int count=0;
            for(int e: nums){
                if( (e & (1<<i)) != 0) count+=1;
            }
            if(count%3==1) ans=ans | (1<<i);
        }
        return ans;
    }



    static int usingSorting(int[] arr){
        Arrays.sort(arr);
        for (int i=1;i<arr.length;i+=3){
            if (arr[i]!=arr[i-1]) return arr[i-1];
        }
        return arr[arr.length-1];
    }


    static int usingBuckets(int[] arr){
        int ones=0,twos=0;
        for (int e:arr){
            ones = (ones^e) & ~twos;
            twos = (twos^e) & ~ones;
        }
        return ones;
    }
}
