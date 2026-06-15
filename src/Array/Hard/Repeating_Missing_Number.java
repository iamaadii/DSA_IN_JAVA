/*
Given an unsorted array arr[] of size n, containing elements from the range 1 to n, it is known that one number in this
range is missing, and another number occurs twice in the array, find both the duplicate number and the missing number.
*/

package Array.Hard;
import java.util.ArrayList;
import java.util.Arrays;

public class Repeating_Missing_Number {

//    public static void main(String[] args) {
//        int[] arr = {4,3,6,2,1,1};
//        int missing = 0, repeating=0;
//        for(int i=1; i<=arr.length;i++){
//            int count=0;
//            for (int j=0;j< arr.length;j++){
//                if(i==arr[j]) count+=1;
//            }
//            if(count==0) missing=i;
//            if(count==2) repeating=i;
//        }
//        System.out.println(missing+" "+repeating);
//    }




//    public static void main(String[] args) {
//        int[] arr = {4,3,6,2,1,1};
//        int[] hash = new int[arr.length+1];
//        for (int element:arr){
//            hash[element]+=1;
//        }
//
//        ArrayList<Integer> l = new ArrayList<>();
//        for (int i=1;i<hash.length;i++){
//            if(hash[i]==2) l.add(i);
//            else if(hash[i]==0) l.add(i);
//        }
//        System.out.println(l);
//    }


    public static void main(String[] args) {
        int[] arr = {4,3,6,2,1,1};
        long n = arr.length;

        long sn = (n*(n+1))/2;
        long s2n = (n*(n+1)*(2*n+1))/6;
        long s = 0, s2 = 0;
        for(int element:arr) {
            s += element;
            s2 += ((long) element * (long) element);
        }

        long val1 = s-sn;
        long val2 = s2-s2n;
        val2 = val2/val1;
        long repeating = (val1+val2)/2;
        long missing = repeating-val1;

        ArrayList<Integer> res = new ArrayList<>();
        res.add((int) repeating);
        res.add((int) missing);

        System.out.println(res);
    }

    public static void findMissingRepeatingNumbers() {
        // Size of the array
        int[] nums = {4,3,6,2,1,1};
        int n = nums.length;

        // XOR of all elements and numbers from 1 to n
        int xr = 0;
        for (int i = 0; i < n; i++) {
            xr = xr ^ nums[i];     // XOR with array element
            xr = xr ^ (i + 1);     // XOR with natural number
        }

        // Get the rightmost set bit in xr
        int number = (xr & ~(xr - 1));

        // Two groups based on this bit
        int zero = 0, one = 0;

        // Divide nums & natural numbers 1 to n into groups and XOR within each group
        for (int i = 0; i < n; i++) {
            if ((nums[i] & number) != 0) {
                one ^= nums[i];
            } else {
                zero ^= nums[i];
            }

            if (((i+1) & number) != 0) {
                one ^= i;
            } else {
                zero ^= i;
            }
        }

        // Check which is repeating and which is missing
        int cnt = 0;
        for (int val : nums) {
            if (val == zero) cnt++;
        }

        if (cnt == 2) {
            System.out.println("Repeating: "+zero); // zero is repeating
            System.out.println("Missing: "+one); // one is missing
        }
        else{
            System.out.println("Repeating: "+one); // one is repeating
            System.out.println("Missing: "+zero); // zero is missing
        }
    }
}
