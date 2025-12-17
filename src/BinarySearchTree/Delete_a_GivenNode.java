/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference
(possibly updated) of the BST.
Basically, the deletion can be divided into two stages:
    Search for a node to remove.
    If the node is found, delete the node.
*/
package BinarySearchTree;
import static BinarySearchTree.Node.*;

public class Delete_a_GivenNode {
    static Node helper(Node root){
        if (root.left == null) return root.right;
        else if (root.right == null) return root.left;

        Node rightChild = root.right;
        Node leftRight = findLeftRight(root.left);
        leftRight.right = rightChild;
        return root.left;
    }
    static Node findLeftRight(Node root){
        while (root.right != null) root = root.right;
        return root;
    }
    static Node optimal(Node root, int target){
        if (root == null) return null;
        if (root.data == target)
            return helper(root);

        Node temp = root;
        while (root != null){
            if (root.data > target){
                if (root.left != null && root.left.data == target){
                    root.left = helper(root.left);
                    break;
                }
                else root = root.left;
            }
            else{
                if (root.right != null && root.right.data == target){
                    root.right = helper(root.right);
                    break;
                }
                else root = root.right;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(6);
        root.right.right = new Node(7);

        Node res = optimal(root,3);
        System.out.println(levelOrder(res));
    }
}