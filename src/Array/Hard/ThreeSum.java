package Array.Hard;

import java.util.*;

public class ThreeSum {
//    public static void main(String[] args) {
//        int[] arr = {-1,0,1,2,-1,-4};
//        Set<List<Integer>> res = new HashSet<>();
//
//        for (int i=0;i<arr.length;i++)
//        {
//            for (int j = i+1;j<arr.length;j++)
//            {
//                for (int k=j+1;k< arr.length;k++)
//                {
//                    List<Integer> l = new ArrayList<>();
//                    if(arr[i]+arr[j]+arr[k]==0)
//                    {
//                        l.add(arr[i]); l.add(arr[j]); l.add(arr[k]);
//                        Collections.sort(l);
//                        res.add(l);
//                    }
//                }
//            }
//        }
//        System.out.println(res);
//    }


//    public static void main(String[] args) {
//        int[] arr ={-1,0,1,2,-1,-4};
//        Set<List<Integer>> res = new HashSet<>();
//
//        for (int i=0;i< arr.length;i++)
//        {
//            TreeSet<Integer> set = new TreeSet<>();
//            for (int j=i+1;j< arr.length;j++)
//            {
//                int k = -(arr[i]+arr[j]);
//                if(set.contains(k))
//                {
//                    List<Integer> l = new ArrayList<>();
//                    l.add(arr[i]); l.add(arr[j]); l.add(k);
//                    Collections.sort(l);
//                    res.add(l);
//                }
//                set.add(arr[j]);
//            }
//        }
//        System.out.println(res);
//    }


    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        Arrays.sort(arr);

        List<List<Integer>> res = new ArrayList<>();

        for (int i=0;i< arr.length;i++)
        {
            if(i>0 && arr[i-1]==arr[i]) continue;
            int j=i+1;
            int k = arr.length-1;
            while (j<k)
            {
                int sum=arr[i]+arr[j]+arr[k];
                if(sum==0)
                {
                    List<Integer> l = new ArrayList<>();
                    l.add(arr[i]);l.add(arr[j]);l.add(arr[k]);
                    res.add(l);
                    j=j+1; k=k-1;
                    while (arr[j]==arr[j-1] && j<k)  j=j+1;
                    while (arr[k]==arr[k+1] && j<k)  k=k-1;
                }
                else if(sum<0) {
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        System.out.println(res);
    }
}
