/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
  if (intervals.length <= 0) return [];
  
  // sort the intervals according to index 0;
  intervals.sort((a, b) => a[0]-b[0]);
  
  const merged = [intervals[0]];
  // keep track of current and next
  // loop through
  let end = merged.length - 1;
  for(let i = 0; i < intervals.length; i++) {
    if (merged[end][1] >= intervals[i][0]) {
      merged[end][1] = Math.max(intervals[i][1], merged[end][1]);
    } else {
      merged.push(intervals[i]);
    }
    end = merged.length - 1;
  }
  
  return merged; 
}




/*
Merge Interval: Medium

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [ [1, 3], [2, 6], [8, 10], [15, 18] ]
Output: [ [1, 6], [8, 10], [15, 18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


result = [[1, 6], [8, 10], [15, 18]]
current = [15, 18]
[ [1, 3], [8, 10], [15, 18], [2, 6]]
                                     n=3

intervals = [ [1, 9], [2, 5], [19, 20], [10, 11], [12, 20], [0, 1], [0, 3], [0, 2] ]
                                n = 3
                                
            [[0, 1], [0, 3], [0, 2], [1, 9], [2, 5], [10, 11], [12, 20], [19, 20]]
                                                                  i=0

merged = [[0, 9], [10, 11]]

merged = [[0, 9], [10, 11],  [12, 20]]
Array.sort((a, b) => {
return a[0]-b[0];
})
*/