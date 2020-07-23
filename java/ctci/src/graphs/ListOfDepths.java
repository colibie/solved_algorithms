package graphs;

import java.util.ArrayList;
import java.util.LinkedList;

import Library.TreeNode;

public class ListOfDepths {
  /**
   * Add root to list as level 0, add roots direct children as level 1 and
   * children's children as next level
   * @param root
   * @return an arraylist with list of roots at each level
   */
  public static ArrayList<LinkedList<TreeNode>> levelListsBFS(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();

    LinkedList<TreeNode> current = new LinkedList<>();
    if (root != null) {
      current.add(root);
    }

    while (current.size() > 0) {
      // add current to array and iterate the children
      result.add(current);
      LinkedList<TreeNode> parents = current;
      current = new LinkedList<>();
      for (TreeNode parent : parents) {
        // visit the children
        if (parent.left != null) {
          current.add(parent.left);
        }
        if (parent.right != null) {
          current.add(parent.right);
        }
      }
    }
    return result;
  }

  /**
   * Recursively search through nodes, keeping track of levels and adding nodes
   * to list according to which level we are in
   * @param current
   * @param result
   * @param level
   */

  private static void levelListsDFS(TreeNode current,
                                    ArrayList<LinkedList<TreeNode>> result,
                                    int level) {
    if (current == null) return;
    // initialize a list
    LinkedList<TreeNode> list = null;
    if (result.size() ==
        level) {  // if the level we are at hasn't been added to list
      list = new LinkedList<>();
      result.add(list);
    } else {
      list = result.get(level);
    }
    list.add(current);  // add the node to the list
    levelListsDFS(current.left, result, level + 1);
    levelListsDFS(current.right, result, level + 1);
  }

  public static ArrayList<LinkedList<TreeNode>> levelListsDFS(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
    levelListsDFS(root, result, 0);
    return result;
  }

  public static void printLevels(ArrayList<LinkedList<TreeNode>> levels) {
    int depth = 0;
    for (LinkedList<TreeNode> level : levels) {
      System.out.print("The nodes at depth " + depth + ":");
      for (TreeNode node : level) {
        System.out.print(node.data + " ");
      }
      System.out.println();
      depth++;
    }
  }

  public static void main(String[] args) {
    int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(nodes_flattened);
    TreeNode root2 = TreeNode.createTreeFromArray(nodes_flattened);
    ArrayList<LinkedList<TreeNode>> list = levelListsBFS(root);
    ArrayList<LinkedList<TreeNode>> list2 = levelListsDFS(root2);
    System.out.println("BFS Approach");
    printLevels(list);
    System.out.println("------------");
    System.out.println("DFS Approach");
    printLevels(list2);
  }
}