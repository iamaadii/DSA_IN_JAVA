package TwoPointer_And_SlidingWindow.Medium;

public class MaximumPoints {
    public static void main(String[] args) {
        int[] arr =  {1,2,3,4,5,6,1}; int k = 3;
        System.out.println(maxScore(arr,k));
    }

    static int maxScore(int[] arr, int k) {
        int leftSum = 0,rightSum=0;
        int i=0,j=arr.length-1;
        while(i<k){
            leftSum+=arr[i];
            i+=1;
        }
        int maxPoint = leftSum;
        int win = k;
        while(win>0){
            leftSum -= arr[--i];
            rightSum += arr[j--];
            maxPoint = Math.max(maxPoint,rightSum+leftSum);
            win-=1;
        }
        return maxPoint;
    }
}
