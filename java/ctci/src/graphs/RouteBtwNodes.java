package graphs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Test;

import Library.Graph;
import Library.GraphNode;

public class RouteBtwNodes {
  public enum State { Unvisited, Visiting, Visited }

  public static Graph createNewGraph() {
    final Graph g = new Graph();
    final GraphNode[] temp = new GraphNode[6];

    temp[0] = new GraphNode("a", 3);
    temp[1] = new GraphNode("b", 0);
    temp[2] = new GraphNode("c", 0);
    temp[3] = new GraphNode("d", 1);
    temp[4] = new GraphNode("e", 1);
    temp[5] = new GraphNode("f", 0);

    temp[0].addAdjacent(temp[1]);
    temp[0].addAdjacent(temp[2]);
    temp[0].addAdjacent(temp[3]);
    temp[3].addAdjacent(temp[4]);
    temp[4].addAdjacent(temp[5]);

    g.addNodes(temp);

    return g;
  }

  public static boolean search(Graph g, GraphNode start, GraphNode end) {
    if (start == null || end == null) {
      return false;
    }
    if (start == end) {
      return true;
    }

    // we will do BFS using Linked list
    // mark all nodes as unvisited
    for (GraphNode node : g.getNodes()) {
      node.state = State.Unvisited;
    }

    // visiting start
    start.state = State.Visiting;

    LinkedList<GraphNode> n = new LinkedList<>();
    n.add(start);

    GraphNode u;
    while (!n.isEmpty()) {
      // remove the first node
      u = n.removeFirst();
      if (u != null) {
        for (GraphNode adj : u.getAdjacent()) {
          if (adj.state == State.Unvisited) {
            if (adj == end) {
              return true;
            } else {
              adj.state = State.Visiting;
              n.add(adj);
            }
          }
        }
        u.state = State.Visited;
      }
    }
    return false;
  }

  @Test
  public static void main(String[] args) {
    Graph g = RouteBtwNodes.createNewGraph();
    GraphNode[] n = g.getNodes();
    
    assertTrue("There's a path between d and f", search(g, n[3], n[5]));
    
    assertFalse("There's no path between a and e", search(g, n[1], n[4]));

    assertTrue("There's a path between same node", search(g, n[1], n[1]));

    assertFalse("There's no path when node is null", search(g, n[4], null));
  }
}
