/*
Given a Binary Tree, convert it to a Linked List where the linked list nodes follow the same order as the pre-order traversal
of the binary tree. Use the right pointer of the Binary Tree as the ‘next’ pointer for the linked list and set the left pointer
to null. Do this in place and do not create extra nodes.
*/
package BinaryTree.Hard;
import java.util.Stack;

public class Flatten_BinaryTree_To_LinkedList {

    static Node prev = null;
    static void recursion(Node root){
        if (root == null) return;

        recursion(root.right);
        recursion(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    static void iterative(Node root){
        if(root == null) return;

        Stack<Node> st = new Stack<>();
        st.add(root);
        while (!st.isEmpty()){
            Node curr = st.pop();
            if (curr.right != null) st.add(curr.right);
            if (curr.left != null) st.add(curr.left);
            if (!st.isEmpty()) curr.right = st.peek();
            curr.left = null;
        }
    }

    static void usingThreadedBinaryTree(Node root){
        if (root == null) return;

        Node curr = root;
        while (curr != null){
            if (curr.left != null){
                Node prev = curr.left;
                while (prev.right != null)
                    prev = prev.right;

                prev.right = curr.right;
                curr.right = curr.left;
            }
            curr.left = null;
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);


//        prev = null;
//        recursion(root);
//        Node t1 = prev;
//        while (t1 != null){
//            System.out.print(t1.data + "->");
//            t1 = t1.right;
//        }
//        System.out.println();



//        iterative(root);
//        Node t2 = root;
//        while (t2 != null){
//            System.out.print(t2.data + "->");
//            t2 = t2.right;
//        }


        usingThreadedBinaryTree(root);
        Node t3 = root;
        while (t3 != null){
            System.out.print(t3.data + "->");
            t3 = t3.right;
        }

    }
}
