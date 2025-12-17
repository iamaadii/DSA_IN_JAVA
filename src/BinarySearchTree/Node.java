package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Node {
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    static ArrayList<ArrayList<Integer>> levelOrder(Node root){
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

}
