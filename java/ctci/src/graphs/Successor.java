/**
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a
 given node in a
    binary search tree. You may assume that each node has a link to its parent
 */
package graphs;

import Library.TreeNode;

public class Successor {
  public static TreeNode node(TreeNode n) {
    if (n == null) return null;
    // In inorder traversal, left >current->right
    // if n has right child, return leftmost node of right child
    if (n.right != null) {
      return leftMostNode(n.right);
    }
    // else, go up to the parent, if coming from the left, then the parent is to
    // be visited
    // if coming from the right, keep going up till you find, or return null;
    TreeNode current = n;
    TreeNode p = n.parent;
    while (p != null && p.left != current) {
      current = p;
      p = p.parent;
    }
    return current;
  }

  public static TreeNode leftMostNode(TreeNode right) {
    while (right.left != null) {
      right = right.left;
    }
    return right;
  }

  public static void main(String[] args) {
    int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(nodes_flattened);
    TreeNode next = Successor.node(root.left.right.left);
    System.out.println(next.data);
  }
}