/**
 * @param {string} s
 * @return {string[]}
 */
var removeInvalidParentheses = function(s) {
    
};


/*
Remove Invalid Parentheses

Remove the minimum number of invalid parentheses in order to make the input string valid.
Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]

 0 1 2 3 4 5 6
"( ) ( ) ) ( )" 4 makes it invalid, 1 makes it invalid


()())(()

https://leetcode.com/problems/remove-invalid-parentheses/



The idea is straightforward, with the input string s,
we generate all possible states by removing one ( or ),
check if they are valid, if found valid ones on the current level,
put them to the final result list and we are done,
otherwise, add them to a queue and carry on to the next level.

Example 1:

 0 1 2 3 4 5 6 
 ( ) ( ) ) ( )

remove 0
 1 2 3 4 5 6 
 ) ( ) ) ( ) false

remove 1
 0 2 3 4 5 6 
 ( ( ) ) ( ) true
 
remove 2
 0 1 3 4 5 6 
 ( ) ) ) ( ) false
 
remove 3
 0 1 2 4 5 6 
 ( ) ( ) ( ) true
 
remove 4
 0 1 2 3 5 6 
 ( ) ( ) ( ) true but duplicate (remove 3)
 
remove 5
 0 1 2 3 4 6 
 ( ) ( ) ) ) false

remove 6
 0 1 2 3 4 5
 ( ) ( ) ) ( false


Example:

0 1 2 3 4 5 6 7
( ) ( ) ) ( ( )

Level 1 removal:
remove 0
 1 2 3 4 5 6 7
 ) ( ) ) ( ( )
 
  remove 1
    2 3 4 5 6 7
    ( ) ) ( ( ) false

  remove 2
     1 3 4 5 6 7
     ) ) ) ( ( ) false

  remove 3
     1 2 4 5 6 7
     ) ( ) ( ( ) false

   remove 4
   1 2 3 5 6 7
   ) ( ) ( ( ) false

   remove 5
   1 2 3 4 6 7
   ) ( ) ) ( ) false

   remove 6
   1 2 3 4 5 7
   ) ( ) ) ( ) false

  remove 7
   1 2 3 4 5 6
   ) ( ) ) ( ( false


remove 1
  0 2 3 4 5 6 7
  ( ( ) ) ( ( )
  
  remove 0
    2 3 4 5 6 7
    ( ) ) ( ( ) false
  
  remove 2
    0 3 4 5 6 7
    ( ) ) ( ( ) false
  
  remove 3
    0 2 4 5 6 7
    ( ( ) ( ( ) false
    
  remove 4
    0 2 3 5 6 7
    ( ( ) ( ( ) false
  
  remove 5
    0 2 3 4 6 7
    ( ( ) ) ( ) true
    
  remove 6
    0 2 3 4 5 7
    ( ( ) ) ( ) true (duplicate remove 5)
   
  remove 7
    0 2 3 4 5 6
    ( ( ) ) ( ( false
   

remove 2
 0 1 3 4 5 6 7
 ( ) ) ) ( ( )
 
  remove 0 ->  Level 2
    1 3 4 5 6 7
    ) ) ) ( ( ) false
   
  remove 1
   0 3 4 5 6 7
   ( ) ) ( ( ) false
  
  remove 3
   0 1 4 5 6 7
   ( ) ) ( ( ) false
  
  remove 4
   0 1 3 5 6 7
   ( ) ) ( ( ) false
   
  remove 5
   0 1 3 4 6 7
   ( ) ) ) ( ) false
   
  remove 6
   0 1 3 4 5 7
   ( ) ) ) ( ) false
   
  remove 7
   0 1 3 4 5 6
   ( ) ) ) ( ( false
  
  

remove 3
 0 1 2 4 5 6 7
 ( ) ( ) ( ( )
 
  remove 0
  1 2 4 5 6 7
  ) ( ) ( ( ) false

  remove 1
  0 2 4 5 6 7
  ( ( ) ( ( ) false

  remove 2
  0 1 4 5 6 7
  ( ) ) ( ( ) false

  remove 4
  0 1 2 5 6 7
  ( ) ( ( ( ) false

  remove 5
  0 1 2 4 6 7
  ( ) ( ) ( ) true

  remove 6
  0 1 2 4 5 7
  ( ) ( ) ( ) true (duplicate remove(5))

  remove 7
  0 1 2 4 5 6
  ( ) ( ) ( ( false



Do for the rest.
remove 4
  0 1 2 3 5 6 7
  ( ) ( ) ( ( )

remove 5
  0 1 2 3 4 6 7
  ( ) ( ) ) ( )

remove 6
  0 1 2 3 4 5 7
  ( ) ( ) ) ( )

remove 7
  0 1 2 3 4 5 6 
  ( ) ( ) ) ( (