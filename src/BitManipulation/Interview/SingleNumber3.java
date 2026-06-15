package BitManipulation.Interview;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SingleNumber3 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,4,1};
        System.out.println(Arrays.toString(optimal(arr)));
    }


    static int[] optimal(int[] arr){
        int temp = 0;
        for (int e: arr) temp = temp^e;

        int rightMost = (temp & (temp-1)) ^ temp;
        int firstBucket = 0, secondBucket=0;
        for (int e: arr){
            if ((e&rightMost)==0) firstBucket=firstBucket^e;
            else secondBucket=secondBucket^e;
        }
        return new int[]{firstBucket,secondBucket};
    }
}
