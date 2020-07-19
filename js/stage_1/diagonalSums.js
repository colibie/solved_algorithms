/**
 * Returns the absolute difference of the left and right diagonal sum of a 2D array
 * @param {Array} param 
 */
function diagonalSums(param) {
  const n = param.length;
  // to help immutability, copy arr out
  const arr = [...param];
  // right diagonal
  let i = 0, ltrSum = 0;
  while (i < arr.length) {
    ltrSum += arr[i][i]
    i++;
  }

  // left diagonal
  let j = 0, k = n - 1, rtlSum = 0;
  while (j < n && k >= 0) {
    rtlSum += arr[j][k];
    j++; k--;
  }

  return Math.abs(ltrSum - rtlSum);

}

console.log(diagonalSums([[-10, 3, 0, 5, 4], 
                          [2, -1, 0, 2, -8], 
                          [9, -2, -5, 6, 0], 
                          [9, -7, 4, 8, -2], 
                          [3, 7, 8, -5, 0]]));