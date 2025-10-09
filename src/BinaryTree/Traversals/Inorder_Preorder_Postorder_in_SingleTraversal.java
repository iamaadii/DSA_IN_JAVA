package BinaryTree.Traversals;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static BinaryTree.Traversals.Node.*;

class Pair {
    Node node;
    int state;
    Pair(Node node, int state) {
        this.node = node;
        this.state = state;
    }
}

public class Inorder_Preorder_Postorder_in_SingleTraversal {

    static List<List<Integer>> optimal(Node root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        List<Integer> inOrder = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        Stack<Pair> s = new Stack<>();
        s.add(new Pair(root,1));
        while (!s.isEmpty()){
            Pair p = s.pop();
            if (p.state == 1){
                preOrder.add(p.node.data);
                s.add(new Pair(p.node,p.state +1));
                if (p.node.left != null) s.add(new Pair(p.node.left,1));
            }
            else if (p.state == 2){
                inOrder.add(p.node.data);
                s.add(new Pair(p.node,p.state +1));
                if (p.node.right != null) s.add(new Pair(p.node.right,1));
            }
            else if (p.state == 3){
                postOrder.add(p.node.data);
            }
        }
        res.add(inOrder); res.add(preOrder); res.add(postOrder);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Node root = createTree(arr,0);

        List<List<Integer>> res = optimal(root);
        System.out.println("PreOrder traversals : " + res.get(1));
        System.out.println("InOrder traversals : " + res.get(0));
        System.out.println("PostOrder traversals : " + res.get(2));
    }
}
