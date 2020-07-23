package graphs;

import Library.TreeNode;

public class validateBST {
  /**
   * Using the in-order traversal to check that tree is in sorted order. Does
   * not account for duplicate values
   * @param n
   * @return
   */
  static int lastValue = Integer.MIN_VALUE;
  public static boolean usingNorder(TreeNode n) {
    if (n == null) return true;
    // if left tree is not bst
    if (!usingNorder(n.left)) return false;

    // check current
    if (lastValue != Integer.MIN_VALUE && lastValue >= n.data) return false;
    lastValue = n.data;

    if (!usingNorder(n.right)) return false;
    return true;
  }

  public static boolean usingMinMax(TreeNode n) {
    return validateBST.checkBST(n, null, null);
  }

  /**
   * Recursively checks that the node on the right is not less than or equal to it's parent which
   * is the min value for that context and that the left node is not greater than it's parent 
   * which is the max value for that context
   * @param n
   * @param min
   * @param max
   * @return
   */
  public static boolean checkBST(TreeNode n, Integer min, Integer max) {
    if (n == null) return true;

    // check that either of the left node or right node is in check
    if ((max != null && n.data > max) || (min != null && n.data <= min)) return false;

    // recurse to the left and right
    if (!checkBST(n.left, min, n.data) || (!checkBST(n.right, n.data, max))) return false;

    return true;
    
  }
  public static void main(String[] args) {
    int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7};
    TreeNode root = TreeNode.createMinimalBST(nodes_flattened);
    TreeNode root2 = TreeNode.createTreeFromArray(nodes_flattened);
    System.out.println("BST Tree");
    System.out.println(validateBST.usingNorder(root));
    System.out.println("------------");
    System.out.println("Tree");
    System.out.println(validateBST.usingMinMax(root2));
  }
}