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
 * @return {boolean}
 */
const isValidBST = function(root) {
  const ordered = [];
  visit(root, ordered);

  for(let i = 1; i < ordered.length; i++) {
    if(ordered[i] <= ordered[i-1]){
      return false;
    }
  }
  return true;
};

const visit = function(root, ordered) {
if (root == null) return;
visit(root.left, ordered);
ordered.push(root.val);
visit(root.right, ordered)
}

const isValidBST = function(root, minimum=null, maximum=null) {
  if (root == null){
     return true;
  }
  
  if (minimum != null && root.val <= minimum.val){
      return false
  }
                      
  if (maximum != null && root.val >= maximum.val){
    return false
  }
                                 
  return isValidBST(root.left, minimum, root) && isValidBST(root.right, root, maximum)

}   