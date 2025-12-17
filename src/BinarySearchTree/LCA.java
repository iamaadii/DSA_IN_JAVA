/*
Given the root of a Binary Search Tree (with all values unique) and two nodes n1 and n2 (n1 != n2). You may assume that both
nodes exist in the tree. Find the Lowest Common Ancestor (LCA) of the given two nodes in the BST.
Note: LCA between two nodes n1 and n2 is defined as the deepest node that has both n1 and n2 as descendants
(where we allow a node to be a descendant of itself).
*/
package BinarySearchTree;
import java.util.ArrayList;
import java.util.List;

public class LCA {

    static void helper(Node root, int target, List<Integer> path){
        while (root!=null){
            path.add(root.data);
            if (root.data==target) break;
            else if(target < root.data) root=root.left;
            else root=root.right;
        }
    }
    static int bruteForce(Node root,int t1, int t2){
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();

        helper(root,t1,path1);
        helper(root,t2,path2);
        int res = root.data;
        for (int e1: path1){
            for (int e2: path2){
                if (e1==e2) res = e1;
            }
        }
        return res;
    }



    static int optimal(Node root, int t1, int t2){
        int ans = root.data;
        while (root != null){
            if (t1 > root.data && t2 > root.data) root = root.right;
            else if (t1<root.data && t2<root.data) root = root.left;
            else {
                ans = root.data;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(2);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        System.out.println(bruteForce(root,2,5));
        System.out.println(optimal(root,2,5));
    }
}
