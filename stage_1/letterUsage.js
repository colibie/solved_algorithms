/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
We define the usage of capitals in a word to be right when one of the following cases holds:
1.	All letters in this word are capitals, like "USA".
2.	All letters in this word are not capitals, like "leetcode".
3.	Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
 * @param {*} str
 * 
 */
function letterUsage(str){
  let sentenceCase = str[0].toUpperCase() + str.slice(1, str.length).toLowerCase();
  if ((str.toUpperCase() === str) ||
    (str.toLowerCase() === str) ||
    (sentenceCase === str)){
      return true;
    }
  return false;
}

console.log(letterUsage('GoaH'));