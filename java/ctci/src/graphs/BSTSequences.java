package graphs;

import java.util.ArrayList;
import java.util.LinkedList;

import Library.TreeNode;

/**
 * A binary search tree was created by traversing thorugh an array from left to right and inserting each element. Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.
 * Eg: Given        1
 *                /   \
 *               2     3
 * Output: {2, 1, 3}, {2, 3, 1}
 */
public class BSTSequences {
  static public ArrayList<LinkedList<Integer>> allSequences(
      final TreeNode head) {
    final ArrayList<LinkedList<Integer>> result = new ArrayList<>();
    if (head == null) {
      result.add(new LinkedList<>());  // this shouldnt be necessary
      return result;
    }

    // add head to prefix of children to be weaved
    final LinkedList<Integer> prefix = new LinkedList<>();
    prefix.add(head.data);

    final ArrayList<LinkedList<Integer>> leftSeq = allSequences(head.left);
    final ArrayList<LinkedList<Integer>> rightSeq = allSequences(head.right);

    // weave the two together
    for (final LinkedList<Integer> left : leftSeq) {
      for (final LinkedList<Integer> right : rightSeq) {
        final ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
        weaveList(left, right, prefix, weaved);
	      result.addAll(weaved);
      }
    }
    return result;
  }

  static private void weaveList(LinkedList<Integer> left, LinkedList<Integer> right, LinkedList<Integer> prefix ,ArrayList<LinkedList<Integer>> res) {
    if (left.size() == 0 || right.size() == 0) {
      LinkedList<Integer> prefixClone = (LinkedList<Integer>) prefix.clone();
      prefixClone.addAll(left);
      prefixClone.addAll(right);
      res.add(prefixClone);
      return;
    }

    // weave from head of left
    int headLeft = left.removeFirst();
    prefix.addLast(headLeft);
    weaveList(left, right, prefix, res);
    // backtrack
    prefix.removeLast();
    left.addFirst(headLeft);

    // weave from head of right
    int headRight = right.removeFirst();
    prefix.addLast(headRight);
    weaveList(left, right, prefix, res);
    prefix.removeLast();
    right.addFirst(headRight);
  }
  
  static public void main(String[] args) {
    int[] nodes_flattened = {2, 1, 5, 6, 7};
    TreeNode root = TreeNode.createMinimalBST(nodes_flattened);
    ArrayList<LinkedList<Integer>> res = BSTSequences.allSequences(root);
    System.out.print(res.toString());
  }
}