let start = 'hit', end = 'cog';
let dict = ['hot','dot','dog','lot','log', 'cog'];

//function to check if two words are adjacent
function isAdjacent(word1, word2){
  let count = 0;
  for (let i = 0; i<word1.length; i++){
    if (word1[i] !== word2[i]) count++;
    if (count > 1) return false;
  }
  return (count == 1) ? true: false; 
}

//dfs
function shortestTransform(begin, end, dict){
  let item = {word: begin, len: 0};
  let queue = [item];
  while(queue.length > 0){
    let curItem = queue.pop();
    
    for( let i = 0; i<dict.length; i++){
      if (isAdjacent(curItem.word, dict[i])){
        item.word = dict[i];
        item.len = curItem.len + 1;
        queue.push(item);

        if (dict[i] == end){
          return item.len;
        }
        //delete ajacent word so as to not search again
        dict.splice(i, 1);
      }
    }
  }
  return 0;
}
console.log(shortestTransform(start,end, dict))

/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    
};

/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest 
transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time.
    Each transformed word must exist in the word list.

Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

transformable(word1, word2) {
  for each letter in word1:
    if it is not equal to word2
      return false
  return true
}

                                                  hit
                                              /         \
                                          hot             hit
                                      /         \
                                   dot          hot
                              /        \
                            dog        dot

*/

