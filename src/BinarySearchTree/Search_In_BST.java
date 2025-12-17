package BinarySearchTree;

public class Search_In_BST {

    static Node optimal(Node root, int target){
        while (root != null) {
            if (root.data == target) break;
            else if (target > root.data) root = root.right;
            else root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.left = new Node(6);
        root.right = new Node(12);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        System.out.println(optimal(root,9));
    }
}
