function migratoryBirds(arr) {
  let count = {}, compare = 0, mostFrequent = 0;
  for (let i = 0; i < arr.length; i++){
      if (count[arr[i]]) {
          count[arr[i]] = count[arr[i]] + 1;
          console.log(count)
          if (compare < count[arr[i]]){
              compare = count[arr[i]];
              mostFrequent = arr[i];
          }
      }
      else {
          count[arr[i]] = 1;
          console.log(count)
          if (compare < count[arr[i]]){
            compare = count[arr[i]];
            mostFrequent = arr[i];
        }    
      }
  }
  return mostFrequent;
}

console.log(migratoryBirds([1,1,2,2,3,3]))