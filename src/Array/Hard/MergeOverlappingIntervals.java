/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of
the non-overlapping intervals that cover all the intervals in the input.
*/

package Array.Hard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] arr = { {1,3}, {2,6},  {8,9}, {9,11}, {8,10}, {2,4}, {15,18}, {16,17}};
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        List<int[]> list = new ArrayList<>();
        for (int i = 0;i< arr.length;i++){
            int start = arr[i][0];
            int end = arr[i][1];
            if(!list.isEmpty() && end<=list.getLast()[1])
                continue;

            for (int j=i+1;j< arr.length;j++) {
                if (arr[j][0] <= end)
                    end = Math.max(end, arr[j][1]);
                else
                    break;
            }
            list.add(new int[]{start,end});
        }
        for (int[] interval : list)
            System.out.println(Arrays.toString(interval));
    }


//    public static void main(String[] args) {
//        int[][] arr = { {1,3}, {2,6},  {8,9}, {9,11}, {8,10}, {2,4}, {15,18}, {16,17}};
//        Arrays.sort(arr, (a, b) -> {
//            if (a[0] != b[0]) {
//                return Integer.compare(a[0], b[0]);
//            } else {
//                return Integer.compare(a[1], b[1]);
//            }
//        });
//
//        List<int[]> merged = new ArrayList<>();
//        int start = arr[0][0];
//        int end = arr[0][1];
//        for (int i = 1;i< arr.length;i++){
//            if(arr[i][0]<=end){
//                end = Math.max(end,arr[i][1]);
//            }
//            else{
//                merged.add(new int[]{start, end});
//                start = arr[i][0];
//                end = arr[i][1];
//            }
//        }
//        merged.add(new int[]{start, end});
//        for (int[] interval : merged)
//            System.out.println(Arrays.toString(interval));
//    }



//    public static void main(String[] args) {
//        int[][] arr = {
//                {1, 3}, {2, 6}, {8, 9}, {9, 11},
//                {8, 10}, {2, 4}, {15, 18}, {16, 17}
//        };
//        Arrays.sort(arr, (a, b) ->
//                (a[0] != b[0]) ? Integer.compare(a[0], b[0])
//                        : Integer.compare(a[1], b[1])
//        );
//
//        int index = 0; // index of the last merged interval
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i][0] <= arr[index][1]) {
//                arr[index][1] = Math.max(arr[index][1], arr[i][1]);
//            }
//            else {
//                index++;
//                arr[index] = arr[i];
//            }
//        }
//        for (int i = 0; i <= index; i++)
//            System.out.println(Arrays.toString(arr[i]));
//    }
}
