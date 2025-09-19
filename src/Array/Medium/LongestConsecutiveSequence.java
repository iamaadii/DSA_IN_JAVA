package Array.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
//    public static void main(String[] args) {
//        int[] arr = {102,4,100,1,101,3,2,1,1};
//        int maxLength = 1;
//        for(int i=0;i< arr.length;i++) {
//            int count = 1;
//            int x = arr[i];
//            while (linearSearch(arr, x + 1) == true) {
//                x += 1;
//                count += 1;
//            }
//            maxLength=Math.max(maxLength,count);
//        }
//        System.out.println(maxLength);
//    }
//
//    static boolean linearSearch(int[] arr,int x){
//        for(int element:arr){
//            if(element==x)
//                return true;
//        }
//        return false;
//    }



//    public static void main(String[] args) {
//        int[] arr = {102,4,100,1,101,3,2,1,1};
//
//        Arrays.sort(arr);
//
//        int lastSmaller = Integer.MIN_VALUE;
//        int maxLength = 1;
//        int countCurrent = 0;
//        for (int i=0;i<arr.length;i++){
//            if((lastSmaller+1) == arr[i]){
//                countCurrent+=1;
//                lastSmaller=arr[i];
//            }
//            else if(arr[i]!=lastSmaller){
//                countCurrent=1;
//                lastSmaller=arr[i];
//            }
//            maxLength=Math.max(maxLength,countCurrent);
//        }
//        System.out.println(maxLength);
//    }


    public static void main(String[] args) {
        int[] arr = {102,4,100,1,101,3,2};

        Set<Integer> s = new HashSet<>();
        for(int e: arr){
            s.add(e);
        }

        System.out.println(s);

        int maxLength = 1;
        for(int e: s){
            int x = e;
            if(!s.contains(x-1)){
                int count=1;
                while(s.contains(x+1)){
                    count+=1;
                    x+=1;
                }
                maxLength=Math.max(maxLength,count);
            }
        }
        System.out.println(maxLength);
    }
}
