package Array.Hard.Pascal;

import java.util.ArrayList;
import java.util.List;

public class NthRowElements {
    public static void main(String[] args) {
        int row = 6;
        List<Long> res = new ArrayList<>();
        int new_row = row-1;
        for(int col=1;col<=row;col++){
            int new_col = col-1;
            long temp = 1;
            for(int i=0;i<new_col;i++){
                temp = temp*(new_row-i);
                temp=temp/(i+1);
            }
            res.add(temp);
        }
        System.out.println(res);
    }


//    public static void main(String[] args) {
//        int row = 6;
//        List<Integer> res = new ArrayList<>();
//        res.add(1);
//        int temp=1;
//        for(int col=1;col<row;col++){
//            temp = (temp)*(row-col)/col;
//            res.add(temp);
//        }
//        System.out.println(res);
//    }
}
