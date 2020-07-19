/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
  let max = 0;
  let start = 0
  let already_visited = {}
  for (let e = 0; e < s.length; e++) {
    if (s[e] in already_visited && start <= already_visited[s[e]]) {
     start = already_visited[s[e]] + 1;
    }
    already_visited[s[e]] = e;  
    max = Math.max(max, e - start + 1);
  }

  return max; 
};



/*
Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Example 1:
        01234567
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


let max = 0;
start = 0
let already_visited = {}
for (let e = 0; e < s.length; e++) {
  if (already_visited[s[e]] && start <= already_visited[e]) {
   start = already_visted[s[e]] + 1;
  }
  already_visited[s[e]] = e;  
  max = Math.max(max, start - end + 1);
}

return max;


{a:4, b:1, c:5} 
              s=4
  
  a  b  c  a  a  c  b  d
                    e=6
        
        
  max = e - s + 1 = 3


*/