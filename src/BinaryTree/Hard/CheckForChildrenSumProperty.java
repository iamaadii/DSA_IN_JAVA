/*
Given a Binary Tree, convert the value of its nodes to follow the Children Sum Property. The Children Sum Property in a binary tree
states that for every node, the sum of its children's values (if they exist) should be equal to the node's value. If a child is missing,
it is considered as having a value of 0.
*/
package BinaryTree.Hard;
import static BinaryTree.Hard.Node.*;

public class CheckForChildrenSumProperty {

    static void optimal(Node root){
        if (root==null) return;
        if (root.left == null && root.right == null) return;

        int child = 0;
        if (root.left != null)  child += root.left.data;
        if (root.right != null)  child += root.right.data;

        if (child < root.data){
            if (root.left != null) root.left.data = root.data;
            if (root.right != null) root.right.data = root.data;
        }
        else root.data = child;

        optimal(root.left);
        optimal(root.right);

        int sum = 0;
        if (root.left != null) sum += root.left.data;
        if (root.right != null) sum += root.right.data;
        root.data = sum;
    }

    public static void main(String[] args) {
        Node root = new Node(40);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.right.left = new Node(30);
        root.right.right = new Node(40);

        optimal(root);
        System.out.println(levelOrder(root));
    }
}
