function fourNumberSum(array, targetSum) {
    // Write your code here.
      let allPairSums = {};
      let quadruplets = []
      for (let i = 1; i < array.length - 1; i++){
          // go forward and check if it exists
          for (let j = i; j < array.length; j++){
              let sum = array[i] + array[j];
              let diff = targetSum - sum;
              if (allPairSums[diff]){
                  for (let pair of allPairSums[diff]){
                      quadruplets.push(pair.concat([array[i], array[j]]))
                  }
              }
          }
          //go backward and add to hashtable
          for (let k = i - 1; k > 0; k--){
              let sum = array[i] + array[k];
              if (allPairSums[sum]){
                  allPairSums[sum].push([array[i], array[k]])
              }else {
                  allPairSums[sum] = [[array[i], array[k]]]
              }
          }
      }
  }