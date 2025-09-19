/*
You are given 2 numbers n and m, the task is to find n√m (nth root of m). If the root is not integer then returns -1.
Constraints:
1 ≤ n ≤ 30
0 ≤ m ≤ 10^9
*/
package BinarySearch.OnAnswers;

public class FindNthRootOfm {
    public static void main(String[] args) {
        int n=3, m=64;
        System.out.println(bruteForce(n,m));
        System.out.println(optimal(n,m));
    }

    static int bruteForce(int n,int m){
        for (int i=0;i<=m;i++){
            int res = (int) Math.pow(i,n);
            if(res==m) return i;
            else if(res>m) break;
        }
        return -1;
    }


    static int fun(int mid,int n,int limit){
        long res = 1;
        for(int i=1;i<=n;i++){
            res = res * mid;
            if(res>limit) return 2;
        }
        if(res == limit) return 1;
        return 0;
    }
    static int optimal(int n,int m){
        int low = 0, high = m;
        while (low<=high){
            int mid = low+(high-low)/2;
            int res = fun(mid,n,m);
            if(res==1) return mid;
            else if(res==0) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}
