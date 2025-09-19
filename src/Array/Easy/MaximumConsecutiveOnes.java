package Array.Easy;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int count = 0, temp = 0;
        for (int num : nums) {
            if (num == 1) {
                temp++;
            } else {
                count = Math.max(count, temp);
                temp = 0;
            }
        }

        System.out.println(Math.max(count,temp));
    }
}
