/*
Given a binary tree with n nodes. You have to find the zig-zag level order traversal of the binary tree. In zigzag traversal starting
from the first level go from left to right for odd-numbered levels and right to left for even-numbered levels.

Constraints:
    The number of nodes in the tree is in the range [0, 2000].
    -100 <= Node.val <= 100
*/
package BinaryTree.Traversals;
import java.util.*;

public class ZigZag_Or_SpiralTraversal {

    static List<List<Integer>> optimal(Node root){
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;

        boolean leftToRight = true;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int s = q.size();
            Integer[] row = new Integer[s];
            for (int i = 0; i < s; i++) {
                Node temp = q.remove();

                int index = (leftToRight) ? i : s-1-i;
                row[index] = temp.data;

                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
            leftToRight = !leftToRight;
            res.add(Arrays.asList(row));
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(optimal(root));
    }
}
