package BinaryTree.Traversals;
import java.util.ArrayList;

public class Morris_TreeTraversal {
    static ArrayList<Integer> inOrder(Node root){
        ArrayList<Integer> res = new ArrayList<>();
        Node current = root;

        while (current != null){
            if (current.left == null){
                res.add(current.data);
                current = current.right;
            }
            else {
                Node temp = current.left;
                while (temp.right != null && temp.right != current)
                    temp = temp.right;

                if (temp.right == null){
                    temp.right = current;
                    current = current.left;
                }
                else{
                    temp.right = null;
                    res.add(current.data);
                    current = current.right;
                }
            }
        }
        return res;
    }

    static ArrayList<Integer> preOrder(Node root){
        ArrayList<Integer> res = new ArrayList<>();
        Node current = root;

        while (current != null){
            if (current.left == null){
                res.add(current.data);
                current = current.right;
            }
            else {
                Node temp = current.left;
                while (temp.right != null && temp.right != current)
                    temp = temp.right;

                if (temp.right == null){
                    temp.right = current;
                    res.add(current.data);
                    current = current.left;
                }
                else{
                    temp.right = null;
                    current = current.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);

        System.out.println(inOrder(root));
        System.out.println(preOrder(root));
    }
}
