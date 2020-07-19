import java.util.*;

class Main {
  static public LinkedList<Integer> killProcess(int[] pid, int[] ppid, int kill) {
    // PID = [1, 3, 10, 5], PPID = [3, 0, 5, 3], killID = 5
    HashMap<Integer, LinkedList<Integer>> tree = new HashMap<>();

    for (int i = 0; i < ppid.length; i++) {
      if (ppid[i] == 0) continue;
      LinkedList<Integer> children = tree.get(ppid[i]);
      if (children == null) {
        children = new LinkedList<>();
        children.add(pid[i]);  
        tree.put(ppid[i], children); 
      } else {
        children.add(pid[i]);   
      }
    }
    
    // do the kill process
    LinkedList<Integer> killed = new LinkedList<>();
    proceedToKill(tree, kill, killed);
    return killed;
  }
  
  static private void proceedToKill(HashMap<Integer, LinkedList<Integer>> tree, int kill, LinkedList<Integer> killed) {
    
    Queue<Integer> queue = new LinkedList<>(); 
    queue.add(kill); 
    
    int current; 
    // remove from queue
    // add to killed
    // add the children to queue
    while (queue.size() != 0) { 
      current = queue.remove();  // queue = [];  c = 10
      killed.add(current); // killed = [5, 10]
      LinkedList<Integer> children = tree.get(current);
      if (children != null) {
        for (Integer child : tree.get(current)) { // tree = { 3:[1, 5], 5:[10]}; 
          queue.add(child); 
        }
      }
    }
  }
  
  static public void main( String args[] ) {
    int[] pid = {10, 8, 3, 7, 6, 1, 5, 2, 4, 9};
    int[] ppid = {5, 10, 0, 2, 1, 3, 3, 1, 5, 10};
    int kill = 2;
    LinkedList<Integer> killed = Main.killProcess(pid, ppid, kill);
    System.out.println(killed.toString());
  }
}

/**
 * """
Problem: Kill Process

    In this problem, each process has a unique PID (process id) and
    PPID (parent process id).
    
    p -> parent
 
    Each process only has one parent process, but may have one or more
    children processes.
    This is just like a tree structure. Only one process has PPID that is 0,
    which means this process has no parent process. All the PIDs will be
    distinct positive integers.

    We use two list of integers to represent a list of processes, where the
    first list contains PID for each process and the second list contains the
    corresponding PPID.

    Now given the two lists, and a PID representing a process you want to kill,
    return a list of PIDs of processes that will be killed in the end.
    You should assume that when a process is killed, all its children processes
    will be killed. No order is required for the final answer.


Example 1:
    Input: PID = [1, 3, 10, 5], PPID = [3, 0, 5, 3], killID = 5
    Output: [5, 10]
    Explanation: Kill 5 will also kill 10.
         3
       /   \
      1     5
           /
          10

Example 2:
    Input: PID = [1, 2, 3], PPID = [0, 1, 1], killID = 2
    Output: [2]
    Notice:
        The given kill id is guaranteed to be one of the given PIDs.
        There is at least one PID in the list.
""" 

"""
         3
       /   \
      1     5
     / \   /  \
    2   6 10   4
   /     /  \
  7     8    9    
  
  PID  = [10, 8, 3, 7, 6, 1, 5, 2, 4, 9], 
                  PPID = [5, 10, 0, 2, 1, 3, 3, 1, 5, 10]
                  kill = 10
 
         3
       /   \
      1     5
     / \   /  \
    2   6 10   4
   /     /  \
  7     8    9    
*/