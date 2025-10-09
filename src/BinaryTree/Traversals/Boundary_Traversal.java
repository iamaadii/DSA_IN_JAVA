/*
Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order:
Left Boundary: This includes all the nodes on the path from the root to the leftmost leaf node. You must prefer the left child over
               the right child when traversing. Do not include leaf nodes in this section.
Leaf Nodes: All leaf nodes, in left-to-right order, that are not part of the left or right boundary.
Reverse Right Boundary: This includes all the nodes on the path from the rightmost leaf node to the root, traversed in reverse order.
                        You must prefer the right child over the left child when traversing. Do not include the root in this section if
                        it was already included in the left boundary.

Constraints:
    1 ≤ number of nodes ≤ 105
    1 ≤ node->data ≤ 105
*/
package BinaryTree.Traversals;
import java.util.ArrayList;
import java.util.List;

public class Boundary_Traversal {

    static boolean isLeaf(Node curr){
        if (curr.left == null && curr.right == null) return true;
        return false;
    }
    static void addLeftBoundary(Node curr, ArrayList<Integer> res){
        while (curr != null){
            if (!isLeaf(curr)) res.add(curr.data);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    static void addLeafNodes(Node root, ArrayList<Integer> res){
        if (isLeaf(root)){
            res.add(root.data);
            return;
        }
        if (root.left != null) addLeafNodes(root.left,res);
        if (root.right != null) addLeafNodes(root.right,res);
    }
    static void addRightBoundary(Node curr, ArrayList<Integer> res){
        ArrayList<Integer> l = new ArrayList<>();
        while (curr != null){
            if (!isLeaf(curr)) l.add(curr.data);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        for (int i=l.size()-1;i>=0;i--) res.add(l.get(i));
    }
    static List<Integer> optimal(Node root){
        ArrayList<Integer> res = new ArrayList<>();
        if (!isLeaf(root)) res.add(root.data);

        addLeftBoundary(root.left,res);
        addLeafNodes(root,res);
        addRightBoundary(root.right,res);
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
