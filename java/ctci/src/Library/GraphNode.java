package Library;

import graphs.RouteBtwNodes;

public class GraphNode {
  private final String vertex;
  public int adjacentCount;
  private final GraphNode adjacent[];
  public RouteBtwNodes.State state;

  /**
   * Creates a graph node
   * @param vertex
   * @param adjacentLength
   */
  public GraphNode(final String vertex, final int adjacentLength) {
    this.vertex = vertex;
    adjacentCount = 0;
    adjacent = new GraphNode[adjacentLength];
  }

  public void addAdjacents(final GraphNode adjacents[]) {
    int n = adjacent.length;
    if (adjacents.length > n) {
      System.out.printf("Only the first %d adjacent nodes will be added", n);
    }
    while (--n >= 0) {
      adjacent[n] = adjacents[n];
    }
  }

  public void addAdjacent(final GraphNode x) {
    if (adjacentCount < adjacent.length) {
      adjacent[adjacentCount++] = x;
    }
  }

  public GraphNode[] getAdjacent() {
    return adjacent;
  }

  public String getVertex() {
    return vertex;
  }
}