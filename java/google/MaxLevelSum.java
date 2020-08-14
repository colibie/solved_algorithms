package google;

import java.util.*;
/** SEE QUESTION ON LINE 63 */

// Definition for a binary tree node.
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

public class MaxLevelSum {
  static public int maximumSum(TreeNode root) {
    if (root == null)
      return 0;

    int level = 1;
    int maxSum = root.val;
    int res = level;
    // add the root to the queue for processing
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {

      int sum = 0;
      level++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        // process the children of the queue
        TreeNode cur = queue.poll(); // 1

        if (cur.left != null) {
          queue.add(cur.left);
          sum += cur.left.val;
        }

        if (cur.right != null) {
          queue.add(cur.right);
          sum += cur.right.val;
        }
      }
      // increment the max if maxSum seen is greater than the current max sum;
      if (sum > maxSum) {
        maxSum = sum;
        res = level;
      }
    }
    return res;
  }
}

/*

Given the root of a binary tree, the level of its root is 1, the level of its
children is 2, and so on.

Return the smallest level X such that the sum of all the values of nodes at
level X is maximal.

          1
        /    \
       7      0
     /   \
     7   -8

Example 1:

Input: [1,7,0,7,-8,null,null]
Output: 2
Explanation:
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.

The number of nodes in the given tree is between 1 and 10^4.
-10^5 <= node.val <= 10^5

*/