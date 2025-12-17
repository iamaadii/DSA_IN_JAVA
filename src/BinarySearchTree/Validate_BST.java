/*
Given the root of a binary tree. Check whether it is a BST or not.
A BST is defined as follows:
    The left subtree of a node contains only nodes with data less than the node's data.
    The right subtree of a node contains only nodes with data greater than the node's data.
    Both the left and right subtrees must also be binary search trees.
*/
package BinarySearchTree;

public class Validate_BST {

    static boolean helper(Node root,int minVal, int maxVal){
        if (root == null) return true;
        if (root.data<=minVal || root.data>=maxVal) return false;

        boolean l = helper(root.left,minVal,root.data);
        boolean r = helper(root.right,root.data,maxVal);

        return l && r;
    }
    static boolean optimal(Node root){
        return helper(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(6);
        root.right.right = new Node(7);

        System.out.println(optimal(root));
    }
}
