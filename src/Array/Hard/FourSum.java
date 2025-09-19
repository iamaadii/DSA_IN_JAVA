package Array.Hard;

import java.util.*;

public class FourSum {
//   public static void main(String[] args) {
//        int[] arr = {2,2,2,2,2};
//        int target = 8;
//        Set<List<Integer>> res = new HashSet<>();
//        for (int i=0;i<arr.length;i++)
//        {
//            for (int j = i+1;j<arr.length;j++)
//            {
//                for (int k=j+1;k< arr.length;k++)
//                {
//                    for (int m=k+1;m<arr.length;m++)
//                    {
//                        List<Integer> l = new ArrayList<>();
//                        long sum = (long) arr[i] + (long) arr[j] + (long) arr[k] + (long) arr[m];
//                        if (sum == target)
//                        {
//                            l.add(arr[i]); l.add(arr[j]); l.add(arr[k]); l.add(arr[m]);
//                            Collections.sort(l);
//                            res.add(l);
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(res);
//    }




    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        int target = 0;
        Set<List<Integer>> res = new HashSet<>();
        for (int i=0;i<arr.length;i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                TreeSet<Integer> set = new TreeSet<>();
                for (int k = j + 1; k < arr.length; k++)
                {
                    int l = target - (arr[i]+arr[j]+arr[k]);
                    if(set.contains(l))
                    {
                        List<Integer> list = new ArrayList<>();
                        list.add(arr[i]); list.add(arr[j]);list.add(arr[k]);list.add(l);
                        Collections.sort(list);
                        res.add(list);
                    }
                    set.add(arr[k]);
                }
            }
        }
        System.out.println(res);
    }







//    public static void main(String[] args) {
//        int[] arr = {2,2,2,2,2};
//        int target = 8;
//        Arrays.sort(arr);
//
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i=0;i<arr.length;i++){
//            if (i>0 && arr[i] == arr[i-1]) continue;
//            for (int j = i+1;j<arr.length;j++){
//                if(j!=i+1 && arr[j]==arr[j-1]) continue;
//                int k = j+1;
//                int l = arr.length-1;
//                while (k<l){
//                    long sum = (long) arr[i] + (long) arr[j] + (long) arr[k] + (long) arr[l];
//                    if(sum==target){
//                        res.add(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
//                        k++; l--;
//                        while (k<l && arr[k]==arr[k-1]) k++;
//                        while (k<l && arr[l]==arr[l+1]) l--;
//                    }
//                    else if(sum<target) k++;
//                    else l--;
//                }
//            }
//        }
//        System.out.println(res);
//    }

}
