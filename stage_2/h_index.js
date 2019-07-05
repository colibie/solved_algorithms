/**Given a list of publications, find the publishers h-index
 * Please google what h-index means if you're confused
*/

function hIndex(arr){
  arr = arr.sort((a, b) => b-a);
  console.log(arr)
  for (let i = 0; i<arr.length; i++){
    if (i+1 === arr[i] ) return i+1;
  }
}
//console.log(hIndex([8,10,5,3,4]));