package BinaryTree.Traversals;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static BinaryTree.Traversals.Node.*;

public class PostOrder_Traversal {

    static void recursively(Node root, List<Integer> res){
        if (root == null) return;

        recursively(root.left,res);
        recursively(root.right,res);
        res.add(root.data);
    }

    static List<Integer> iterativelyUsingTwoStacks(Node root){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        s1.add(root);
        while (!s1.isEmpty()){
            Node temp = s1.pop();
            s2.add(temp);
            if (temp.left != null) s1.add(temp.left);
            if (temp.right != null) s1.add(temp.right);
        }

        while (!s2.isEmpty()){
            res.add(s2.pop().data);
        }
        return res;
    }

    static List<Integer> iterativelyUsingOneStacks(Node root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Node current = root;
        Stack<Node> s = new Stack<>();

        while (current != null || !s.isEmpty()){
            if (current != null){
                s.add(current);
                current = current.left;
            }
            else{
                Node temp = s.peek().right;
                if (temp == null){
                    temp = s.pop();
                    res.add(temp.data);

                    while (!s.isEmpty() && temp == s.peek().right){
                        temp = s.pop();
                        res.add(temp.data);
                    }
                }
                else current = temp;
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

        System.out.println(iterativelyUsingTwoStacks(root));
        System.out.println(iterativelyUsingOneStacks(root));
    }
}
