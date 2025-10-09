/*
Given a Binary Tree, return its Top View. The Top View of a Binary Tree is the set of nodes visible when we see the tree from
the top.

Constraints:
    1 ≤ number of nodes ≤ 10^5
    1 ≤ node->data ≤ 10^5
*/
package BinaryTree.Medium;
import java.util.*;

class Pair{
    Node temp;
    int column;

    Pair(Node temp,int column){
        this.temp = temp;
        this.column = column;
    }
}
public class TopView {
    static ArrayList<Integer> optimal(Node root){
        int minCol = 0, maxCol = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while (!q.isEmpty()){
            int s = q.size();
            for (int i=0;i<s;i++){
                Pair p = q.remove();
                if(p.column > maxCol) maxCol = p.column;
                if(p.column < minCol) minCol = p.column;
                mp.putIfAbsent(p.column, p.temp.data);

                if (p.temp.left != null) q.add(new Pair(p.temp.left,p.column-1));
                if (p.temp.right != null) q.add(new Pair(p.temp.right,p.column+1));
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int col = minCol; col <= maxCol; col++) {
            res.add(mp.get(col));
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(optimal(root));
    }
}
