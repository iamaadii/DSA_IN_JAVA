/*
Given a binary tree (having distinct node values)root and two node values. Check whether the two nodes with values a and b are cousins.
Note: Two nodes of a binary tree are cousins if they have the same depth with different parents.
*/
package BinaryTree.Hard;
import java.util.*;

public class Check_If_Two_Nodes_Are_Cousins {
    public boolean optimal(Node root, int a, int b) {

        Map<Node,Node> parentMap = new HashMap<>();
        Map<Node,Integer> levelMap = new HashMap<>();

        Node t1 = null, t2 = null;
        int level = 0;

        parentMap.put(root,null);
        levelMap.put(root,level);

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            level += 1;
            for (int i=0; i<size; i++){
                Node temp = q.remove();

                if(temp.data == a) t1 = temp;
                if(temp.data == b) t2 = temp;

                if (temp.left != null){
                    parentMap.put(temp.left,temp);
                    levelMap.put(temp.left,level);
                    q.add(temp.left);
                }
                if (temp.right != null){
                    parentMap.put(temp.right,temp);
                    levelMap.put(temp.right,level);
                    q.add(temp.right);
                }
            }
        }
        if(parentMap.get(t1) != parentMap.get(t2) && levelMap.get(t1) == levelMap.get(t2))
            return true;

        return false;
    }
}
