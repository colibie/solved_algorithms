/**You are given an unordered array consisting of consecutive integers [1, 2, 3, ..., n] 
 * without any duplicates. You are allowed to swap any two elements. 
 * You need to find the minimum number of swaps required to sort the array in ascending order. */

 function minimumSwaps(arr) {
   let temp, pos = {}, count = 0;

   // create hash  to store initial conditions // o(n)
   for (let i = 0; i < arr.length; i++) {
     pos[arr[i]] = i;     
   }

   for (let i = 0; i < arr.length - 1; i++) {
      if (arr[i] === i+1) continue;
      // swap
      temp = arr[i];
      arr[i] = i + 1;
      arr[pos[i+1]] = temp;

      // update position
      pos[temp] = pos[i+1]
      ++count;
   }
   return count;
 }

console.log(minimumSwaps([7, 1, 3, 2, 4, 5 ,6]));
console.log(minimumSwaps([4, 3, 1, 2]));
console.log(minimumSwaps([1, 3, 5, 2, 4, 6, 7]));
