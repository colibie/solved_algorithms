/**
 * Given a start word, an end word and a dictionary of words
 * find the length of the shortest transformation from the start word to end word
 * such that
 * 1. Each word is transformed to the next word by a change in just one letter
 * 2. Each word transformed to, must be in the dictionary
 * eg, the sample given below maybe transformed as follows:
 * hit -> hot -> lot -> log -> cog
 * giving transformation length as 5.
 */

//function to check if two words are adjacent
function isAdjacent(word1, word2){
  let count = 0;
  for (let i = 0; i<word1.length; i++){
    if (word1[i] !== word2[i]) count++;
    if (count > 1) return false;
  }
  return (count == 1) ? true: false; 
}

//bfs
function shortestTransform (begin, end, dict){
  let count = 1;
  let queue = [begin]; 

  let seen = {};

  while(queue.length > 0){
    let level = [];

    // for each word in the queue
    for (let i = 0; i < queue.length; i++) {
      let curItem = queue[i];

      if (queue[i] == end){
        return count;
      }

      // add their children only if we've not seen that word before
      // this is inefficient because you are checking each word in dict
      // check variations of the current word and see if it exists in dict(convert dict to obj for o(1) search)
      // SEE WORD LADDER JAVA IMPLEMENTATION
      for(let j = 0; j < dict.length; j++){
        if (isAdjacent(curItem, dict[j]) && !seen[dict[j]]){
          seen[dict[j]] = true;
          level.push(dict[j]);
        }
      }
    }
    queue = level;
    count++;
  }
  return 0;
}

let start = 'hit', end = 'cog', dict = ['hot','dot','dog','lot','log', 'cog'];
// let start = 'a', end = 'c', dict = ['a','b','c'];

console.log(shortestTransform(start,end, dict))