// Given an array, reverse it's content 
// without creating another array

function reverseInPlace(arr){
  for(let i = arr.length - 1; i>0; i--){
    let el = arr.shift();
    arr.splice(i, 0, el);
  }
  return arr;
}
console.log(reverseInPlace([1,2,3,4,5]));