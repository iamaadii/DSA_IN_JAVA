/*
A special binary tree with random pointers along with the usual left and right pointers is given. Clone the given tree.
Note: The output is 1 if the tree is cloned successfully. Otherwise, the output is 0.
*/
package BinaryTree.Hard;
import java.util.*;

class Tree {
    int data;
    Tree left, right, random;

    Tree(int d) {
        data = d;
        left = null;
        right = null;
        random = null;
    }
}
public class Clone_A_BinaryTree {

    static Tree optimal(Tree root, Map<Tree,Tree> mp){
        if(root == null) return null;

        Tree copy = mp.get(root);
        copy.left = optimal(root.left, mp);
        copy.right = optimal(root.right, mp);
        copy.random = mp.get(root.random);

        return copy;
    }
    static void helper(Tree root, Map<Tree,Tree> mp){
        if(root == null) return;

        Tree temp = new Tree(root.data);
        mp.put(root,temp);

        helper(root.left,mp);
        helper(root.right,mp);
    }


    public static void main(String[] args) {
        Tree root = new Tree(6);
        root.left = new Tree(3);
        root.right = new Tree(8);
        root.left.left = new Tree(1);
        root.left.right = new Tree(5);

        Map<Tree,Tree> mp = new HashMap<>();
        helper(root,mp);

        Tree copy = optimal(root,mp);
    }
}
