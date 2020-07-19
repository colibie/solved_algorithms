// My local solution

import java.util.LinkedList;
import java.util.Scanner;

public class SwapNodes {
  private Node root;
  private class Node {
    int data;
    Node left;
    Node right;
    int depth;

    Node(int data, int depth) {
      this.data = data;
      this.depth = depth;
    }
  }

  public SwapNodes() { root = new Node(1, 1); }

  public Node getRoot() { return root; }

  public Node addNode(int data, int depth) { return new Node(data, depth); }

  public void solve(int k) {
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
  }

  public LinkedList<Integer> inOrder(Node x, LinkedList<Integer> res, int i) {
    if (x == null || x.data == -1)
      return res;
    inOrder(x.left, res, i-1);
    res.add(x.data);
    inOrder(x.right, res, i-1);
    return res;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    SwapNodes test = new SwapNodes();
    LinkedList<Node> current = new LinkedList<>();
    current.add(test.getRoot());
    int i = 1;
    int noOfNodes = Integer.parseInt(input.nextLine());
    while (i < noOfNodes) {
      LinkedList<Node> parents = current;
      current = new LinkedList<>();
      for (Node parent : parents) {
        parent.left = test.addNode(input.nextInt(), parent.depth + 1);
        parent.right = test.addNode(input.nextInt(), parent.depth + 1);
        if (parent.left.data != -1) {
          current.add(parent.left);
        }
        if (parent.right.data != -1) {
          current.add(parent.right);
        }
        i++;
      }
    }
    int k = input.nextInt();
    for (int j = 0; j < k; j++) {
      test.solve(input.nextInt());
      LinkedList<Integer> res = new LinkedList<>();
      res = test.inOrder(test.getRoot(), res, noOfNodes);
      for (int l : res) {
        System.out.print(l + " ");
      }
      System.out.print("\n");
    }

    input.close();
  }
}