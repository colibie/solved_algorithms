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
console.log(targetFunction(nums, target));
//output = [1, 3]

//OR
//I think this is less space complex
function getTarget(nums, target){
  for (let i = 0; i<nums.length-1; i++){
    for (let j = nums.length - 1; j>i; j--){
      if((nums[i]+nums[j] === target)) return [i, j];
    }
  }
  return 'none'
}
console.log(getTarget(nums, target));