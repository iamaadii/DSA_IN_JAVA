/*
You're given a binary tree. Your task is to find the size of the largest subtree within this binary tree that also satisfies
the properties of a Binary Search Tree (BST). The size of a subtree is defined as the number of nodes it contains.

Note: A subtree of the binary tree is considered a BST if for every node in that subtree, the left child is less than the node,
 and the right child is greater than the node, without any duplicate values in the subtree.
*/
package BinarySearchTree;
import java.util.ArrayList;

public class LargestBSTinBT {

    static void helper(Node root,ArrayList<Integer> list){
        if (root==null) return;
        helper(root.left,list);
        list.add(root.data);
        helper(root.right,list);
    }
    static int bruteForce(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        helper(root,list);

        int maxSize = 1;
        int count = 1;
        for (int i=0;i<list.size()-1;i++){
            if (list.get(i)<list.get(i+1)){
                count += 1;
            }
            else{
                maxSize = Math.max(count,maxSize);
                count = 1;
            }
        }
        maxSize = Math.max(count,maxSize);
        return maxSize;
    }






    static class Pair{
        int min,max,size;

        Pair(int min,int max,int size){
            this.min = min;
            this.max=max;
            this.size=size;
        }
    }
    static Pair optimal(Node root){
        if (root==null) return new Pair(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        Pair l =  optimal(root.left);
        Pair r = optimal(root.right);

        if (l.max < root.data && r.min > root.data){
            int newMin = (root.left == null) ? root.data : l.min;
            int newMax = (root.right == null) ? root.data : r.max;
            return new Pair(newMin, newMax, l.size + r.size + 1);
        }
        return new Pair(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(l.size,r.size));
    }


    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(7);
        root.left.right = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(2);
        root.right.right = new Node(4);

        System.out.println(bruteForce(root));

        Pair res = optimal(root);
        System.out.println(res.size);

    }
}
