/*
You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake.
Recover the tree without changing its structure.
*/
package BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;

import static BinarySearchTree.Node.levelOrder;

public class RecoverBST {
    static void traversal(Node root,ArrayList<Integer> list){
        if (root==null) return;
        traversal(root.left,list);
        list.add(root.data);
        traversal(root.right,list);
    }
    static void helper(Node root,ArrayList<Integer> list,int[] index){
        if (root==null) return;
        helper(root.left,list,index);
        if (root.data != list.get(index[0])){
            root.data = list.get(index[0]);
        }
        index[0] = index[0]+1;
        helper(root.right,list,index);
    }
    static void bruteForce(Node root){
        ArrayList<Integer> inOrder = new ArrayList<>();
        traversal(root,inOrder);
        Collections.sort(inOrder);

        int[] index = new int[] {0};
        helper(root,inOrder,index);
        System.out.println(levelOrder(root));
    }






    static Node prev = null, first = null, middle=null, last=null;
    static void helper(Node root){
        if (root==null) return;
        helper(root.left);
        if (prev != null && prev.data>root.data){
            if (first == null) {
                first = prev;
                middle = root;
            }
            else{
                last = root;
            }
        }
        prev = root;
        helper(root.right);
    }
    static void optimal(Node root){
        helper(root);
        if (last==null){
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
        else{
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        System.out.println(levelOrder(root));
    }


    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        root.right.left = new Node(2);

//        bruteForce(root);
        optimal(root);
    }
}
