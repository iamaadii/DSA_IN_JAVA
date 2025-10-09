/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Constraints:
    The number of nodes in both trees is in the range [0, 100].
    -104 <= Node.val <= 104
*/
package BinaryTree.Medium;
public class Check_Trees_Are_Identical_Or_Not {

    static boolean optimal(Node root1,Node root2){
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        boolean value = (root1.data == root2.data);
        boolean left = optimal(root1.left,root2.left);
        boolean right = optimal(root1.right,root2.right);
        return value && left && right;
    }

    public static void main(String[] args) {
        Node root1 = new Node(-10);
        root1.left = new Node(9);
        root1.right = new Node(20);
        root1.right.left = new Node(15);
        root1.right.right = new Node(7);

        Node root2 = new Node(-10);
        root2.left = new Node(9);
        root2.right = new Node(20);
        root2.right.left = new Node(15);
        root2.right.right = new Node(7);

        System.out.println(optimal(root1,root2));
    }
}
