package BitManipulation.Interview;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(optimal(nums));
    }

    static List<List<Integer>> optimal(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<(1<<n);i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i & (1<<j)) > 0){
                    temp.add(nums[j]);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
