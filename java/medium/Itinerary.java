package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Itinerary {
  // priority queue takes care of the ordering
  Map<String, PriorityQueue<String>> airports = new HashMap<>();
  List<String> route = new LinkedList<>();

  public List<String> itinerary(String[][] tickets) {
    // compute the airports and their destination
    for (String[] ticket : tickets) {
      // this basically says, if ticket[0] doesn't exist, create it and map to a
      // priority queue, add ticket[1]
      airports.computeIfAbsent(ticket[0], k -> new PriorityQueue<>())
          .add(ticket[1]);
    }
    visit("JFK");
    return route;
  }

  private void visit(String airport) {
    while (airports.containsKey(airport) && !airports.get(airport).isEmpty()) {
      // poll means the first element, in sorted order.
      visit(airports.get(airport).poll());
    }
    // once we reach the end of a route, add it to list, and add the routes as
    // we retreat in reverse order, till we find other routes we haven't visited
    route.add(0, airport);
  }

  public static void main(String[] args) {
    String[][] input = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};

    List<String> res = new Itinerary().itinerary(input);
    System.out.println(res.toString());
  }
}

/*

Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

    If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
    All airports are represented by three capital letters (IATA code).
    You may assume all tickets form at least one valid itinerary.
    One must use all the tickets once and only once.

Example 1:
Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

Example 2:
Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
*/