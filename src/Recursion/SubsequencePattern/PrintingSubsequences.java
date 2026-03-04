package Recursion.SubsequencePattern;
import java.util.*;

public class PrintingSubsequences {

    static List<List<Integer>> iterative(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }

    static void recursive(int[] arr, int i,List<Integer> l, List<List<Integer>> res){
        if(i==arr.length){
            res.add(new ArrayList<>(l));
            return;
        }
        l.add(arr[i]);
        recursive(arr,i+1,l,res);
        l.removeLast();
        recursive(arr,i+1,l,res);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        recursive(arr,0,new ArrayList<>(),res);
        System.out.println(res);

        System.out.println(iterative(arr));

    }
}
