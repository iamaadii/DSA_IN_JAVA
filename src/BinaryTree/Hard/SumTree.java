/*
Given a Binary Tree. Check for the Sum Tree for every node except the leaf node. Return true if it is a Sum Tree otherwise,
return false.
A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree and
right subtree. An empty tree is also a Sum Tree as the sum of an empty tree can be considered to be 0. A leaf node is also
considered a Sum Tree.
*/
package BinaryTree.Hard;

class Info {
    boolean isSumTree;
    int sum;
    Info(boolean isSumTree, int sum){
        this.isSumTree = isSumTree;
        this.sum = sum;
    }
}

public class SumTree {

    static boolean res = true;
    static int optimalUsingStaticVariable(Node root){
        if(root==null) return 0;
        if(root.left == null && root.right == null) return root.data;

        int l = optimalUsingStaticVariable(root.left);
        int r = optimalUsingStaticVariable(root.right);

        if(root.data != (l+r))
            res = false;

        return root.data + l + r;
    }
    boolean isSumTree(Node root) {
        // Your code here
        res = true;
        if(root == null) return res;

        optimalUsingStaticVariable(root);
        return res;
    }

    static Info optimalByReturningMultipleThings(Node root){
        if(root == null) return new Info(true, 0);
        if(root.left == null && root.right==null) return new Info(true, root.data);

        Info left = optimalByReturningMultipleThings(root.left);
        Info right = optimalByReturningMultipleThings(root.right);

        boolean isCurrentSumTree = left.isSumTree && right.isSumTree && (root.data == left.sum + right.sum);
        int totalSum = root.data + left.sum + right.sum;

        return new Info(isCurrentSumTree, totalSum);
    }


    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(10);
        root.left.right = new Node(10);


        res = true;
        optimalUsingStaticVariable(root);
        System.out.println(res);


        Info res = optimalByReturningMultipleThings(root);
        System.out.println(res.isSumTree);
    }
}
