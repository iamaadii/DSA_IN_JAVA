/*
Given a root binary tree with all unique values and two nodes value, n1 and n2. The task is to find the lowest common ancestor
of the given two nodes. We may assume that either both n1 and n2 are present in the tree or none of them are present.

Note: LCA is the first common ancestor of both the nodes n1 and n2 from bottom of tree.
*/
package BinaryTree.Hard;
import java.util.ArrayList;

public class LowestCommonAncestor {

    static void bruteForce(Node root, Node target1, Node target2, ArrayList<Node> temp, ArrayList<ArrayList<Node>> res){
        if (root==null) return;
        temp.add(root);
        if (root == target1 || root == target2){
            res.add(new ArrayList<>(temp));
        }
        bruteForce(root.left,target1,target2,temp,res);
        bruteForce(root.right,target1,target2,temp,res);
        temp.removeLast();
    }

    static Node optimal(Node root,Node target1,Node target2){
        if (root==null) return null;
        if (root == target1 || root==target2)
            return root;

        Node l = optimal(root.left,target1,target2);
        Node r = optimal(root.right,target1,target2);

        if (l!=null && r!=null) return root;
        else if (l==null && r==null) return null;
        else if (l == null) return r;
        return l;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);

        ArrayList<ArrayList<Node>> res = new ArrayList<>();
        bruteForce(root,root.left.left,root.left.right.right,new ArrayList<>(),res);

        Node common = res.get(0).get(0);
        if (res.get(0).size()<res.get(1).size()){
            for (int i=0;i<res.get(0).size();i++){
               if (res.get(0).get(i) == res.get(1).get(i))
                   common = res.get(0).get(i);
            }
        }
        else {
            for (int i=0;i<res.get(1).size();i++){
                if (res.get(1).get(i) == res.get(0).get(i))
                    common = res.get(1).get(i);
            }
        }
//        System.out.println(common.data);

        System.out.println(optimal(root,root,root.left.right).data);
    }
}
