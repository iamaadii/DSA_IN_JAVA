package BinaryTree.Medium;

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

    static void inOrderTraversal(Node root){
        if (root == null) return;

        inOrderTraversal(root.left);
        System.out.print(root.data + ",");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        Node root = createTree(arr,0);

        inOrderTraversal(root);
    }
}

