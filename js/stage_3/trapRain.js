/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    
}

/*

Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.
Thanks Marcos for contributing this image!

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6


minimum of maximum height of bars on both the sides minus its own height.

     4|
     3|               ___
     2|       ___     | |__ ___
     1|  ___  | |__ __| | |_| |__
      |__|_|__|_|_|_|_|_|_|_|_|_|
      0  1 2  3 4 5 6 7 8 9 10 11 12
      
      
      [ 0,  1,  0,  2,  1,  0,  1,  3,  2,  1,  2,  1]
      
      [ 0,  ]
      




*/