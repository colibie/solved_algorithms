import java.util.LinkedList;

public class DiGraph {
  private int v;
  private int e;
  private LinkedList<Integer>[] adj;

  public DiGraph(int n) {
    v = n;
    adj = (LinkedList<Integer>[]) new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adj[i] = new LinkedList<>();
    }
  }
  public void addEdge(int v, int w) {
    adj[v].add(w);
    e++;
  }

  public Iterable<Integer> adj(int v) { return adj[v]; }

  /**
   * Number of vertices
   * @return int
   */
  public int V() { return v; }

  /**
*Number of edges
*@return int
*/
  public int E() { return e; }
  /**
   * Reverses the graph direction
   * For directed graphs only
   * @param g
   * @return reversed graph
   */
  public DiGraph reverse() {
    DiGraph rev = new DiGraph(v);

    for (int i = 0; i < v; i++) {
      for (Integer v : adj(i)) {
        rev.addEdge(v, i);
      }
    }
    return rev;
  }
  public static void main(String[] args) {
    DiGraph test = new DiGraph(4);
    test.addEdge(0, 1);
    test.addEdge(1, 2);
    test.addEdge(1, 3);
    test.addEdge(3, 0);

    System.out.println(test.E() + " edges");
    System.out.println(test.V() + " vertices");

    for (Integer v : test.adj(2)) {
      System.out.println("2->" + v);
    }

    DiGraph revTest = test.reverse();
    for (Integer v : revTest.adj(2)) {
      System.out.println("2->" + v);
    }
  }
}