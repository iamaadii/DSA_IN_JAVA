/*
Given the root of a binary tree, a ‘target’ node , and an integer k. Return an arrayList of the values of all nodes that have a
distance k from the target node. The answer can be returned in any order.
*/
package BinaryTree.Hard;
import java.util.*;

public class All_Nodes_At_Distance_K {

    static void markParents(Node root,Map<Node,Node> parentTrack){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        parentTrack.put(root,null);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0; i<size; i++){
                Node temp = q.remove();
                if (temp.left != null){
                    parentTrack.put(temp.left,temp);
                    q.add(temp.left);
                }
                if (temp.right != null){
                    parentTrack.put(temp.right,temp);
                    q.add(temp.right);
                }
            }
        }
    }

    static List<Integer> optimal(Node root,Node target,int k){
        Map<Node,Node> parentTrack = new HashMap<>();
        markParents(root,parentTrack);

        Queue<Node> q = new LinkedList<>();
        Map<Node, Boolean> visited = new HashMap<>();
        int currDist = 0;
        q.add(target);
        visited.put(target,true);
        while (!q.isEmpty()){
            int size = q.size();
            if (currDist == k) break;
            for (int i=0; i < size; i++){
                Node temp = q.remove();

                Node upward = parentTrack.get(temp);
                if(upward != null && !visited.containsKey(upward)){
                    q.add(upward);
                    visited.put(upward,true);
                }
                if (temp.left != null && !visited.containsKey(temp.left)){
                    q.add(temp.left);
                    visited.put(temp.left,true);
                }
                if (temp.right != null && !visited.containsKey(temp.right)){
                    q.add(temp.right);
                    visited.put(temp.right,true);
                }
            }
            currDist += 1;
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()){
            Node temp = q.remove();
            res.add(temp.data);
        }
        Collections.sort(res);
        return res;
    }


    public static void main(String[] args) {
        Node root = new Node(40);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(9);
        root.right.left = new Node(30);
        root.right.right = new Node(40);

        System.out.println(optimal(root,root.left,2));
    }
}
