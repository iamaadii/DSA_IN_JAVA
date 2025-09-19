package BinarySearch.On1DArray;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] arr = {1,5,1,2,1};
        System.out.println(bruteForce(arr));
        System.out.println(optimal(arr));
    }

    static int bruteForce(int[] arr){
        int n= arr.length;
        if(n==1) return 0;
        if(arr[0]>arr[1]) return 0;
        if(arr[n-1]>arr[n-2]) return n-1;

        for (int i=1;i<=n-2;i++){
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1]) return i;
        }
        return -1;
    }

    static int optimal(int[] arr){
        int n = arr.length;
        if(n==1) return 0;
        if(arr[0]>arr[1]) return 0;
        if(arr[n-1]>arr[n-2]) return n-1;

        int low=1 , high=n-2;
        while (low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return mid;
            else if(arr[mid]>arr[mid-1]) low = mid+1;
            else if(arr[mid]>arr[mid+1]) high = mid-1;
            else low = mid+1; //high = mid -1;
        }
        return -1;
    }
}
