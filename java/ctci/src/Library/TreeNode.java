package Library;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
  public final int data;
  public TreeNode left;
  public TreeNode right;
  public TreeNode parent;
  private int size = 0;

  // Every initialized tree node has an initial size of 1
  public TreeNode(final int d) {
    data = d;
    size = 1;
  }

  private void setLeftChild(final TreeNode left) {
    // sets the left child and adds a parent
    this.left = left;
    if (left != null) {
      left.parent = this;
    }
  }

  private void setRightChild(final TreeNode right) {
    // sets the right child and adds a parent
    this.right = right;
    if (right != null) {
      right.parent = this;
    }
  }

  public int size() {
    return size;
  }

  public void insertInOrder(final int d) {
    // inserts recursively to the left if d is less than or to the right if d is
    // greater
    if (d <= data) {
      if (left == null) {
        setLeftChild(new TreeNode(d));
      } else {
        left.insertInOrder(d);
      }
    } else {
      if (right == null) {
        setRightChild(new TreeNode(d));
      } else {
        right.insertInOrder(d);
      }
    }
    size++;
  }

  public boolean isBST() {
    // to check if tree is a binary search tree
    if (left != null) {
      if (data < left.data || !left.isBST()) {
        return false;
      }
    }

    if (right != null) {
      if (data >= right.data || !right.isBST()) {
        return false;
      }
    }

    return true;
  }

  public int height() {
    final int leftHeight = left != null ? left.height() : 0;
    final int rightHeight = right != null ? right.height() : 0;
    return 1 + Math.max(leftHeight, rightHeight);

    // int leftHeight = 0;
    // int rightHeight = 0;
    // if (left != null) leftHeight = left.height();
    // if (right != null) rightHeight = right.height();
    // return 1 + Math.max(leftHeight, rightHeight);
  }

  public TreeNode find(final int d) {
    // this implements binary search on the tree O(logN)
    if (d == data) {
      return this;
    } else if (d <= data) {
      return left != null ? left.find(d) : null;
    } else if (d > data) {
      return right != null ? right.find(d) : null;
    }
    return null;
  }

  private static TreeNode createMinimalBST(final int arr[], final int start,
                                           final int end) {
    if (start >= end) return null;

    final int mid = start + (end - start) / 2;
    final TreeNode n = new TreeNode(arr[mid]);
    n.setLeftChild(createMinimalBST(arr, start, mid));
    n.setRightChild(createMinimalBST(arr, mid + 1, end));
    return n;
  }

  public static TreeNode createMinimalBST(final int arr[]) {
    return createMinimalBST(arr, 0, arr.length);
  }
  /**
   * Use a queue to store the data for processing
   * @param arr
   */
  public static TreeNode createTreeFromArray(int[] arr) {
    Queue<TreeNode> fringe = new LinkedList<>();
    TreeNode root = new TreeNode(arr[0]);
    fringe.add(root);
    int i = 1;
    while (i < arr.length) {
      TreeNode current = fringe.element();
      if (current.left == null) {
        current.left = new TreeNode(arr[i]);
        i++;
        fringe.add(current.left);
      } else if (current.right == null) {
        current.right = new TreeNode(arr[i]);
        i++;
        fringe.add(current.right);
      } else {
        // remove the node from queue;
        fringe.remove();
      }
    }
    return root;
  }
}