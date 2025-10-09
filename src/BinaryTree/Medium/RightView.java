/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you
can see ordered from top to bottom.

Constraints:
    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100
*/
package BinaryTree.Medium;
import java.util.*;

public class RightView {

    static List<Integer> bruteForce(Node root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> levelOrder = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()){
            int s = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i=0;i<s;i++){
                Node temp = q.remove();
                level.add(temp.data);
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
            levelOrder.add(level);
        }
        for (List<Integer> l : levelOrder){
            res.add(l.getLast());
        }
        return res;
    }

    static void optimal(Node root, int level, List<Integer> res){
        if (root == null) return ;
        if (level == res.size()) res.add(root.data);
        optimal(root.right,level+1,res);
        optimal(root.left,level+1,res);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(bruteForce(root));

        List<Integer> res = new ArrayList<>();
        optimal(root,0,res);
        System.out.println(res);
    }
}
