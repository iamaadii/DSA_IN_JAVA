package Array.Easy;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArray {
    public static void main(String[] args) {
        int[] a = {1,2,2,3,3,4,5,6};
        int[] b = {2,3,3,5,6,6,7};

        List<Integer> l = new ArrayList<>();
        int i=0,j=0;

        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                i++;
            }
            else if(b[j]<a[i]){
                j++;
            }
            else{
                l.add(a[i]);
                i++;
                j++;
            }
        }

        System.out.println(l);
    }
}
