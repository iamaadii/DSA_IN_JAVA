package BinaryTree.Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import static BinaryTree.Traversals.Node.*;

public class LevelOrder_Traversal {

    static ArrayList<ArrayList<Integer>> optimal(Node root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i=0;i<size;i++){
                Node temp = q.remove();
                if(temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
                level.add(temp.data);
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Node root = createTree(arr,0);

        System.out.println(optimal(root));
    }
}
