package BinaryTree.Traversals;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import static BinaryTree.Traversals.Node.*;

public class PreOrder_Traversal {

    static void recursively(Node root,List<Integer> res){
        if (root == null) return;

        res.add(root.data);
        recursively(root.left,res);
        recursively(root.right,res);
    }

    static List<Integer> iteratively(Node root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<Node> s = new Stack<>();
        s.add(root);
        while (!s.isEmpty()){
            Node temp = s.pop();
            res.add(temp.data);

            if (temp.right != null)  s.add(temp.right);
            if (temp.left != null) s.add(temp.left);
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
