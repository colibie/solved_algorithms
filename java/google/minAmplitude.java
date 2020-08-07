package google;

import java.util.*;

class Main {
  /**
   * see line 18 for question
   * @param arr
   * @return
   */
  public static int minAmplitudeSort(int[] arr) {
    /** IDEA 1: sort to get mins and max  O(NlogN) */
    int N = arr.length;
    // we can easily change 3 elements to the 4th element
    if (arr == null || N <= 4)
      return 0;

    Arrays.sort(arr);

    int left = 0;
    int right = N - 4; // remove 3 max
    int amp = Integer.MAX_VALUE;
    // {-1, 3, -1, 8, 5, 4}; 
    //   0  1   2  3  4  5
    while (right < N) {
      amp = Math.min(amp, arr[right] - arr[left]);
      left++;  // remove a min value
      right++; // add back a max value
    }
    return amp;
  }

  public static int minAmplitudeTrack(int[] arr) {
    /** IDEA 1: loop through the array to get the 3 mins and 3 mins  O(N) */
    int N = arr.length;
    // we can easily change 3 elements to the 4th element
    if (arr == null || N <= 4)
      return 0;

    // sort the first four elements to get our first set of mins and max
    Arrays.sort(arr, 0, 4);

    // store the maxes
    int firstMax = arr[3], secondMax = arr[2], thirdMax = arr[1], fourthMax =
                                                                      arr[0];

    // store the mins
    int firstMin = arr[0], secondMin = arr[1], thirdMin = arr[2], fourthMin =
                                                                      arr[3];

    // loop through the array to check if you see a bigger num than the maxes
    // already seen
    for (int i = 3; i < N; i++) {
      int cur = arr[i];
      // if cur > any max, move the maxes around
      if (cur >= firstMax) {
        fourthMax = thirdMax;
        thirdMax = secondMax;
        secondMax = firstMax;
        firstMax = cur;
      } else if (cur >= secondMax) {
        fourthMax = thirdMax;
        thirdMax = secondMax;
        secondMax = cur;
      } else if (cur >= thirdMax) {
        fourthMax = thirdMax;
        thirdMax = cur;
      } else if (cur >= fourthMax) {
        fourthMax = cur;
      }
    }

    // loop through the array to check if you see a bigger num than the maxes
    // already seen
    for (int i = 3; i < N; i++) {
      int cur = arr[i];
      // if cur > any max, move the maxes around
      if (cur <= firstMin) {
        fourthMin = thirdMin;
        thirdMin = secondMin;
        secondMin = firstMin;
        firstMin = cur;
      } else if (cur <= secondMin) {
        fourthMin = thirdMin;
        thirdMin = secondMin;
        secondMin = cur;
      } else if (cur <= thirdMin) {
        fourthMin = thirdMin;
        thirdMin = cur;
      } else if (cur <= fourthMin) {
        fourthMin = cur;
      }
    }

    // find the min amplitudes between the maxes and mins seen, as elucidated in
    // line 74
    int amp = Integer.MAX_VALUE;
    //      1st | 2nd | 3rd | 4th
    // min = 1  |  2  |  3  |  4
    // max = 9  |  8  |  7  |  6

    // 1. change 1 min and 2 maxes
    // min = 2nd, 3rd, 4th
    // max = 3rd, 4th
    amp = Math.min(amp, thirdMax - secondMin);
    // 2. change 2 mins and 1 max
    // min = 3rd, 4th
    // max = 2nd, 3rd, 4th
    amp = Math.min(amp, secondMax - thirdMin);
    // 3. change 3 mins
    // min = 4th
    // max = 1st, 2nd, 3rd, 4th
    amp = Math.min(amp, firstMax - fourthMin);
    // 4. change 3 maxs
    // min = 1st, 2nd, 3rd, 4th
    // max = 4th
    amp = Math.min(amp, fourthMax - firstMin);

    return amp;
  }

  static public void main(String args[]) {
    int[] input = {-1, 3, -1, 8, 5, 4}; // output: 2
    int[] input1 = {10, 10, 3, 4}; // output: 0

    System.out.println(Main.minAmplitudeSort(input));
    System.out.println(Main.minAmplitudeSort(input1));

    System.out.println(Main.minAmplitudeTrack(input));
    System.out.println(Main.minAmplitudeTrack(input1));
  }
}

/*
Question 1:
Given an Array A, find the minimum amplitude you can get after changing up to 3
elements.
Amplitude is the range of the array (basically difference between largest and
smallest element).

Example 1:

Input: [-1, 3, -1, 8, 5 4]
Output: 2
Explanation: we can change -1, -1, 8 to 3, 4 or 5

Example 2:

Input: [10, 10, 3, 4, 10]
Output: 0
Explanation: change 3 and 4 to 10

We can only change the min to the next min or the max to the next max.
we have 4 options
1. change 1 min and 2 maxes
2. change 2 mins and 1 max
3. change 3 mins
4. change 3 maxs

this shows we need to know the first 3 min and first 3 max;
// we can sort the array to find this O(NlogN)
// we can loop through the array and keep track of the top 3 mins and top 3
maxes seen
*/