/*
Given a binary tree, determine if it is height-balanced. A binary tree is considered height-balanced if the absolute difference
in heights of the left and right subtrees is at most 1 for every node in the tree.

Constraints:
    0 ≤ number of nodes ≤ 5000
    - 10^4 ≤ node->data ≤ 10^4
*/
package BinaryTree.Medium;
public class Check_Tree_Is_Balanced_Or_Not {

    static int getHeight(Node root){
        if (root == null) return 0;

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        return 1 + Math.max(lh,rh);
    }
    static boolean bruteForce(Node root){
        if (root == null) return true;

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        if (Math.abs(lh-rh) > 1) return false;

        boolean left = bruteForce(root.left);
        boolean right = bruteForce(root.right);

        if (!left || !right) return false;
        return true;
    }

    static int optimal(Node root){
        if (root==null) return 0;

        int lh = optimal(root.left);
        if(lh == -1) return -1;

        int rh = optimal(root.right);
        if(rh == -1) return -1;

        if (Math.abs(lh-rh) > 1) return -1;
        return 1+Math.max(lh,rh);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(4);
        root.left.left.left= new Node(7);
        root.left.left.right = new Node(6);

        System.out.println(bruteForce(root));
        System.out.println(optimal(root));
    }
}
