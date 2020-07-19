package medium;

public class HuffmanDecoding {
  // private class Node {
  //   int data;
  //   Node left;
  //   Node right;
  //   int depth;

  //   Node(final int data, final int depth) {
  //     this.data = data;
  //     this.depth = depth;
  //   }
  // }
  public HuffmanDecoding(final String s, final Node root) {
    if (root == null) {
      System.out.print("");
      return;
    }
    for (int i = 0; i < s.length();) {
      Node current = root;
      while (current.left != null || current.right != null) {
        final char bit = s.charAt(i++);
        if (bit == '1')
          current = current.right;
        else
          current = current.left;
      }
      System.out.print(current.data);
    }
  }
}