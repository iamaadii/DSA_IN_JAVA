/*
Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct
the tree and return its root.
*/
package BinarySearchTree;
import static BinarySearchTree.Node.*;

public class BSTfromPreorder {

    static Node bruteforce(int[] arr){
        Node root = new Node(arr[0]);
        for (int i=1;i< arr.length;i++){
            Node curr = root;
            while (true){
                if (arr[i]<curr.data) {
                    if (curr.left == null) {
                        curr.left = new Node(arr[i]);
                        break;
                    }
                    else curr = curr.left;
                }
                else if (arr[i]>curr.data) {
                    if (curr.right == null) {
                        curr.right = new Node(arr[i]);
                        break;
                    }
                    else curr = curr.right;
                }
            }
        }
        return root;
    }


    static Node helper(int[] arr,int max,int[] index) {
        if (index[0] == arr.length || arr[index[0]] > max) return null;
        Node curr = new Node(arr[index[0]]);
        index[0] += 1;
        curr.left = helper(arr, curr.data, index);
        curr.right = helper(arr, max, index);
        return curr;
    }
    static Node optimal(int[] arr){
        return helper(arr,Integer.MAX_VALUE,new int[] {0});
    }

    public static void main(String[] args) {
//        Node root = bruteforce(new int[] {8,5,1,7,10,12});
//        System.out.println(levelOrder(root));

        Node root = optimal(new int[] {8,5,1,7,10,12});
        System.out.println(levelOrder(root));
    }
}
