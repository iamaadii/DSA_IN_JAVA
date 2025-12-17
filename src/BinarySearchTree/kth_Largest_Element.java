/*
Given the root of a binary search tree, and an integer k, return the kth largest value (1-indexed) of all the values of the
nodes in the tree.
*/
package BinarySearchTree;
import java.util.ArrayList;

public class kth_Largest_Element {

    static void inorder(Node root, ArrayList<Node> temp){
        if (root == null) return;
        inorder(root.left,temp);
        temp.add(root);
        inorder(root.right,temp);
    }
    static int bruteForce(Node root, int k){
        ArrayList<Node> temp = new ArrayList<>();
        inorder(root,temp);

        if (k > temp.size()) return -1;
        return temp.get(temp.size()-k).data;
    }




    static void helper(Node root, int k, int[] count, ArrayList<Node> ans){
        if (root == null || !ans.isEmpty()) return;
        helper(root.right,k,count,ans);
        if (!ans.isEmpty()) return;
        count[0] += 1;
        if (count[0] == k) {
            ans.add(root);
            return;
        }
        helper(root.left,k,count,ans);
    }
    static int optimal(Node root, int k){
        ArrayList<Node> res = new ArrayList<>();
        helper(root,k,new int[1],res);
        if (res.isEmpty()) return -1;
        return res.getFirst().data;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(6);
        root.right.right = new Node(7);

        System.out.println(bruteForce(root,3));
        System.out.println(optimal(root,3));
    }
}
