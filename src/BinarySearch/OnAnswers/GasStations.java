/*
We have a horizontal number line. On that number line, we have gas stations at positions stations[0], stations[1], ..., stations[n-1]. Now, we add k more gas stations so that d, the maximum distance between adjacent gas stations, is minimized. We have to find the smallest possible value of d. Find the answer exactly to 2 decimal places.
Note: stations is in a strictly increasing order.
*/

package BinarySearch.OnAnswers;

import java.util.PriorityQueue;

class Pair {
    double value;
    int index;

    Pair(double value, int index) {
        this.value = value;
        this.index = index;
    }
}
public class GasStations {
    public static void main(String[] args) {
        int[] arr = {3, 6, 12, 19, 33};
        int k = 3;
        System.out.println(bruteForce(arr,k));
        System.out.println(betterSolution(arr,k));
        System.out.println(optimal(arr,k));
    }
    static double bruteForce(int[] arr, int k){
        int[] track = new int[arr.length-1];
        for (int gasStation=1;gasStation<=k;gasStation++){
            double maxSection = -1;
            int maxIndex = -1;
            for (int i = 0 ; i < arr.length-1 ; i++){
                double difference = arr[i+1]-arr[i];
                double sectionLength = difference/(double) (track[i]+1);
                if(sectionLength > maxSection){
                    maxSection = sectionLength;
                    maxIndex = i;
                }
            }
            track[maxIndex]++;
        }
        double ans = -1;
        for (int i=0;i< arr.length-1;i++){
            double difference = arr[i+1]-arr[i];
            double sectionLength = difference/(double) (track[i]+1);
            ans = Math.max(ans,sectionLength);
        }
        return ans;
    }




    static double betterSolution(int[] arr, int k){
        int[] howMany = new int[arr.length-1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.value, a.value));

        for (int i = 0; i < arr.length - 1; i++)
            pq.add(new Pair(arr[i + 1] - arr[i], i));

        for (int gasStations = 1; gasStations <= k; gasStations++){
            Pair top = pq.poll();
            int secInd = top.index;
            howMany[secInd]++;
            double inidiff = arr[secInd + 1] - arr[secInd];
            double newSecLen = inidiff / (double) (howMany[secInd] + 1);
            pq.add(new Pair(newSecLen, secInd));
        }
        return pq.peek().value;
    }




    static double optimal(int[] arr, int k){
        double low = 0.0,high =0.0;
        for (int i=0;i<arr.length-1;i++)
            high = Math.max(high, arr[i+1]-arr[i]);

        while (high-low > 1e-6){
            double mid = low+(high-low)/2.0;
            int cnt = 0;
            for (int i = 1; i < arr.length; i++) {
                int numberInBetween = (int)Math.ceil((arr[i] - arr[i - 1]) / mid) - 1 ;
                cnt += numberInBetween;
            }
            if (cnt > k)
                low = mid;
            else
                high = mid;
        }
        return Math.round(high * 100.0) / 100.0;
    }
}