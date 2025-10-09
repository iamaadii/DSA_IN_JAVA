/*
Given the root of a binary tree, return the maximum width of the given tree.The maximum width of a tree is the maximum width among
all levels. The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where
the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted
into the length calculation.

Constraints:
    The number of nodes in the tree is in the range [1, 3000].
    -100 <= Node.val <= 100
    */
package BinaryTree.Hard;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    Node root;
    int index;

    Pair(Node root,int index){
        this.root = root;
        this.index = index;
    }
}
public class MaximumWidthOfTree {

    static int bruteForce(Node root){
        int width = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while (!q.isEmpty()){
            int first = ((LinkedList<Pair>) q).peekFirst().index;
            int last = ((LinkedList<Pair>) q).peekLast().index;
            width = Math.max(width,last-first+1);

            int s = q.size();
            for (int i = 0;i<s;i++){
                Pair p = q.remove();
                Node temp = p.root; int index = p.index;

                if (temp.left != null)  q.add(new Pair(temp.left,2*index+1));
                if (temp.right != null) q.add(new Pair(temp.right,2*index+2));
            }
        }
        return width;
    }

    static int optimal(Node root){
        int width = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while (!q.isEmpty()){
            int size = q.size();
            int min = q.peek().index;
            int first=0, last=0;

            for (int i = 0;i<size;i++){
                Pair p = q.remove();
                int curr_ind = p.index - min;

                if (i==0) first = curr_ind;
                if (i==size-1) last = curr_ind;

                if (p.root.left != null)  q.add(new Pair(p.root.left,2*curr_ind+1));
                if (p.root.right != null) q.add(new Pair(p.root.right,2*curr_ind+2));
            }
            width = Math.max(width,last-first+1);
        }
        return width;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(7);

        System.out.println(bruteForce(root));
        System.out.println(optimal(root));
    }
}
