/*
You have a row of flowers, where each flower blooms after a specific day. The array arr[] represents the blooming
schedule: arr[i] is the day the flower at position i will bloom. To create a bouquet, you need to collect k adjacent
bloomed flowers. Each flower can only be used in one bouquet.
Your goal is to find the minimum number of days required to make exactly m bouquets.
If it is not possible to make m bouquets with the given arrangement, return -1.

Constraints:
bloomDay.length == n
1 <= n <= 10^5
1 <= bloomDay[i] <= 10^9
1 <= m <= 10^6
1 <= k <= n
*/

package BinarySearch.OnAnswers;

public class MinimumNoofDaystoMakebouquets {
    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,13,11,12,7};
        int m = 2, k=3;
        System.out.println(bruteForce(bloomDay,m,k));
        System.out.println(optimal(bloomDay,m,k));
    }

    static boolean possible(int[] arr, int day, int m,int k){
        int count = 0;
        int noOfBouquets = 0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]<=day) count+=1;
            else {
                noOfBouquets += count/k;
                count=0;
            }
        }
        noOfBouquets += count/k;
        if(noOfBouquets>=m) return true;
        return false;
    }

    static int bruteForce(int[] bloomDay, int m, int k){
        if(m*k > bloomDay.length) return -1;

        int min = bloomDay[0];
        int max = bloomDay[0];
        for(int i=1;i<bloomDay.length;i++){
            min = Math.min(min,bloomDay[i]);
            max = Math.max(max,bloomDay[i]);
        }

        for (int day=min;day<=max;day++){
            if(possible(bloomDay,day,m,k))
                return day;
        }
        return -1;
    }




    static int optimal(int[] bloomDay,int m,int k){
        int min = bloomDay[0];
        int max = bloomDay[0];
        for(int i=1;i<bloomDay.length;i++){
            min = Math.min(min,bloomDay[i]);
            max = Math.max(max,bloomDay[i]);
        }

        if((long)m*(long)k > bloomDay.length) return -1;

        int low = min, high=max;
        int ans = high;
        while (low<=high){
            int mid = low+(high-low)/2;
            if(possible(bloomDay,mid,m,k)){
                ans = mid;
                high = mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}
