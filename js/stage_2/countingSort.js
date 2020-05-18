function countingSort(arr){
  let max = Math.max(...arr);
  let countArray = Array(max+1).fill(0);
  arr.forEach(element => {
    countArray[element] += 1;
  });
  console.log(countArray)
}

countingSort([1, 2, 3,4,5,4,3,1])