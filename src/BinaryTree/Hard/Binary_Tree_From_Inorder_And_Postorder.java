/*
Given two arrays representing the inorder and postorder traversals of a binary tree, your task is to construct the binary tree and
return its root.
Note: The inorder and preorder traversals contain unique values.
*/
package BinaryTree.Hard;
import java.util.HashMap;
import java.util.Map;
import static BinaryTree.Hard.Node.*;

public class Binary_Tree_From_Inorder_And_Postorder  {

    static Node construction(int[] inorder, int inStart, int inEnd, Map<Integer,Integer> inMap,int[] postorder, int postStart,int postEnd)
    {
        if (inStart>inEnd || postStart>postEnd) return null;

        Node root = new Node(postorder[postEnd]);
        int inRoot = inMap.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = construction(inorder,inStart,inRoot-1,inMap,postorder,postStart,postStart+numsLeft-1);
        root.right = construction(inorder,inRoot+1,inEnd,inMap,postorder,postStart+numsLeft,postEnd-1);
        return root;
    }

    static Node optimal(int[] inorder, int[] postorder){
        HashMap<Integer,Integer> inMp = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            inMp.put(inorder[i],i);

        return construction(inorder,0,inorder.length-1,inMp,postorder,0,postorder.length-1);
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        Node root = optimal(inorder,postorder);

        System.out.println(levelOrder(root));
    }
}
