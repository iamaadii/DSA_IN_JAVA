/*
Given the root of the Binary Tree, return the length of its diameter. The Diameter of a Binary Tree is the longest distance
between any two nodes of that tree. This path may or may not pass through the root.The length of a path between two nodes is
represented by the number of edges between them.

Constraints:
    The number of nodes in the tree is in the range [1, 10^4].
    -100 <= Node.val <= 100
*/
package BinaryTree.Medium;

public class Diameter {

    static int diameter1 = 0;
    static int findHeight(Node root){
        if (root == null) return 0;
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        return 1+Math.max(lh,rh);
    }
    static int bruteForce(Node root){
        if (root == null) return 0;
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        diameter1 = Math.max(diameter1,lh+rh);

        bruteForce(root.left);
        bruteForce(root.right);

        return diameter1;
    }

    static int diameter2 = 0;
    static int optimal(Node root){
        if (root == null) return 0;
        int lh = optimal(root.left);
        int rh = optimal(root.right);
        diameter2 = Math.max(diameter2,lh+rh);
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

        diameter1 = 0;
        System.out.println(bruteForce(root));

        diameter2 = 0;
        optimal(root);
        System.out.println(diameter2);
    }
}
