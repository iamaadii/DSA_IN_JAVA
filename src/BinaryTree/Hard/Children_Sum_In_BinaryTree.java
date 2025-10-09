/*
Given the root of a binary tree, determine whether the tree satisfies the Children Sum Property. In this property, each non-leaf
node must have a value equal to the sum of its left and right children's values. A NULL child is considered to have a value of 0,
and all leaf nodes are considered valid by default.

Return true if every node in the tree satisfies this condition, otherwise return false.
*/
package BinaryTree.Hard;
public class Children_Sum_In_BinaryTree {

    static Boolean optimal(Node root){
        if (root==null) return true;
        if (root.left == null && root.right==null) return true;

        boolean l = optimal(root.left);
        boolean r = optimal(root.right);

        int sum = 0;
        if (root.right != null) sum += root.right.data;
        if (root.left != null) sum += root.left.data;
        if (sum != root.data) return false;

        return l && r;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(3);
        root.left.left = new Node(5);

        System.out.println(optimal(root));
    }
}
