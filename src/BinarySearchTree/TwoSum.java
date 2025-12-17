/*
Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their
sum is equal to k, or false otherwise.
*/
package BinarySearchTree;
import java.util.ArrayList;
import java.util.Stack;

public class TwoSum {

    static void helper(Node root, ArrayList<Integer> inOrder){
        if (root == null) return;
        helper(root.left,inOrder);
        inOrder.add(root.data);
        helper(root.right,inOrder);
    }
    static Boolean bruteForce(Node root,int k){
        ArrayList<Integer> inOrder = new ArrayList<>();
        helper(root,inOrder);

        int i=0, j=inOrder.size()-1;
        while (i<j){
            if (inOrder.get(i)+inOrder.get(j) == k) return true;
            else if (inOrder.get(i)+inOrder.get(j) > k) j=j-1;
            else i=i+1;
        }
        return false;
    }





    static Stack<Node> st1 = new Stack<>();
    static Stack<Node> st2 = new Stack<>();
    TwoSum(Node root){
        pushAll1(root);
        pushAll2(root);
    }
    void pushAll1(Node root){
        while (root != null){
            st1.push(root);
            root = root.left;
        }
    }
    int next(){
        Node curr = st1.pop();
        pushAll1(curr.right);
        return curr.data;
    }


    int before(){
        Node curr = st2.pop();
        pushAll2(curr.left);
        return curr.data;
    }
    void pushAll2(Node root){
        while (root != null){
            st2.push(root);
            root = root.right;
        }
    }

    static Boolean optimal(Node root, int k){
        TwoSum obj = new TwoSum(root);

        int i = obj.next(), j=obj.before();
        while (i<j) {
            if (i+j == k) return true;
            else if(i+j > k) j=obj.before();
            else i=obj.next();
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(6);
        root.right.right = new Node(7);

        System.out.println(bruteForce(root,5));
        System.out.println(optimal(root,15));
    }
}
