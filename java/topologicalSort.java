import java.util.Stack;

public class topologicalSort {
  private DiGraph g;
  private int vertices;
  private boolean marked[];
  private Stack<Integer> postOrder = new Stack<>();

  public topologicalSort(DiGraph g) {
    this.g = g;
    vertices = g.V();
  }

  // do a depth first search, and then add any vertex returned from, to a stack.
  // meaning, the last vertex must be returned, b4 the one following it, b4 the
  // next...
  private void DFS(int v) {
    if (marked[v])
      return;
    marked[v] = true;
    for (Integer edge : g.adj(v)) {
      DFS(edge);
    }
    postOrder.push(v);
  }

  public Iterable<Integer> sort() {
    marked = new boolean[vertices];
    for (int i = 0; i < vertices; i++) {
      DFS(i);
    }
    return postOrder;
  }

  public boolean hasCycle() {
    boolean[] recStack = new boolean[vertices];
    marked = new boolean[vertices];
    for (int i = 0; i < vertices; i++) {
      if (cycleDFS(i, recStack))
        return true;
    }
    return false;
  }
  // keep track of items in the recursive tree, if any is found, return true;
  private boolean cycleDFS(int v, boolean[] recStack) {
    if (marked[v])
      return false;

    recStack[v] = true;
    marked[v] = true;
    for (Integer edge : g.adj(v)) {
      if (recStack[edge])
        return true;
      cycleDFS(edge, recStack);
    }
    recStack[v] = false;
    return false;
  }

  public static void main(String[] args) {
    DiGraph input = new DiGraph(5);
    input.addEdge(0, 1);
    input.addEdge(0, 2);
    input.addEdge(1, 3);
    input.addEdge(1, 4);
    input.addEdge(3, 4);
    input.addEdge(3, 2);
    // input.addEdge(3, 5);
    // input.addEdge(3, 4);
    // input.addEdge(3, 6);
    // input.addEdge(3, 2);
    // input.addEdge(5, 2);
    // input.addEdge(4, 0);

    topologicalSort test = new topologicalSort(input);
    System.out.println(test.hasCycle());

    // note that this only returns correct ordering because Iterable iterates in
    // the order the elements are stored inside the stack. For direct
    // implementation, use Deque
    for (Integer value : test.sort()) {
      System.out.println(value);
    }
  }
}