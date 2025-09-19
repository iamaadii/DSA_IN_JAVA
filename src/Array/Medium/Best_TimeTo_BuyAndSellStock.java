package Array.Medium;

public class Best_TimeTo_BuyAndSellStock {
//    public static void main(String[] args) {
//        int[] arr ={7,1,5,3,6,4};
//
//        int maxProfit = 0;
//        for(int i=1;i<arr.length;i++){
//            int sell = arr[i];
//            int buy = min(arr,0,i-1);
//
//            int profit = sell-buy;
//            maxProfit=Math.max(maxProfit,profit);
//        }
//        System.out.println(maxProfit);
//    }
//
//    static int min(int[] arr,int start,int end){
//        int min = arr[start];
//        for(int i=start+1;i<=end;i++){
//            min=Math.min(min,arr[i]);
//        }
//        return min;
//    }


    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int maxProfit=0;
        int min = arr[0];
        for(int i=1;i<arr.length;i++){
            int sell = arr[i];
            int buy = min;

            int profit = sell - buy;
            maxProfit=Math.max(maxProfit,profit);

            min = Math.min(min,arr[i]);
        }
        System.out.println(maxProfit);
    }
}
