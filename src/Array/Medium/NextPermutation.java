//Given an array arr[] of integers, find the next lexicographically greater permutation of numbers.If such a permutation
// doesn’t exist (i.e., the array is the largest possible permutation), rearrange it into the lowest possible order
// (i.e., sorted ascending).

package Array.Medium;
import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {2,3,0,0,1,4,5};

        int index = -1;
        int n = arr.length;
        for(int i=n-2; i>=0; i--){
            if(arr[i] < arr[i+1]){
                index = i;
                break;
            }
        }

        if(index == -1){
            reverse(arr,0,n-1);
        }

        else{
            for(int i=n-1; i>index; i--){
                if(arr[i] > arr[index]){
                    int temp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = temp;
                    break;
                }
            }
            reverse(arr,index+1,n-1);
        }
        System.out.println(Arrays.toString(arr));
    }

    static void reverse(int[] arr,int start,int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
