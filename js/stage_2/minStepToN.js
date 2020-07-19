/**
 Initial 15 minutes resume and experience. Then, one technical question on coderpad:

Given an int n. You can use only 2 operations:

multiply by 2
integer division by 3 (e.g. 10 / 3 = 3)
Find the minimum number of steps required to generate n from 1.

Example 1:
Input: 10
Output: 6
Explanation: 1 * 2 * 2 * 2 * 2 / 3 * 2
6 steps required, as we have used 5 multiplications by 2, and one division by 3.


Example 2:

Input: 3
Output: 7
Explanation: 1 * 2 * 2 * 2 * 2 * 2 / 3 / 3
7 steps required, as we have used 5 multiplications by 2 and 2 divisions by 3
  
                                                  1                     val(10)
                                             *2 /    \ \3
                                              2       0 (F)
                                          *2 /  \ \3
                                           4     0 (F)
                                       *2 /  \ \3
                                         8    1 seen
                                     *2 / \ \3
                                      16   2 (seen)
                                  *2 /  \ \3 
                                    32   5
                                      *2 /
                                       10 (P)
                                       

oldLevel = [1]
seen = {}  // hash set
step = 0

while oldLevel not empty {
  newLevel = []
  // get the children
  for (child in oldLevel) {
    seen.put(child)
    if (child == target) {
      return step;
    }
    // append children if greater than zero and we have not seen it before
    // multiply 2
    
    let left = child * 2;
    if (left != seen and left is not zero) {
      left.push(newLevel)
    }
    let right = child \3;
    // divide by 3
    if (right is not seen and left is not zero)
  }
  step += 1
  oldLevel = newLevel  
}

*/

const minStepToN = function(target) {
  let oldLevel = [1];
  let seen = {};
  let step = 0;
  
  while (oldLevel.length > 0) {
    let newLevel = [];
    
    // get the children
    for(let parent of oldLevel) {
      seen[parent] = true;
      
      if (parent === target) {
        return step;
      }
      
      // left child
      let left = parent * 2;
      if (!(left in seen) && left > 0) {
        newLevel.push(left);
      }
      
      // right child
      let right = Math.floor(parent / 3);
      if(!(right in seen) && right > 0){
        newLevel.push(right);
      }
    }
    step += 1;
    oldLevel = newLevel;
  }
  return step;
}


const n = 3;
console.log(minStepToN(n));
