/**
 * Returns an array of anagrams contained in a given array, of a query word 
 * @param {String} word a query word
 * @param {Array} arr an array of strings to check for anagrams
 */
function anagram(word, arr) {
  let res = [];
  word = word.split("").sort();

  arr.forEach(el => {
    if (word.length != el.length) { return; }
    if (word.join("") === (el.split("").sort().join(""))) res.push(el);
  })
  return res;
}

console.log(anagram('abba', ['bbaa', 'abab', 'abcd', 'aaaa']));