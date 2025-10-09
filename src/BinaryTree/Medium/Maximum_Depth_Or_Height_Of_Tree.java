/*
Given the root of a binary tree, return its maximum depth (Height of tree).
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Constraints:
    The number of nodes in the tree is in the range [0, 104].
    -100 <= Node.val <= 100
*/
package BinaryTree.Medium;
import java.util.LinkedList;
import java.util.Queue;
import static BinaryTree.Medium.Node.*;

public class Maximum_Depth_Or_Height_Of_Tree {

    static int recursively(Node root){
        if (root == null) return 0;

        int lh = recursively(root.left);
        int rh = recursively(root.right);
        return 1 + Math.max(lh,rh);
    }

    static int iteratively(Node root){
        if (root == null) return 0;

        int level = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            level += 1;
            for (int i=0;i<size;i++) {
                Node temp = q.remove();
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }
        return level;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
        root.right.left.left = new Node(5);

        inOrderTraversal(root);

        System.out.println("\n"+recursively(root));
        System.out.println("\n"+iteratively(root));
    }
}
