/*
Given two arrays representing the inorder and preorder traversals of a binary tree, your task is to construct the binary tree and
return its root.
Note: The inorder and preorder traversals contain unique values.
*/
package BinaryTree.Hard;
import java.util.HashMap;
import java.util.Map;
import static BinaryTree.Hard.Node.*;

public class Binary_Tree_From_Inorder_And_Preorder {

    static Node construction(int[] inorder, int inStart, int inEnd, Map<Integer,Integer> inMap,int[] preorder, int preStart,int preEnd)
    {
        if (inStart>inEnd || preStart>preEnd) return null;

        Node root = new Node(preorder[preStart]);
        int inRoot = inMap.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = construction(inorder,inStart,inRoot-1,inMap,preorder,preStart+1,preStart+numsLeft);
        root.right = construction(inorder,inRoot+1,inEnd,inMap,preorder,preStart+numsLeft+1,preEnd);
        return root;
    }

    static Node optimal(int[] inorder, int[] preorder){
        HashMap<Integer,Integer> inMp = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            inMp.put(inorder[i],i);

        return construction(inorder,0,inorder.length-1,inMp,preorder,0,preorder.length-1);
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] preorder = {3,9,20,15,7};
        Node root = optimal(inorder,preorder);

        System.out.println(levelOrder(root));
    }
}
