package BinarySearchTree;
import java.util.Stack;

public class BST_Iterator {

    Stack<Node> st = new Stack<>();
    BST_Iterator(Node root){
        pushAll(root);
    }

    boolean hasNext(){
        return !st.isEmpty();
    }

    int next(){
        Node curr = st.pop();
        pushAll(curr.right);
        return curr.data;
    }

    void pushAll(Node root){
        while (root != null){
            st.push(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(3);
        root.right = new Node(15);
        root.right.left = new Node(9);
        root.right.right = new Node(20);

        BST_Iterator obj = new BST_Iterator(root);
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
    }
}
