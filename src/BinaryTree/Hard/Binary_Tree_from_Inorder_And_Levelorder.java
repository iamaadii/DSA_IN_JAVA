package BinaryTree.Hard;

import java.util.*;
import static BinaryTree.Hard.Node.*;

class Data{
    Node root;
    int start;
    int end;

    Data(Node root,int start, int end){
        this.root = root;
        this.start = start;
        this.end = end;
    }
}

public class Binary_Tree_from_Inorder_And_Levelorder {

    static Node optimal(int[] inorder, int[] levelorder){
        HashMap<Integer,Integer> inMp = new HashMap<>();
        for (int i=0;i<inorder.length;i++) inMp.put(inorder[i],i);

        int levelIndex = 0;
        Node root = new Node(levelorder[levelIndex++]);

        Queue<Data> q = new LinkedList<>();
        q.add(new Data(root,0,inorder.length-1));
        while (!q.isEmpty()){
            Data curr = q.remove();
            Node node = curr.root;
            int inStart = curr.start, inEnd = curr.end;

            int currIndex = inMp.get(node.data);
            if (inStart < currIndex){
                Node temp = new Node(levelorder[levelIndex++]);
                node.left = temp;
                q.add(new Data(temp,inStart,currIndex-1));
            }
            if (currIndex < inEnd){
                Node temp = new Node(levelorder[levelIndex++]);
                node.right = temp;
                q.add(new Data(temp,currIndex+1,inEnd));
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] inorder  = {4, 8, 10, 12, 14, 20, 22};
        int[] levelorder = {20, 8, 22, 4, 12, 10, 14};


        Node root = optimal(inorder,levelorder);
        System.out.println(levelOrder(root));
    }
}
