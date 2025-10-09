/*
Given a target node data and a root of binary tree. If the target is set on fire, determine the shortest amount of time needed to
burn the entire binary tree. It is known that in 1 second all nodes connected to a given node get burned. That is its left child,
right child, and parent.
*/
package BinaryTree.Hard;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Minimum_Time_Taken_To_Burn_The_Binary_Tree_From_a_Node {

    static void markParents(Node root, Map<Node,Node> parentTrack){
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

    static int optimal(Node root, Node target){
        Map<Node,Node> parentTrack = new HashMap<>();
        markParents(root,parentTrack);

        Queue<Node> q = new LinkedList<>();
        Map<Node, Boolean> visited = new HashMap<>();
        int totalTime = 0;
        q.add(target);
        visited.put(target,true);
        while (!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            for (int i=0; i < size; i++){
                Node temp = q.remove();

                Node upward = parentTrack.get(temp);
                if(upward != null && !visited.containsKey(upward)){
                    q.add(upward);
                    visited.put(upward,true);
                    flag = true;
                }
                if (temp.left != null && !visited.containsKey(temp.left)){
                    q.add(temp.left);
                    visited.put(temp.left,true);
                    flag = true;
                }
                if (temp.right != null && !visited.containsKey(temp.right)){
                    q.add(temp.right);
                    visited.put(temp.right,true);
                    flag = true;
                }
            }
            if (flag) totalTime += 1;
        }
        return totalTime;
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

        System.out.println(optimal(root,root.left));
    }
}