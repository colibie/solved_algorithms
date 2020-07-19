/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 
 levelNodes = [1]
  level = 1
  sideView = []


  while levelNodes is not empty:
    // for every child in level nodes, append to new level
    sideView.append(levelNodes[-1])
    new_level_nodes = []
    for parent in levelNodes {
      if (parent.left != null) {
          new_level_nodes.append(child)
      }
      if (parent.right != null) {
          new_level_nodes.append(child)
      }
    }

    levelNodes = new_level_nodes
    level += 1
 
 */

var rightSideView = function(root) {
    if(root === null) return [];
    let levelNodes = [root];
    const sideView = [];
    while (levelNodes.length > 0) {
      sideView.push(levelNodes[levelNodes.length-1].val);
      let newLevelNodes = [];
      for (let parent of levelNodes) {
        if (parent.left !== null) {
          newLevelNodes.push(parent.left);
        }
        if (parent.right !== null) {
          newLevelNodes.push(parent.right)
        }
      }
      levelNodes = newLevelNodes;
    }
    return sideView;
};


/*
    1
   /
  2

https://leetcode.com/problems/binary-tree-right-side-view/

Given a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---  (-)
 /   \                 |
2     3         <---   |
 \                   / \
  5             <---
    
    
     1           
   /   \    
  2     3      
   \   /  \
    5 6     7   
     / \   /
    4   8 12
   / \
  9   10
  
levelNodes = [1]
level = 1
sideView = []


while levelNodes is not empty:
  // for every child in level nodes, append to new level
  sideView.append(levelNodes[-1])
  new_level_nodes = []
  for parent in levelNodes {
    if (parent.left != null) {
        new_level_nodes.append(child)
    }
    if (parent.right != null) {
        new_level_nodes.append(child)
    }
  }
      
  levelNodes = new_level_nodes
  level += 1

      
  
  
  
 
  

*/
