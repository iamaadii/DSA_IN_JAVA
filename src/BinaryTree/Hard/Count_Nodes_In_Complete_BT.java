package BinaryTree.Hard;

import java.util.Map;

public class Count_Nodes_In_Complete_BT {

    static int bruteForce(Node root){
        if (root == null) return 0;

        int leftCount = bruteForce(root.left);
        int rightCount = bruteForce(root.right);

        return 1 + leftCount + rightCount;
    }




    static int leftHeight(Node root){
        int height = 0;
        while (root != null){
            height += 1;
            root = root.left;
        }
        return height;
    }
    static int rightHeight(Node root){
        int height = 0;
        while (root != null){
            height += 1;
            root = root.right;
        }
        return height;
    }
    static int optimal(Node root){
        if (root == null) return 0;

        int leftHeight = 1 + leftHeight(root.left);
        int rightHeight = 1 + rightHeight(root.right);

        if (leftHeight == rightHeight) return (int)Math.pow(2,leftHeight) - 1;

        int l = optimal(root.left);
        int r = optimal(root.right);
        return 1+l+r;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
//        root.left.right.right = new Node(11);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(bruteForce(root));
        System.out.println(optimal(root));
    }
}
