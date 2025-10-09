package BinaryTree.Hard;
import java.util.*;
import static BinaryTree.Hard.Node.*;

public class Serialize_And_Deserialize {
    static String serialize(Node root){
        if (root == null) return "";

        StringBuilder res = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node temp = q.remove();
            if (temp==null){
                res.append("#,");
            }
            else {
                res.append(temp.data + ",");
                q.add(temp.left);
                q.add(temp.right);
            }
        }
        return res.toString();
    }

    static Node deserialize(String data){
        if (data == "") return null;

        String[] values = data.split(",");
        int i = 0;

        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(values[i++]));
        q.add(root);
        while (!q.isEmpty()){
            Node temp = q.remove();
            if (!values[i].equals("#")){
                Node l = new Node(Integer.parseInt(values[i]));
                temp.left = l;
                q.add(l);
            }
            if (!values[++i].equals("#")){
                Node r = new Node(Integer.parseInt(values[i]));
                temp.right = r;
                q.add(r);
            }
            ++i;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(13);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

//        System.out.println(serialize(root));
        System.out.println(levelOrder(deserialize(serialize(root))));
//        System.out.println(levelOrder(root));

    }
}
