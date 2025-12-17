package BinarySearchTree;

import java.util.ArrayList;

public class MergeTwoBST {
    static void helper(Node root,ArrayList<Integer> res){
        if(root==null) return;
        helper(root.left,res);
        res.add(root.data);
        helper(root.right,res);
    }
    public static ArrayList<Integer> optimal(Node root1, Node root2) {
        // code here
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        helper(root1,l1);
        helper(root2,l2);

        int i=0, j=0;
        ArrayList<Integer> res = new ArrayList<>(l1.size() + l2.size());
        while(i<l1.size() && j<l2.size()){
            if(l1.get(i)<l2.get(j)) res.add(l1.get(i++));
            else res.add(l2.get(j++));
        }
        while(i<l1.size()) res.add(l1.get(i++));
        while(j<l2.size()) res.add(l2.get(j++));

        return res;
    }
    public static void main(String[] args) {
        Node root1 = new Node(3);
        root1.left = new Node(1);
        root1.right = new Node(5);

        Node root2 = new Node(4);
        root2.left = new Node(2);
        root2.right = new Node(6);

        System.out.println(optimal(root1,root2));
    }
}
