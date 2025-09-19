package Array.Easy;

import java.util.ArrayList;

public class UnionOfTwoSortedArray {
    public static void main(String[] args) {
        int[] a = {2,2,4,4};
        int[] b = {2,2,2,4,4};

        int i=0;
        int j=0;

        ArrayList<Integer> l = new ArrayList<>();
        while(i<a.length && j<b.length){
            if(a[i]<=b[j]){
                if( l.isEmpty() || (a[i] != l.getLast()) ){
                    l.add(a[i]);
                }
                i++;
            }
            else{
                if( l.isEmpty() || (b[j] != l.getLast()) ){
                    l.add(b[j]);
                }
                j++;
            }
        }

        while(i<a.length){
            if(  l.isEmpty() || (a[i] != l.getLast()) )
                l.add(a[i]);
            i++;
        }

        while(j<b.length){
            if(  l.isEmpty() || (b[j] != l.getLast()) )
                l.add(b[j]);
            j++;
        }

        System.out.println(l);
    }
}

