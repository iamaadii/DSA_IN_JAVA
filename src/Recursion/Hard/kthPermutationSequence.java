/*
The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
*/

package Recursion.Hard;
import java.util.*;
public class kthPermutationSequence {


    static String helper(int[] count, int n, int k, StringBuilder sb, boolean[] used){
        if(sb.length()==n){
            count[0]+=1;
            if(count[0]==k){
                return sb.toString();
            }
            return "";
        }
        for(int i=1;i<=n;i++){
            if(used[i]==false){
                sb.append(i);
                used[i]=true;
                String temp = helper(count,n,k,sb,used);
                if(!temp.isEmpty()){
                    return temp;
                }
                sb.deleteCharAt(sb.length()-1);
                used[i]=false;
            }
        }
        return "";
    }
    static String bruteForce(int n, int k) {
        boolean[] used = new boolean[n+1];
        int[] count={0};
        return helper(count,n,k,new StringBuilder(),used);
    }







    public static String optimal(int n, int k) {
        List<Integer> arr = new ArrayList<>();
        int fact = 1;
        for(int i=1;i<n;i++){
            fact=fact*i;
            arr.add(i);
        }
        arr.add(n);
        k=k-1;
        StringBuilder sb = new StringBuilder();

        while(true){
            int liesInBetween = k/fact;
            sb.append(arr.get(liesInBetween));
            arr.remove(liesInBetween);

            if(arr.isEmpty()){
                break;
            }

            k = k%fact;
            fact = fact/arr.size();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(bruteForce(3,3));
        System.out.println(optimal(3,3));

        System.out.println(Integer.MAX_VALUE);
    }
}
