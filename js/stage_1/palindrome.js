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