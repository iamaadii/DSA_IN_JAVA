package Array.Hard.Pascal;

import java.util.ArrayList;
import java.util.List;

public class PrintPascalTriangleinList {
    public static void main(String[] args) {
        int row = 6;
        List<List<Integer>> res = new ArrayList<>();

        for(int i=1;i<=row;i++) {
           res.add(generatingRow(i));
        }
        System.out.println(res);
    }

    static List<Integer> generatingRow(int row){
        List<Integer> t = new ArrayList<>();
        t.add(1);
        int temp = 1;
        for (int col = 1; col < row; col++) {
            temp = (temp) * (row - col) / col;
            t.add(temp);
        }
        return t;
    }
}
