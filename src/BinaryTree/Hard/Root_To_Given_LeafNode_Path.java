/*
Given a Binary Tree and a target node. Return the path from the root node to the given leaf node.
    •	No two nodes in the tree have the same data value.
    •	It is assured that the given node is present and a path always exists.
*/
package BinaryTree.Hard;
import java.util.ArrayList;
import java.util.List;

public class Root_To_Given_LeafNode_Path {

    static boolean optimal(Node root,int target,List<Integer> res){
        if (root == null) return false;
        res.add(root.data);

        if (root.data == target) return true;

        if (optimal(root.left, target, res) || optimal(root.right, target, res))
            return true;

        res.removeLast();
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);

        List<Integer> res = new ArrayList<>();
        optimal(root,7,res);
        System.out.println(res);
    }
}
