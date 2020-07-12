import java.util.*;
import java.io.*;

/**
 * You are given pointer to the root of the binary search tree and two values
 * and . You need to return the lowest common ancestor (LCA) of and in the
 * binary search tree.
 */

class Node {
  Node left;
  Node right;
  int data;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

class lowestCommonAncestor {

  public static Node lca(Node root, int v1, int v2) {
    // Write your code here.
    if (root == null)
      return null;

    int less = Math.min(v1, v2);
    int greater = Math.max(v1, v2);
    if (less <= root.data && greater >= root.data)
      return root;
    if (less <= root.data && greater <= root.data)
      return lca(root.left, less, greater);
    if (less > root.data && greater > root.data)
      return lca(root.right, less, greater);
    return null;
  }

  /**
   *
   * @param root
   * @param data
   * @return
   */

  public static Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data);
    } else {
      if (data <= root.data) {
        root.left = insert(root.left, data);
      } else {
        root.right = insert(root.right, data);
      }
      return root;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    Node root = null;
    while (t-- > 0) {
      int data = scan.nextInt();
      root = insert(root, data);
    }
    int v1 = scan.nextInt();
    int v2 = scan.nextInt();
    scan.close();
    Node ans = lca(root, v1, v2);
    System.out.println(ans.data);
  }
}

/**given 1 2
 *                    4
 *                /
 *               2
 *
 */