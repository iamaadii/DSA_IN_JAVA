package BinaryTree.Traversals;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int data;
    Node left,right;

    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }

    static Node createTree(int[] arr,int i){
        if (arr.length == 0 || i >= arr.length) return null;

        Node root = new Node(arr[i]);
        root.left = createTree(arr,2*i+1);
        root.right = createTree(arr,2*i+2);
        return root;
    }

    static void inOrderTraversal(Node root, List<Integer> res){
        if (root == null) return;

        inOrderTraversal(root.left,res);
        res.add(root.data);
        inOrderTraversal(root.right,res);
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        Node root = createTree(arr,0);

        List<Integer> res = new ArrayList<>();
        inOrderTraversal(root,res);
        System.out.println(res);
    }
}

