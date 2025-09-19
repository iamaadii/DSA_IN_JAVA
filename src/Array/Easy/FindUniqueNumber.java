package Array.Easy;

public class FindUniqueNumber {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,2,4,4};

        int res=0;
        for(int e:arr)
            res=res^e;

        System.out.println(res);
    }
}
