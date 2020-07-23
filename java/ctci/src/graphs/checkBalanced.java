package graphs;

import Library.TreeNode;

// Implement a function to check if a binary tree is balanced. For the purposes
// of
// this question, a balanced tree is defined to be a tree such that the heights
// of the two subtrees of any
// node never differ by more than one.

public class checkBalanced {
  /**
   * check if a tree is balance by checking the left and right trees recursively
   * and returning an error code(Integer.MIN_VALUE) if the tree isn't balanced
   * @param n
   * @return
   */
  public static int checkHeight(TreeNode n) {
    if (n == null) return -1;

    int leftHeight = checkHeight(n.left);
    if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

    int rightHeight = checkHeight(n.right);
    if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

    int diff = Math.abs(leftHeight - rightHeight);
    if (diff > 0) return Integer.MIN_VALUE;
    return Math.max(leftHeight, rightHeight) + 1;
  }

  public static boolean isBalanced(TreeNode n) {
    return checkHeight(n) != Integer.MIN_VALUE;
  }

  public static void main(String[] args) {
    int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7};
    TreeNode root = TreeNode.createMinimalBST(nodes_flattened);
    TreeNode root2 = TreeNode.createTreeFromArray(nodes_flattened);
    System.out.println("BST Tree");
    System.out.println(checkBalanced.isBalanced(root));
    System.out.println("------------");
    System.out.println("Tree");
    System.out.println(checkBalanced.isBalanced(root2));
  }
}