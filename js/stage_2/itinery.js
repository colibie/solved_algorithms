/**
 * @param {string[][]} tickets
 * @return {string[]}
 */
var findItinerary = function(tickets) {  
  const itineries = {};
  for(const [from, to] of tickets) {
    if(from in itineries) {
      itineries[from].push(to);
    }
    else {
      itineries[from] = [to];
    }
  }
  for(const from in itineries) {
    itineries[from].sort();
    itineries[from].reverse();
  }
  
  return traverse(itineries, "JFK");
};

var traverse = function (itineries, root) {
  
}

var traverse1 = function (itineries, root) {
  let q = [root];
  let res = [];
  
  while (q.length > 0) {
    // pop from queue
    let cur = q.pop();
      
    // add to res
    res.push(cur);

    if (cur in itineries) {
      let parent = itineries[cur];
      let child;

      // find a child that hasn't been visited
      // chose priority over child that has children
      for (let j = parent.length - 1; j >= 0; j--) {
        // if child has not been visited
        if (parent[j] !== null) {
          // if child does not have children and you've not seen child that is childless
          if (!(parent[j] in itineries) && !child) {
            // then child == parent[j] ie store index of child so you can null it
            child = j;
          }
          
          if (parent[j] in itineries) {
            child = j;
            break;
          }
          // if you now see child that has a child, assign it to child and break out
        }
      }
      if (child !== undefined) {
        q.push(parent[child]);
        parent[child] = null;
      }
    }
  }
  
  return res;
}

/*


Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
*/

// https://leetcode.com/problems/reconstruct-itinerary/
let itineries = [["EZE","TIA"],["EZE","HBA"],["AXA","TIA"],["JFK","AXA"],["ANU","JFK"],["ADL","ANU"],["TIA","AUA"],["ANU","AUA"],["ADL","EZE"],["ADL","EZE"],["EZE","ADL"],["AXA","EZE"],["AUA","AXA"],["JFK","AXA"],["AXA","AUA"],["AUA","ADL"],["ANU","EZE"],["TIA","ADL"],["EZE","ANU"],["AUA","ANU"]]
console.log(findItinerary(itineries))

Input: [["EZE","HBA"],["AXA","TIA"], ["TIA","AUA"],
        ["ADL","EZE"],["AUA","AXA"],
        ["TIA","ADL"]]

Output: ["JFK","AXA","AUA","ADL","ANU","AUA","ANU","EZE","ADL","EZE","ANU","JFK", "AXA","EZE",
          "TIA","ADL","EZE","HBA"]
Expected: ["JFK","AXA","AUA","ADL","ANU","AUA","ANU","EZE","ADL","EZE","ANU","JFK","AXA","EZE",
          "TIA","AUA","AXA","TIA","ADL","EZE","HBA"]
         
/**
 * JFK -> ANU -> EZE -> EZE -> AXA -> TIA -> ANU -> JFK
 */
         
         