function countingSort(arr){
  let countArray = [];
  let res = [];
  // count frequency of occurence of each digit and store in countArray with +1 offset
  for (let i = 0; i < arr.length; i++) {
    if (countArray[arr[i] + 1] > 0) {
      countArray[arr[i] + 1] += 1;
    } else {
      countArray[arr[i] + 1] = 1;
    }
  }

  // sum the countArray
  for (let i = 0; i < countArray.length - 1; i++) {
    if (countArray[i] == undefined) countArray[i] = 0
    if (countArray[i+1] == undefined) countArray[i+1] = 0
    countArray[i+1] += countArray[i];
  }

  // assign the elements to the position specified by the count array
  for (let i = 0; i < arr.length; i++) {
    res[countArray[arr[i]]++] = arr[i];
  }
  console.log(res)
}

countingSort([1, 2, 3,4,5,4,3,1])