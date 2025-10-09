package BinaryTree.Traversals;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static BinaryTree.Traversals.Node.*;

public class InOrder_Traversal {

    static void recursively(Node root,List<Integer> res){
        if (root == null) return;

        recursively(root.left,res);
        res.add(root.data);
        recursively(root.right,res);
    }

    static List<Integer> iteratively(Node root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Node temp = root;
        Stack<Node> s = new Stack<>();
        while (true){
            if (temp != null){
                s.add(temp);
                temp = temp.left;
            }
            else{
                if (s.isEmpty()) break;
                temp = s.pop();
                res.add(temp.data);
                temp = temp.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Node root = createTree(arr,0);

        List<Integer> res = new ArrayList<>();
        recursively(root,res);
        System.out.println(res);

        System.out.println(iteratively(root));
    }
}
