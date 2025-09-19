package Array.Easy;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr={1,2,4,5};
        int n=5;

        int sum1 = n*(n+1)/2;
        int sum2 = 0;
        for(int e : arr)
            sum2+=e;

        System.out.println(sum1-sum2);
    }
}
