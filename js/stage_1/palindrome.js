/**
 * Given a string, check how many palindromes it has.
 * A palindrome is a value which is same when reversed, eg mum, 1001
 * The substrings with different start indexes or end indexes are 
 * counted as different substrings even they consist of same characters.
 * 
 * Eg: Given:
 * Input: 'aaa'; 
 * Output: 6 ie 'a', 'a', 'a', 'aa', 'aa', 'aaa' ;
 */

function palindrome(str){
  let count = 0
  for(let i = 0; i<str.length; i++){
    for(let j = 1; j<=str.length; j++){
      if (i < j){
        let value = str.substring(i, j);
        if (value.length && isPalindrome(value)) {
          count++;
        }
      }
    }      
  }
  return count;
}

function isPalindrome(value){
  let rev = '';
  for (let el of value){
    rev = el + rev;
  }
  return (rev == value) ? true: false;
}

console.log(palindrome('aa'));

/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
  if (x < 0) return false;
  if (x < 10) return true;

  // 12321
  // 10
  let old_x = x;
  let new_x = 0; 
  let i = 0; 
  while (x > 0) {
    let rem = x % 10;
    x = Math.floor(x / 10);    
    new_x = new_x * 10 + rem   
    i++;
  }
  return new_x === old_x;
};


/*
Determine whether an integer is a palindrome.
An integer is a palindrome when it reads the same backward as forward.

Example 1:
  Input: 121
  Output: true

Example 2:
  Input: -121
  Output: false
  Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
              Therefore it is not a palindrome.

Example 3:
  Input: 10
  Output: false
  Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Follow up:
  Coud you solve it without converting the integer to a string?
  
 
if -ve return false
if less than 10 return true


6
696 % 10 = 6      nums =  [6, 9, 6] res = 6 + 90 + 600 = 696
696 / 10 = 69
6 * 10 ^ 0 = 6

69 % 10 = 9
69 / 10 = 6
9 * 10 ^ 2 = 90

6 % 10 = 6
6 * 10 ^ 3 = 600
6 / 10 = 0  STOP

end = nums.length - 1
for i to nums.length:
  if nums[i] != nums[end]
    return False
  end--;
return True



121 -->

121 % 10 = 1
121 / 10 = 12

12 % 10 = 2
12 / 10 = 1

1 % 10 = 1
1 / 10 = 0  STOP


756 -->

756 % 10 = 6
756 / 10 = 75

75 % 10 = 5
75 / 10 = 7

7 % 10 = 7
7 / 10 = 0 STOP


*/
