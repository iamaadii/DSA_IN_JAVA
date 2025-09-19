/*
Given a sorted array arr[]. Find the element that appears only once in the array. All other elements appear exactly twice.
*/

package BinarySearch.On1DArray;

public class SingleAmongDoublesinASorted {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,50,50,65,65};
        System.out.println(bruteForce(arr));
        System.out.println(optimal(arr));
    }
    static int bruteForce(int[] arr ){
        int n = arr.length;
        int res = Integer.MAX_VALUE;
        if(n==1) res = arr[0];
        else{
            for(int i=0;i<n;i++){
                if(i==0) {
                    if(arr[i]!=arr[i+1]) res = arr[i];
                }
                else if(i==n-1) {
                    if(arr[i]!=arr[i-1]) res = arr[i];
                }
                else{
                    if(arr[i]!=arr[i-1] && arr[i]!=arr[i+1]) res = arr[i];
                }
            }
        }
        return res;
    }

    static int optimal(int[] arr){
        int n = arr.length;
        int res = arr[0];

        if(n==1) return res;
        if(arr[0] != arr[1]) return res;
        if(arr[n-1]!=arr[n-2]) return arr[n-1];

        int low = 1;
        int high = n-2;
        while (low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]!=arr[mid+1] && arr[mid]!=arr[mid-1])
                res = arr[mid];
            else if( (mid%2==1 && arr[mid]==arr[mid-1]) || (mid%2==0 && arr[mid]==arr[mid+1]) ){
                low = mid+1;
            }
            else if( (mid%2==1 && arr[mid]==arr[mid+1]) || (mid%2==0 && arr[mid]==arr[mid-1]) ){
                high = mid-1;
            }
        }
        return res;
    }
}
