package Array.Medium;

public class MaximumSubarraySum {

//    public static void main(String[] args) {
//        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
//
//        int maxSum = Integer.MIN_VALUE;
//        for(int i=0;i<arr.length;i++){
//            for(int j=i;j<arr.length;j++){
//                int sum = 0;
//                for(int k=i;k<=j;k++){
//                    sum+=arr[k];
//                    maxSum=Math.max(maxSum,sum);
//                }
//            }
//        }
//        System.out.println(maxSum);
//    }




//    public static void main(String[] args) {
//        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
//
//        int maxSum = Integer.MIN_VALUE;
//        for(int i=0;i<arr.length;i++){
//            int sum = 0;
//            for(int j=i;j<arr.length;j++){
//                sum+=arr[j];
//                maxSum=Math.max(maxSum,sum);
//            }
//        }
//        System.out.println(maxSum);
//    }


    public static void main(String[] args) {
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        int i=0;
        while(i<arr.length){
            sum += arr[i];
            if(sum>maxSum){
                maxSum=sum;
            }
            if(sum<0){
                sum=0;
            }
            i++;
        }
        System.out.println(maxSum);
    }

}
