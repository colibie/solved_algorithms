package google;
/**
Write a function that given a zero-indexed array of length N,
returns the largest contiguous subarray of length K.
Eg:
Input: [1, 4, 3, 2, 5] k = 4
Output; [4, 3, 2, 5], largest subarray of length 4
1 <= k <=N <= 100
1 <= a[j] <= 1000;
assume the elements are all unique;

FOLLOW-UP: What if the elements aren't unique?
*/
public class largestSubArray {
  /**
   * Here, we are told the elements are unique
   * @param arr
   * @return Integer[]
   */
  public static int[] solve(int[] arr, int k) {
    // simply find the index of the largest element that allows for subarray of
    // K
    // there cant be a subarray of length k if the arr length is less than k
    int N = arr.length;
    if (arr == null || N < k)
      return null;

    if (N == k)
      return arr;

    int[] res = new int[k];
    int minIndex = 0;

    for (int i = 1; i <= N - k; ++i) {
      if (arr[minIndex] < arr[i])
        minIndex = i;
    }
    System.arraycopy(arr, minIndex, res, 0, k);

    return res;
  }

  /**
   *
   * @param arr
   * @param k
   * @return
   */
  public static int[] solveNotUnique(int[] arr, int k) {
    // there cant be a subarray of length k if the arr length is less than k
    int N = arr.length;
    if (arr == null || N < k)
      return null;

    if (N == k)
      return arr;

    int[] res = new int[k];
    int minIndex = 0;

    for (int i = 1; i <= N - k; ++i) {
      // compare the k elements
      for (int j = 0; j < k; ++j) {
        if (arr[minIndex + j] > arr[i + j])
          break;
        if (arr[minIndex + j] < arr[i + j]) {
          minIndex = i;
          break;
        }
        // if equal continue comparing
      }
    }
    System.arraycopy(arr, minIndex, res, 0, k);

    return res;
  }
}
/**
Write a function that given a zero-indexed array of length N,
returns the largest contiguous subarray of length K.
Eg:
Input: [1, 4, 3, 2, 5] k = 4
Output; [4, 3, 2, 5], largest subarray of length 4
1 <= k <=N <= 100
1 <= a[j] <= 1000; distinct

Compare the first non-matching index values, the one with the greater value is
the bigger array

Input: [1, 4, 3, 2, 5] k = 4
Output; [4, 3, 2, 5], largest subarray of length 4
1 <= k <=N <= 100
1 <= a[j] <= 1000; distinct

=> if len < k || arr == null return null;
=> if the arr.len = k, return System.copy(arr, 0, res, 0, 4) // copy the arry
0   1   2  3  4  5
[1, 4, 3, 2, 5, 6] minIdx = 1
         ^
SOLUTION
# find the max element in the array, from 0 to N - k
# return the k elements starting from there

Public int[] largestSubarray(int[] arr, int k) {
  // there cant be a subarray of length k if the arr length is less than k
  Int N = arr.length;
  If (arr == null || N < k) return null;

  If (N == k) {
    Return arr;
  }
  Int res = new int[k];
  Int minIndex = 0;
  For (int i = 1; i <= N - k; ++i) {
    If (arr[minIndex] < arr[i]) minIndex = i;
  }
  System.arraycopy(arr, minIndex, res, 0, k);
  Return res;
}

FOLLOW-UP: What if the elements were not unique?
Int[] idxs=[0, 2]
         x=2 i=1
[4, 2, 4, 1, 5, 6]
         ^
// loop through k times,
// compare the indexes and keep track of the array idx with max value
     i=1
[4, 2, 4, 1]
[4, 1, 5, 6]

 */