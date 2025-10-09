/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Constraints:
    The number of nodes in the tree is in the range [0, 105].
    -1000 <= Node.val <= 1000
*/
package BinaryTree.Medium;
import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Depth_Of_Tree {

    static int recursively(Node root){
        if (root == null) return 0;
        if (root.left == null) return 1 + recursively(root.right);
        if (root.right == null) return 1 + recursively(root.left);
        return 1 + Math.min(recursively(root.left), recursively(root.right));
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

                if (temp.left == null && temp.right == null) return level;
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }
        return level;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        root.right.right.left = new Node(5);
        root.right.right.right = new Node(6);
        root.right.right.right.left = new Node(7);
        root.right.right.right.left.left = new Node(8);
        root.right.right.right.left.right= new Node(9);

        System.out.println(recursively(root));
        System.out.println(iteratively(root));
    }
}
