/**
 * // Definition for a Node.
 * function Node(val,prev,next,child) {
 *    this.val = val;
 *    this.prev = prev;
 *    this.next = next;
 *    this.child = child;
 * };
 */

/**
 * @param {Node} head
 * @return {Node}
 */
var flatten = function(head) {
  if(head === null) return head;
  /*
  1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL
  */
  // initialize the stack with your head node
  const stack = [head];
  
  let curr = head;
  
  // 1 <-> 2 <-> 3

  // while stack is not empty
  while (stack.length > 0) { // s = [3]
      // pop node from stack
      let node = stack.pop(); // s = [], n = 3, cur = 2
      if (node !== head) {
          // add to doubly linkedlist
          curr.next = node; 
          node.prev = curr;
          curr = node;
      }
    
      // if node has next
      // add next to start
      if(node.next !== null){ // s = [7, 4], n = 3, cur = 3
          stack.push(node.next);
          node.next = null;
      }

      // if node has child
      // add child to stack
      if (node.child !== null){ 
          stack.push(node.child); 
          node.child = null;
      }
      
  }
  return head
}
/*

https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

You are given a doubly linked list which in addition to the next and previous pointers,
it could have a child pointer, which may or may not point to a separate doubly linked list.
These child lists may have one or more children of their own, and so on,
to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list.
You are given the head of the first level of the list.


Example 1:

Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]
Explanation:

The multilevel linked list in the input is as follows:

After flattening the multilevel linked list it becomes:

Example 2:

Input: head = [1,2,null,3]
Output: [1,3,2]
Explanation:

The input multilevel linked list is as follows:

  1---2---NULL
  |
  3---NULL
Example 3:

Input: head = []
Output: []
 

How multilevel linked list is represented in test case:

We use the multilevel linked list from Example 1 above:

 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL
             
1 -> 2 -> 3 -> 7 -> 8 -> 11 -> 12 -> 9 -> 10 -> 4 -> 5 -> 6 -> null

stack = [1]
res = <-- Head --> 1 <-- Tail ---> 


while stack is not empty: s =  [3]

  remove from stack     s = []
  add to linkedList     res = 1 <-> 2 <-> 3

  if node has child 
    add child to stack  s = [7]
  if node has next
    add next to stack   s = [7, 4]

    s = [1 4]


The serialization of each level is as follows:

[1,2,3,4,5,6,null]
[7,8,9,10,null]
[11,12,null]
To serialize all levels together we will add nulls in each level to signify no node
 connects to the upper node of the previous level. The serialization becomes:

[1,2,3,4,5,6,null]
[null,null,7,8,9,10,null]
[null,11,12,null]
Merging the serialization of each level and removing trailing nulls we obtain:

[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 
Constraints:

Number of Nodes will not exceed 1000.
1 <= Node.val <= 10^5

*/
