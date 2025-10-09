/*
Given the root of a binary tree, calculate the vertical order traversal of the binary tree. For each node at position (row, col),
its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is
at (0, 0). The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from
the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case,
sort these nodes by their values. Return the vertical order traversal of the binary tree.

Constraints:
    The number of nodes in the tree is in the range [1, 1000].
    0 <= Node.val <= 1000
*/
package BinaryTree.Traversals;
import java.util.*;

class Triplet{
    Node temp;
    int level;
    int column;

    Triplet(Node temp,int level,int column){
        this.temp = temp;
        this.level = level;
        this.column = column;
    }
}
public class VerticalOrderTraversal {
    static List<List<Integer>> optimal(Node root){
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(root,0,0));
        while (!q.isEmpty()){
            int s = q.size();
            for (int i=0;i<s;i++){
                Triplet p = q.remove();
                mp.putIfAbsent(p.column, new TreeMap<>());
                mp.get(p.column).putIfAbsent(p.level, new PriorityQueue<>());
                mp.get(p.column).get(p.level).add(p.temp.data);

                if (p.temp.left != null) q.add(new Triplet(p.temp.left,p.level+1,p.column-1));
                if (p.temp.right != null) q.add(new Triplet(p.temp.right,p.level+1,p.column+1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> innerMap : mp.values()) {
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> pq : innerMap.values()) {
                while (!pq.isEmpty())
                    col.add(pq.poll());
            }
            res.add(col);
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
