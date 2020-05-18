/**
 * Given an array, find the index of two digits that sum
 * up to a given target. Provided that
 * 1. the numbers are not repeated
 * 2. you cant sum same number twice
 * For eg
 */

const nums = [2, 7, 11, 15];
const target = 22;

const targetFunction = (nums, target) => {
  for (let i = 0; i < nums.length - 1; i++){
    for (let j = 1; j < nums.length; j++){
      let sum = nums[i] + nums[j];
      if (sum === target) return [i, j];
    }
  }
}
// console.log(targetFunction(nums, target));
//output = [1, 3]

//OR
//I think this is less space complex

// Lol, It's not babe
function getTarget(nums, target){
  for (let i = 0; i<nums.length-1; i++){
    for (let j = nums.length - 1; j>i; j--){
      if((nums[i]+nums[j] === target)) return [i, j];
    }
  }
  return 'none'
}
// console.log(getTarget(nums, target));

// See this. Using Hash Tables

function getTarget2(array, target){
  let nums = {};
  for(let num in array){
    let secondNum = target - array[num];
    if ( nums[secondNum] ) return [num, nums[secondNum]]
    nums[array[num]] = num;
  }
  return 'none'
}

// console.log(getTarget2(nums, target));

// Or using pointers
// sort in ascending order
// start sum from the utmost left and utmost right, if sum < target, move the left forward
// else move the right backward 

function getTarget3(array, target){
  const sortedArray = array.sort((a, b) => a - b)
    let left = 0;
    let right = array.length - 1;
    while (left < right){
      let cS = sortedArray[left] + sortedArray[right];
      if ( cS === target ) return [left, right]
      else if (cS < target) left++;
      else if (cS > target) right--;
    }
    return 'none'
  }

console.log(getTarget3(nums, target));


