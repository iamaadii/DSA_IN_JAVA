/*
Koko is given an array arr[], where each element represents a pile of bananas. She has exactly k hours to eat
all the bananas.
Each hour, Koko can choose one pile and eat up to s bananas from it.
If the pile has atleast s bananas, she eats exactly s bananas.
If the pile has fewer than s bananas, she eats the entire pile in that hour.
Koko can only eat from one pile per hour.
Your task is to find the minimum value of s (bananas per hour) such that Koko can finish all the piles within k hours.

Constraints:
1 <= piles.length <= 10^4
piles.length <= h <= 10^9
1 <= piles[i] <= 10^9
*/

package BinarySearch.OnAnswers;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int hours = 9;
        System.out.println(bruteForce(piles,hours));
        System.out.println(optimal(piles,hours));
    }
    static int max(int[] piles){
        int res = piles[0];
        for(int e:piles) res = Math.max(e,res);
        return res;
    }
    static int bruteForce(int[] piles,int hours){
        for (int i=1;i<=max(piles);i++){
            double total_hours = 0;
            for (int j=0;j<piles.length;j++){
                total_hours += Math.ceil((double) piles[j]/(double)i);
            }
            if(total_hours<=hours) return i;
        }
        return -1;
    }

    static int optimal(int[] piles, int hours){
        int low = 1;
        int high = max(piles);
        int ans = high;

        while (low<=high){
            int mid = low+(high-low)/2;
            double total_hours = 0;
            for (int j=0;j<piles.length;j++)
                total_hours +=  Math.ceil((double) piles[j]/(double)mid);

            if (total_hours <= hours) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid+1;
        }
        return ans;
    }
}
