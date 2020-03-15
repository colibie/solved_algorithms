//Given a range of values inclusive,
//find the reuslt of their bitwise And

function bitwiseAnd(arr){
  let and = arr[0], i = and++;
  while( i <= arr[arr.length-1]){
    and &= i;
    i++
  }
  return and;
}
// console.log(bitwiseAnd([5,7]));
// console.log(bitwiseAnd([0,1]));