package Array.Easy;

public class LongestSubarrayWithSumk {
    //for 0,positive & negative values
//    public static void main(String[] args) {
//        int[] arr = {1,2,1,2,1,4};
//        int sum = 5;
//
//        int len = 0;
//
//        for(int i=0;i<arr.length;i++){
//            int temp = 0;
//            for(int j=i;j<arr.length;j++){
//                temp+=arr[j];
//                if(temp==sum){
//                    len=Math.max(len,j-i+1);
//                    break;
//                }
//            }
//        }
//        System.out.println(len);
//    }


     //for 0,positive & negative values
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,1,1,1,1,4,2,3};
//        int k = 3;
//        Map<Integer,Integer> m = new HashMap<>();
//
//        int maxLen = 0;
//        int sum=0;
//        for(int i=0;i<arr.length;i++){
//            sum+=arr[i];
//            if(sum==k){
//                maxLen=i+1;
//            }
//            int req = sum-k;
//            if(m.containsKey(req)){
//                int index = m.get(req);
//                maxLen = Math.max(maxLen,i-index);
//            }
//            if(!m.containsKey(sum)) {
//                m.put(sum, i);
//            }
//        }
//
//        System.out.println(maxLen);
//    }

    //for 0,positive values only.
    public static void main(String[] args) {
        int[] arr ={1, 2, 3, 1, 1, 1, 1};
        int k = 3;
        int right = 0;
        int left = 0;

        int maxLength = 0;
        int sum = 0;
        while(right<arr.length){
            sum+=arr[right];
            while (sum > k && left <= right) {
                sum -= arr[left];
                left++;
            }

            if (sum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }

            right++;
        }
        System.out.println(maxLength);
    }
}
