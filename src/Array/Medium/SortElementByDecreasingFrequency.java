/*
Given an array of integers arr[], sort the array according to the frequency of elements, i.e. elements that have higher
frequency comes first. If the frequencies of two elements are the same, then the smaller number comes first.
*/
package Array.Medium;

import java.util.HashMap;
import java.util.Map;

public class SortElementByDecreasingFrequency {
    public static void main(String[] args) {
        int[] arr = {5,5,4,6,4};
        Map<Integer,Integer> mp = new HashMap<>();

        for (int element:arr){
            if(mp.containsKey(element)) mp.put(element,mp.get(element)+1);
            else mp.put(element,1);
        }
        System.out.println(mp);
    }
}
