package medium;
/**
 * Array of Array Products

 * Given an array of integers arr, you’re asked to calculate for each index i the product of all integers except the integer at that index (i.e. except arr[i]). Implement a function arrayOfArrayProducts that takes an array of integers and returns an array of the products.

 * Solve without using division and analyze your solution’s time and space complexities.

 * Examples:

 * input:  arr = [8, 10, 2]
 * output: [20, 16, 80] # by calculating: [10*2, 8*2, 8*10]

 * input:  arr = [2, 7, 3, 4]
 * output: [84, 24, 56, 42] # by calculating: [7*3*4, 2*3*4, 2*7*4, 2*7*3]

 */

public class ArrayProduct {
  public static int[] arrayProduct(int[] arr) {
    int N = arr.length;
    int[] leftThenRight = new int[N];

    // find all left product
    int runningProduct = 1;
    for (int i = 0; i < N; i++) {
      leftThenRight[i] = runningProduct;
      runningProduct = runningProduct * arr[i];
    }

    // multiply with right product
    runningProduct = 1;
    for (int i = N - 1; i >= 0; i++) {
      leftThenRight[i] = leftThenRight[i] * runningProduct;
      runningProduct = runningProduct * arr[i];
    }
  }

  return leftThenRight;
}