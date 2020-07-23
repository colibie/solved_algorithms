package Library;

public class Graph {
  public static int MAX_VERTICES = 6;
  private GraphNode vertices[];
  public int count;

  public Graph() {
    vertices = new GraphNode[MAX_VERTICES];
    count = 0;
  }

  public void addNodes(GraphNode[] x) {
    if (x.length > MAX_VERTICES) {
      System.out.printf("Only the first %s nodes will be added", MAX_VERTICES);
    }
    while (count < MAX_VERTICES) {
      vertices[count] = x[count++];
    }
  }

  public void addNode(GraphNode x) {
		if (count < vertices.length) {
			vertices[count] = x;
			count++;
		} else {
			System.out.print("Graph full");
		}
  }

  public GraphNode[] getNodes() {
    return vertices;
  }
}