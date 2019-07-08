/**
 * Compares two strings and count how many letters in the first string
 * are in the second string
 * 
 * @param {*} stringA The string to compare
 * @param {*} stringB The string to be compared with
 */

const J = "aA";
const S = "aAAbbbb";

function mine(stringA, stringB){
  stringA = stringA.toString();
  stringB = stringB.toString();
  let count = 0;
  for (let letter of stringA){
    for (let char of stringB){
      if (letter == char){
        count++;
      }
    }
  }
  return count;
}

console.log(mine(J, S));