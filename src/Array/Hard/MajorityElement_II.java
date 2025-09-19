package Array.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement_II {
//    public static void main(String[] args) {
//        int[] arr = {1,1,1,3,3,2,2,2};
//        ArrayList<Integer> res = new ArrayList<>();
//
//        for(int i=0;i<arr.length;i++){
//            int count=0;
//            for(int j=0;j<arr.length;j++){
//                if(arr[i]==arr[j])
//                    count+=1;
//            }
//            if(count>(arr.length)/3 && !res.contains(arr[i]))
//                res.add(arr[i]);
//        }
//        System.out.println(res);
//    }

//    public static void main(String[] args) {
//        int[] arr = {1,1,1,1,3,2,2,2};
//        ArrayList<Integer> res = new ArrayList<>();
//        Map<Integer,Integer> mp = new HashMap<>();
//
//        for (int j : arr) {
//            if (!mp.containsKey(j)) {
//                mp.put(j, 1);
//            } else {
//                mp.put(j, mp.get(j) + 1);
//                int temp = mp.get(j);
//                if (temp > (arr.length) / 3 && !res.contains(j)) {
//                    res.add(j);
//                }
//            }
//        }
//        System.out.println(res);
//    }


    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1,3 ,3, 2};
        int e1 = Integer.MIN_VALUE, e2 = Integer.MIN_VALUE, count1 = 0, count2=0;
        for (int i=0;i< arr.length;i++){
            if(count1==0 && arr[i]!=e2) {
                count1 = 1;
                e1 = arr[i];
            }
            else if (count2==0 && arr[i]!=e1){
                count2=1;
                e2=arr[i];
            }
            else if (arr[i]==e1)
                count1+=1;
            else if (arr[i]==e2)
                count2+=1;
            else{
                count1--;
                count2--;
            }
        }
        List<Integer> res = new ArrayList<>();
        int flag1=0,flag2=0;
        for (int e:arr){
            if(e==e1)
                flag1+=1;
            if (e==e2)
                flag2+=1;
        }
        if(flag1>(arr.length)/3)
            res.add(e1);
        if(flag2>(arr.length)/3)
            res.add(e2);

        System.out.println(res);
    }
}
