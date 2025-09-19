// Unequal number of positive & negative numbers
package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeArrayElementsBySign2 {
//    public static void main(String[] args) {
//        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3,1,-2,5,2,-4));
//
//        List<Integer> positive = new ArrayList<>();
//        List<Integer> negative = new ArrayList<>();
//
//        for (int e : arr) {
//            if (e < 0)
//                negative.add(e);
//            else
//                positive.add(e);
//        }
//
//        if(positive.size() > negative.size()){
//            for(int i=0;i<negative.size();i++){
//                arr.set(2*i,positive.get(i));
//                arr.set(2*i+1,negative.get(i));
//            }
//
//            int index = negative.size() * 2;
//            for(int i=negative.size();i<positive.size();i++){
//                arr.set(index,positive.get(i));
//                index+=1;
//            }
//        }
//
//        else{
//            for(int i=0;i<positive.size();i++){
//                arr.set(2*i,positive.get(i));
//                arr.set(2*i+1,negative.get(i));
//            }
//
//            int index = positive.size() * 2;
//            for(int i=positive.size();i<negative.size();i++){
//                arr.set(index,negative.get(i));
//                index+=1;
//            }
//        }
//
//        System.out.println(arr);
//    }


    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3,1,2,5,2,4));

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int e : arr) {
            if (e < 0)
                negative.add(e);
            else
                positive.add(e);
        }

        int min = Math.min(positive.size(),negative.size());
        int n=0;
        int p=0;

        for(int i=0;i<min;i++){
            arr.set(2*i,positive.get(p));
            p+=1;
            arr.set(2*i+1,negative.get(n));
            n+=1;
        }

        int temp = min*2;
        while(n<negative.size()){
            arr.set(temp,negative.get(n));
            n++;
            temp++;
        }
        while(p<positive.size()){
            arr.set(temp,positive.get(p));
            p++;
            temp++;
        }
        System.out.println(arr);
    }
}
