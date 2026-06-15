package BitManipulation.Interview;

public class MinimumBitFlipsToConvertNumber {
    public static void main(String[] args) {
        System.out.println(optimal(10,7));
    }

    static int optimal(int start,int goal){
        int temp = start ^ goal;

        int count=0;
        while(temp>0){
            count+=temp&1;
            temp>>=1;
        }
        return count;
    }
}
