// hackerrank compatitible solution
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class SwapNodes2 {

  private static class Node {
    int data;
    Node left;
    Node right;
    int depth;

    Node(int data, int depth) {
      this.data = data;
      this.depth = depth;
    }
  }

  /*
   * Complete the swapNodes function below.
   */
  static int[][] swapNodes(int[][] indexes, int[] queries) {
    Node root = createBST(indexes);
    int[][] result = new int[queries.length][];
    for (int i = 0; i < queries.length; i++) {
      root = solve(queries[i], root);
      LinkedList<Integer> inOrder = new LinkedList<>();
      inOrder = inOrder(root, inOrder);
      int[] res = new int[indexes.length];
      for (int j = 0; j < indexes.length; j++) {
        res[j] = inOrder.removeFirst();
      }
      result[i] = res;
    }
    return result;
  }

  static LinkedList<Integer> inOrder(Node x, LinkedList<Integer> res) {
    if (x == null || x.data == -1)
      return res;
    inOrder(x.left, res);
    res.add(x.data);
    inOrder(x.right, res);
    return res;
  }

  static Node solve(int k, Node root) {
    LinkedList<Node> current = new LinkedList<>();
    current.add(root);
    while (current.size() > 0) {
      LinkedList<Node> parents = current;
      current = new LinkedList<>();
      for (Node parent : parents) {
        if (parent.depth % k == 0) {
          Node temp = parent.left;
          parent.left = parent.right;
          parent.right = temp;
        }

        if (parent.left != null && parent.left.data != -1) {
          current.add(parent.left);
        }

        if (parent.right != null && parent.right.data != -1) {
          current.add(parent.right);
        }
      }
    }
    return root;
  }

  static Node createBST(int[][] indexes) {
    LinkedList<Node> current = new LinkedList<>();
    Node root = new Node(1, 1);
    current.add(root);
    for (int i = 0; i < indexes.length;) {
      LinkedList<Node> parents = current;
      current = new LinkedList<>();
      for (Node parent : parents) {
        int[] index = indexes[i];
        parent.left = new Node(index[0], parent.depth + 1);
        parent.right = new Node(index[1], parent.depth + 1);
        if (parent.left.data != -1) {
          current.add(parent.left);
        }
        if (parent.right.data != -1) {
          current.add(parent.right);
        }
        i++;
      }
    }
      
    return root;
  }

  public static void main(String[] args) throws IOException {
    final Scanner scanner = new Scanner(new File("/home/chidera/Documents/algorithms/java/testFile.txt"));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter("/home/chidera/Documents/algorithms/java/result.txt"));

    int n = Integer.parseInt(scanner.nextLine().trim());

    int[][] indexes = new int[n][2];

    for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
      String[] indexesRowItems = scanner.nextLine().split(" ");

      for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
        int indexesItem =
            Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
        indexes[indexesRowItr][indexesColumnItr] = indexesItem;
      }
    }

    int queriesCount = Integer.parseInt(scanner.nextLine().trim());

    int[] queries = new int[queriesCount];

    for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
      int queriesItem = Integer.parseInt(scanner.nextLine().trim());
      queries[queriesItr] = queriesItem;
    }

    int[][] result = swapNodes(indexes, queries);

    for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
      for (int resultColumnItr = 0;
           resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
        bufferedWriter.write(
            String.valueOf(result[resultRowItr][resultColumnItr]));

        if (resultColumnItr != result[resultRowItr].length - 1) {
          bufferedWriter.write(" ");
        }
      }

      if (resultRowItr != result.length - 1) {
        bufferedWriter.write("\n");
      }
    }

    bufferedWriter.newLine();

    bufferedWriter.close();
  }
}
