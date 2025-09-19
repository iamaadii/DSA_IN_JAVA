/*
Given an array arr[] of n weights. Find the least weight capacity of a boat to ship all weights within d days.
The ith weight has a weight of arr[i]. Each day, we load the boat with weights given by arr[i].
We may not load more weight than the maximum weight capacity of the ship.

Note: You have to load weights on the boat in the given order.

Constraints:
1 <= days <= weights.length <= 5 * 10^4
1 <= weights[i] <= 500
*/

package BinarySearch.OnAnswers;

public class CapacityToShipWithinNDays {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(bruteforce(weights,days));
        System.out.println(optimal(weights,days));
    }

    static int bruteforce(int[] arr, int days){
        int max = arr[0];
        int sum = 0;
        for (int e:arr){
            max = Math.max(max,e);
            sum+=e;
        }

        for (int capacity=max; capacity<=sum; capacity++){
            int reqday = 1;
            int load = 0;
            for (int j=0;j< arr.length;j++){
                load += arr[j];
                if(load>capacity){
                    reqday += 1;
                    load = arr[j];
                }
            }
            if(reqday<=days) return capacity;
        }
        return -1;
    }




    static int optimal(int[] arr, int days){
        int low = arr[0];
        int high = 0;
        for (int e:arr){
            low = Math.max(low,e);
            high+=e;
        }

        int res = low;

        while (low<=high){
            int mid = low+(high-low)/2;
            int reqday = 1;
            int load = 0;
            for (int j=0;j< arr.length;j++){
                load += arr[j];
                if(load>mid){
                    reqday += 1;
                    load = arr[j];
                }
            }
            if(reqday<=days){
                res = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return res;
    }
}