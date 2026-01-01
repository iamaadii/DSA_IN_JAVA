package Graphs.Learning;

import java.util.ArrayList;

public class UsingAdjacencyList {
    public static void main(String[] args) {
        int nodes = 5, edges=6;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i=0;i<=nodes;i++){
            list.add(new ArrayList<>());
        }

        //edge 1---2
        list.get(1).add(2);
        list.get(2).add(1);

        //edge 1---3
        list.get(1).add(3);
        list.get(3).add(1);

        //edge 2---4
        list.get(2).add(4);
        list.get(4).add(2);

        //edge 3---4
        list.get(3).add(4);
        list.get(4).add(3);

        //edge 2---5
        list.get(2).add(5);
        list.get(5).add(2);

        //edge 4---5
        list.get(4).add(5);
        list.get(5).add(4);

        int i=0;
        for (ArrayList<Integer> a: list){
            System.out.println(i++ + "->" + a);
        }
    }
}
