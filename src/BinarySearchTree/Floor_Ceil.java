/*
You are given a root binary search tree and an integer x. Your task is to find the Ceil of x in the tree.
Note: Ceil(x) is a number that is either equal to x or is immediately greater than x. If Ceil could not be found, return -1.


You are given a BST(Binary Search Tree) with n number of nodes and value x. your task is to find the greatest value node of
the BST which is smaller than or equal to x.
Note: when x is smaller than the smallest node of BST then returns -1.

*/
package BinarySearchTree;
public class Floor_Ceil {

    static int ceil(Node root, int target){
        int res = -1;
        while(root != null){
            if(root.data >= target){
                res = root.data;
                root = root.left;
            }
            else
                root = root.right;
        }
        return res;
    }

    static int floor(Node root, int target){
        int res = -1;
        while(root != null){
            if(root.data <= target){
                res = root.data;
                root = root.right;
            }
            else
                root = root.left;
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        System.out.println(ceil(root,11));
        System.out.println(floor(root,11));
    }
}
