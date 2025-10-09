/*
Given a Binary Tree, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.
Note: The paths should be returned such that paths from the left subtree of any node are listed first, followed by paths from the
      right subtree.

Constraints:
    1 <= number of nodes <= 10^4
    1 <= node->data <= 10^4
*/
package BinaryTree.Hard;
import java.util.ArrayList;

public class Root_To_Leaf_All_Paths {
    static void optimal(Node root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res){
        if (root == null) return;

        path.add(root.data);
        if(root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        optimal(root.left,path,res);
        optimal(root.right,path,res);
        path.removeLast();
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        optimal(root,path,res);
        System.out.println(res);;
    }
}
