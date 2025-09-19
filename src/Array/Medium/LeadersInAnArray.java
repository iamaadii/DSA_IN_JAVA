//You are given an array arr of positive integers. Your task is to find all the leaders in the array. An element is
// considered a leader if it is greater than or equal to all elements to its right. The rightmost element is always a leader.

package Array.Medium;

import java.util.ArrayList;
import java.util.List;

public class LeadersInAnArray {
//    public static void main(String[] args) {
//        int[] arr = {10,22,12,3,0,6};
//        List<Integer> l = new ArrayList<>();
//        for(int i=0;i<arr.length;i++){
//            boolean leader=true;
//            for(int j=i+1;j<arr.length;j++){
//                if(arr[j]>arr[i]) {
//                    leader=false;
//                    break;
//                }
//            }
//            if(leader==true){
//                l.add(arr[i]);
//            }
//        }
//        System.out.println(l);
//    }


    public static void main(String[] args) {
        int[] arr = {61,61,17};
        ArrayList<Integer> l = new ArrayList<>();
        int maxValue = Integer.MIN_VALUE;
        for (int i=arr.length-1;i>=0;i--){
            if(arr[i]>=maxValue){
                l.add(arr[i]);
                maxValue = arr[i];
            }
        }

        int i=0;
        int j=l.size()-1;
        while (i<=j){
            int temp = l.get(i);
            l.set(i,l.get(j));
            l.set(j,temp);
            i++;
            j--;
        }
        System.out.println(l);
    }
}
