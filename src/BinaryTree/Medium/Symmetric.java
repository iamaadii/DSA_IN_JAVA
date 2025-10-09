/*
Given a Binary Tree, determine whether the given tree is symmetric or not. A Binary Tree would be Symmetric, when its mirror image
is exactly the same as the original tree. If we were to draw a vertical line through the centre of the tree, the nodes on the left
and right side would be mirror images of each other.

Constraints:
    The number of nodes in the tree is in the range [1, 1000].
    -100 <= Node.val <= 100
*/
package BinaryTree.Medium;
public class Symmetric {

    static boolean optimal(Node r1, Node r2){
        if(r1==null || r2==null){
            if(r1==null && r2==null) return true;
            return false;
        }
        if(r1.data != r2.data) return false;
        return optimal(r1.left,r2.right) && optimal(r1.right,r2.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(3);
        root.right.left = new Node(4);

        System.out.println(optimal(root.left,root.right));
    }
}
