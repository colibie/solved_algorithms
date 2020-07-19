/**
 * Given a 2D boolean array, find thr largest square subarray of true values.
 * The return value should be the side length of the largest square subarray.
 * 
 * Eg
 * arr = 
 * ________________________________
 * | False | True | False | False |
 * --------________________---------
 * | True  ||True | True || True |
 * --------------------------------
 * | False ||True | True || False |
 * --------________________--------
 * squareSubmatrix(arr) = 2, ie cells (1, 1) to (1, 2), (2, 1), (2, 2)
 */

function squareSubmatrix(arr) {
  // Brute force would be doing a DFS, while keeping count of max seen so far
  // Using DP, what are the subproblems
  // for each cell, we check if it's left, bottom and bottom-right is the start of a truthy square matrix, ie at the top left
  // if it is, we return the min of the square matrix(all edges must be valid) + the current cell(1)

  let max = 0, cache = [];
  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr.length; j++) {
      // if valid
      if (!arr[i][j]) continue;
      max = Math.max(max, squareSubmatrixHelper(arr, i, j));
      //  max = Math.max(max, squareSubmatrixHelper(arr, i, j, cache)); //dp top down
    }
  }
  return max;
}

function squareSubmatrixHelper(arr, i, j) {
  // if it's the end
  if (i >= arr.length || j >= arr[0].length) return 0;

  // return 0 if cell is false;
  if (!arr[i][j]) return 0;

  // Why min? If any of the adjacent cells are false, 
  // then the current cell is not the start of a larger squareMatrix
  // and thus the size is 1;
  return 1 + Math.min(/*Left*/  squareSubmatrixHelper(arr, i, j + 1),
                      /*Bottom*/ squareSubmatrixHelper(arr, i + 1, j),
                      /*Bottom-Right*/ squareSubmatrixHelper(arr, i + 1, j + 1));
}

function squareSubmatrixHelperTopDown(arr, i, j, cache) {
  // if it's the end
  if (i >= arr.length || j >= arr[0].length) return 0;

  // return 0 if cell is false;
  if (!arr[i][j]) return 0;

  if (cache[i][j]) return cache[i][j];
  // Why min? If any of the adjacent cells are false, 
  // then the current cell is not the start of a larger squareMatrix
  // and thus the size is 1;
  cache[i][j] = 1 + Math.min(/*Left*/  squareSubmatrixHelperTopDown(arr, i, j + 1),
                     /*Bottom*/ squareSubmatrixHelperTopDown(arr, i + 1, j),
                     /*Bottom-Right*/ squareSubmatrixHelperTopDown(arr, i + 1, j + 1));
  return cache[i][j];
}

function squareSubMatrixBottomUp(arr) {
  // we check if a cell if the bottom right corner of a bigger left-ward square submatrix
  let cache = [], max = 0;
  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr.length; j++) {
      // if we are the first row or col, the value is just 1 if the cell is truth
      if (i == 0 || j == 0) {
        cache[i][j] = arr[i][j] ? 1 : 0;
      } else if (arr[i][j]) {
        cache[i][j] = 1 + Math.min(cache[i - 1][j], cache[i][j - 1], cache[i - 1][j - 1]);
      } else {
        cache[i][j] = 0;
      }
    }
    max = Math.max(max, cache[i][j]);
  }
  return max;

}