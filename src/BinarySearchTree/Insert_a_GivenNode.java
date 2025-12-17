/*
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST
after the insertion. It is guaranteed that the new value does not exist in the original BST.
Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can
return any of them.
*/
package BinarySearchTree;
import static BinarySearchTree.Node.*;

public class Insert_a_GivenNode {

    static Node optimal(Node root, int val){
        if(root == null){
            return new Node(val);
        }

        Node curr = root;
        while(curr != null){
            if(val > root.data){
                if(curr.right == null){
                    curr.right = new Node(val);
                    break;
                }
                else curr= curr.right;
            }
            else{
                if(curr.left==null){
                    curr.left = new Node(val);
                    break;
                }
                else curr = curr.left;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);


        root = optimal(root,4);
        System.out.println(levelOrder(root));
    }
}
