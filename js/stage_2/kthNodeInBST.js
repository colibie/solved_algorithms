
function TreeNode(val, left, right) {
  this.val = (val===undefined ? 0 : val)
  this.left = (left===undefined ? null : left)
 this.right = (right===undefined ? null : right)
}

/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
function kthLargest(root, k) {
    this.res = root.val;
    this.count = 0;
    this.root = root;
};

kthLargest.prototype.modifyKthLargest = function (root) {
  if (root == null) return;

  // go to the right
  this.modifyKthLargest(root.right);
  
  // count node as seen
  this.count++;
  
  // return if node is greater than k
  if (this.count >= k) {
    if (this.count == k) this.res = root.val;
    return;
  }
  
  // go to the left
  this.modifyKthLargest(root.left);
}

kthLargest.prototype.getKth = function() { 
  this.modifyKthLargest(this.root);
  return this.res; 
}


const getTree = () => {
  /*
          7           
        /    \
       3      15 
      / \    /  \
     2   5  10   20 
    /   /  / \   / \
   1   4  8  12 18  22
  */
  const nodeVals = [8, 12, 18, 22, 10, 20, 1, 4, 2, 5, 3, 7, 15]
  const root = new TreeNode(nodeVals[0])
  for(let i=1; i < nodeVals.length; i++){
    let currNode = new TreeNode(nodeVals[i]);
    insertToTree(root, currNode);
  }
  return root;
}

const insertToTree = (root, node) => {
  if (node.val <= root.val) {
    if (root.left === null) {
      root.left = node;
      return
    }
    insertToTree(root.left, node);
  } 
  else {
    if (root.right === null){
      root.right = node;
      return
    }
    insertToTree(root.right, node);
  }
}

const root = getTree();
const k = 10;
const kth = new kthLargest(root, k);
console.log(kth.getKth());



/*

Given a binary search tree, write a function to find the kth largest element in it.

Example 1:
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 4


Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 4


Follow up:

What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
How would you optimize the kthSmallest routine?


Constraints:

The number of elements of the BST is between 1 to 10^4.
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

#### SOLUTION:

METHOD 1:
Traverse the tree, inorder, then print the n - kth element

Inorder  - left ROOT right
Preorder - ROOT left right
Postorder- left right ROOT

METHOD 2:
O()

res;
count;
                        7           
                      /    \
                     3      15 
                    / \    /  \
                   2   5  10   20 
                  /   /  / \   / \
                 1   4  8  12 18  22
                            null

If node == null return;
check(node.right)
count +=1                          count=6 
if count >= k {
  if count == k res = node; 
  return 
}
check(node.left)
return 

   3 
  / \
 1   4 count = 1           if count = k, res = 4, return
  \                         
   2
   
   k = 6, value=10
*/