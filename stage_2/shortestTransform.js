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
function shortestTransform (begin, end, dict){
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

// This below was the first draft..Contains a couple of errors
// DFIS i think :)
function shortestLinearTransform (begin, end, dict){
  let item = {word: begin, len: 0};

  for( let i = 0; i<dict.length; i++){
    if (isAdjacent(item.word, dict[i])){
      item.word = dict[i];
      item.len++;

      if (dict[i] == end){
        return item.len;
      }
      // //delete ajacent word so as to not search again
      // dict.splice(i, 1);
    }
  }
  return 0;
}