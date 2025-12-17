/*
Given a BST and an integer. Find the least absolute difference between any node value of the BST and the given integer.
*/
package BinarySearchTree;

public class Closest_In_BST {
    static int optimal(Node root,int k){
        int minDiff = Integer.MAX_VALUE;
        while(root != null){
            minDiff = Math.min(minDiff, Math.abs(root.data - k));
            if(k == root.data)
                break;
            else if(k < root.data)
                root = root.left;
            else
                root = root.right;
        }
        return minDiff;
    }
    public static void main(String[] args) {
        Node root = new Node(6);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        System.out.println(optimal(root,7));
    }
}
