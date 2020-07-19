/*
Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

You may assume the array's length is at most 10,000.

Example:

Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
  
*/

/**
 * @param {number[]} nums
 * @return {number}
 */
var minMoves2 = function (nums) {
  if (nums.length <= 1) return 0;
  // get the median element and calculate the sum of distances of each element from the median
  // we will be using quick select, for get median in average O(N) time

  // find median, which is the kth smallest element in nums ie 
  // if nums in sorted order: nums[floor(l/2)] for odd numbers or (nums[l/2] + nums[l/2 - 1])/2 element
  let median = Math.floor(nums.length / 2);
  if (nums.length % 2 == 1) {
    median = getMedian(nums, median);
  } else {
    median = Math.floor((getMedian(nums, median) + getMedian(nums, median - 1)) / 2)
  }

  // get sum
  let min = 0;
  for (let i = 0; i < nums.length; i++) {
    min += Math.abs(nums[i] - median)
  }
  return min;
};

var getMedian = function (nums, k) {
  // O(N) average case
  let pivot = getPivot(nums);
  let arr = [...nums];
  while (arr.length > 1) {
    // get all numbers greater than pivot
    // get all numbers less than pivot
    // get all numbers equal to pivot
    let less = [], greater = [], pivots = [];
    for (let i = 0; i < arr.length; i++) {
      let cur = arr[i];
      if (cur < pivot) { less.push(cur); }
      else if (cur > pivot) { greater.push(cur); }
      else { pivots.push(cur); }
    }

    if (k < less.length) { // ie our median is somewhere in the less array
      pivot = getPivot(less);
      arr = less;
    } else if (k < less.length + pivots.length) { // ie our element is in the pivots arr, the value is pivot
      arr = [pivot];
      break;
    } else { // median is in the greater array
      pivot = getPivot(greater);
      arr = greater;
      k = k - less.length - pivots.length; // the kth element into the greater array, counting from the less array
    }
  }
  return arr[0];
}

var getPivot = function (arr) {
  return arr[Math.floor(Math.random() * arr.length)];
}

console.log(minMoves2([1, 0, 0, 8, 6]));