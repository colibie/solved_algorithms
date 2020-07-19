/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
 let lo = 0;
 let hi = nums.length - 1;
 while (lo < hi) {
  let mid = lo + (hi-lo)/2;
  if (nums[mid] < nums[hi]) {
      hi = mid;
  } else {
      lo = mid+1;
  }
}
return nums[lo];
};


/*
Find Minimum in Rotated Sorted Array


Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
             
s            m         e
[4, 15, 20, -5, -3, 0, 3]   {s:0, m:3 e: 6}
 0   1   2   3   4  5  6      min = -5
 

 s         m           e
[-3, 0, 3, 4, 15, 20, -5]      {s:0, m:3 e: 6}
            [ 15, 20, -5]      {s:4, m:5 e: 6}  
                   [ -5]      {s:6, m:6 e: 6}
 
 s     m     e                                             
[3, 4, 5, 1, 2]           {s:0, m:2 e: 4}
        [ 1, 2]           {s:3, m:3 e: 4}


 s     m     e
[7,0,1,2,4,5,6] 


while (start < end)
right must greater
left must less

if the left and right is greater == min


s            m         e
[4, 15, 20, -5, -3, 0, 3]   {s:0, m:3 e: 6}
 0   1   2   3   4  5  6      
 
                  m
                  s    e
[-3, 0, 3, 4, 15, 20, -5]      {s:0, m:3 e: 6}
       

if mid greater than start and less than end // go left
if mid is less than start // go left
else (=> mid greater than or equal to start) // go right
    

          m 
          s
          e                                               
[3, 4, 5, 1, 2]           {s:0, m:2 e: 4}


[1, 2, 3, 4, 5, 6]


    m
    s  
    e
[7, 0, 1, 2, 4, 5, 6]   {s:0, m:0 e: 1} 

[7, 0, 1, 2]

[7, 0]
   [0]




*/
