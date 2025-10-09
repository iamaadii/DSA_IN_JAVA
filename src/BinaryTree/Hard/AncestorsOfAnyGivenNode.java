/*
Given a Binary Tree and an integer target. Find all the ancestors of the given target.
Note: The ancestor of node x is node y, which is at the upper level of node x, and x is directly connected with node y. Consider
      multiple levels of ancestors to solve this problem. In case there are no ancestors available, return an empty list.

Constraints:
    1 ≤ no. of nodes ≤ 10^3
    1 ≤ data of node ≤ 10^4
*/
package BinaryTree.Hard;
import java.util.ArrayList;

public class AncestorsOfAnyGivenNode {
    static boolean optimal(Node root, ArrayList<Integer> res , int target){
        if(root==null) return false;
        if(root.data == target) return true;

        boolean l = optimal(root.left,res,target);
        if(l) {
            res.add(root.data);
            return true;
        }
        boolean r = optimal(root.right,res,target);
        if(r) {
            res.add(root.data);
            return true;
        }

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

        ArrayList<Integer> res = new ArrayList<>();
        optimal(root,res,7);
        System.out.println(res);
    }
}
