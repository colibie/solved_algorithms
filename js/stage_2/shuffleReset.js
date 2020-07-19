/**
 * @param {number[]} nums
 */
var Solution = function(nums) {
  this.orig = [...nums];
  this.nums = nums;
  this.randAll = [];
};

/**
* Resets the array to its original configuration and return it.
* @return {number[]}
*/
Solution.prototype.reset = function() {
  // console.log("// Calling Reset...");
  // console.log("Shuffled: " + this.nums);
  // console.log("Original: " + this.orig);
  return this.orig;
};

/**
* Returns a random shuffling of the array.
* @return {number[]}
*/
Solution.prototype.shuffle = function() {
  for(let i=0; i < this.nums.length; i++){
    let randIdx = Math.floor(Math.random() * this.nums.length);
    this.randAll.push(randIdx);
    let randNum = this.nums[randIdx];
    let currNum = this.nums[i];
    this.nums[i] = randNum;
    this.nums[randIdx] = currNum;
  }
  // console.log("// Calling Shuffle...")
  // console.log("Original: " + this.orig);
  // console.log("Shuffled: " + this.nums);
  // console.log("\n");
  return this.nums
};

const nums = [1, 2, 3]
var obj = new Solution(nums)
var param_2 = obj.shuffle()
var param_1 = obj.reset()


/** 
* Your Solution object will be instantiated and called as such:
* var obj = new Solution(nums)
* var param_1 = obj.reset()
* var param_2 = obj.shuffle()
*/




/*

Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result.
Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();



// shuffle
r = [0, 3]
random_values = [3, 3, 2, 0];

[1, 5, 9, 4]
i=0
[4, 5, 9, 1]   r = 3
  i=1
[4, 1, 9, 5]   r = 3
     i=2
[4, 1, 9, 5]   r = 2
        i=3
[5, 1, 9, 4]   r = 0

// reset
[5, 1, 9, 4]
               0  1  2  3
random_values = [3, 3, 2, 0];

[4, 1, 9, 5]

[4, 5, 9, 1]

[1, 5, 9, 4]

(4/2)(4+1) 10

[1, 2, 3, 4]

[1, 3, 2, 4]
[1, 3, 4, 2]
[1, 4, 3, 2]
[1, 4, 2, 3]
[1, 2, 4, 3]
...
[]
[]
[]


4!

*/