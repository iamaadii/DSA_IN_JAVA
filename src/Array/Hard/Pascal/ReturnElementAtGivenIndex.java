package Array.Hard.Pascal;

public class ReturnElementAtGivenIndex {
//    public static void main(String[] args) {
//        int row = 5; int column = 3;
//        int res = fact(row-1)/( fact(column-1) * fact((row-1)-(column-1)) );
//        System.out.println(res);
//    }
//
//    static int fact(int n){
//        if(n<0)
//            return 0;
//        else {
//            int res = 1;
//            for (int i = 2; i <= n; i++)
//                res = res * i;
//            return res;
//        }
//    }


    public static void main(String[] args) {
        int row = 5; int column = 3;
        int new_row = row-1;int new_column = column-1;

        long res = 1;
        for(int i=0;i<new_column;i++){
            res = res * (new_row-i);
            res = res/(i+1);
        }

        System.out.println(res);
    }

}
