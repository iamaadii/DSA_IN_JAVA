/*
Problem Statement: Given a Binary Tree, determine the maximum sum achievable along any path within the tree. A path in a binary
tree is defined as a sequence of nodes where each pair of adjacent nodes is connected by an edge. Nodes can only appear once in
the sequence, and the path is not required to start from the root. Identify and compute the maximum sum possible along any path
within the given binary tree.

Constraints:
    The number of nodes in the tree is in the range [1, 3 * 104].
    -1000 <= Node.val <= 1000
*/
package BinaryTree.Medium;

public class Max_Path_Sum {

    static int maxSum = 0;
    static int optimal(Node root){
        if (root == null) return 0;

        int leftSum = optimal(root.left);
        if (leftSum < 0) return 0;

        int rightSum = optimal(root.right);
        if (rightSum < 0) return 0;

        maxSum = Math.max(maxSum,leftSum+rightSum+root.data);
        return root.data + Math.max(leftSum,rightSum);
    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        maxSum = 0;
        optimal(root);
        System.out.println(maxSum);
    }
}
