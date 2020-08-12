package google;

/* 
https://leetcode.com/discuss/interview-question/352458/
SEE QUESTION ON LINE 71 
*/

import java.util.*;

public class CompareStrings {
  public static int[] compare(final String A, final String B) {
    if (A.length() < 1 || B.length() < 1)
      return new int[0];

    final String[] A_arr = A.split(" ");
    final String[] B_arr = B.split(" ");
    final int[] C_arr = new int[B_arr.length];

    final int[] A_help = new int[A_arr.length];
    // O(M)
    for (int j = 0; j < A_arr.length; j++) {
      A_help[j] = getMin(A_arr[j]);
    }
    // O(NM)
    // A = "abcd aabc bd"
    // B = "aaa aa"

    for (int i = 0; i < B_arr.length; i++) {
      int count = 0;
      final int b_min = getMin(B_arr[i]);

      for (int j = 0; j < A_help.length; j++) {
        if (A_help[j] < b_min) {
          count += 1;
        }
      }

      C_arr[i] = count;
    }
    return C_arr;
  }

  private static int getMin(final String str) {
    // returns the freq of min element in a string
    final int[] freqArr = new int[26];

    // create a char count for string
    for (int i = 0; i < str.length(); i++) {
      freqArr[str.charAt(i) - 'a'] += 1;
    }

    // get the first char that has a count greater than 0 ie the min count
    for (final int count : freqArr) {
      if (count > 0) {
        return count;
      }
    }

    return -1;
  }

  public static void main(final String[] args) {
    final String A = "abcd aabc bd";
    final String B = "aaa";

    System.out.println(Arrays.toString(CompareStrings.compare(A, B)));
  }
}

/*
One string is strictly smaller than another when the frequency of
occurrence of the smallest character in the string is less than the
frequency of occurrence of the smallest character in the comparison string.

For example, string "abcd" is smaller than string "aaa" because the
smallest character in lexicographical order) in "abcd" is 'a', with a
frequency of 1, and the smallest character in "aaa" is also 'a', 
but with a frequency of 3.

In another example, string "a" is smaller than string "bb" because
the smallest character in "a" is 'a' with a frequency of 1, and the
smallest character in "bb" is 'b' with a frequency of 2.

Write a function that, given string A (which contains M strings delimited by ',')
and string B (which contains N strings delimited by','), 
returns an array C of N integers. For O<=J<N, values of C[J] specify the
number of strings in A which are strictly smaller than the comparison J-th string in B
(starting from 0).

For example, given strings A and B such that:

A = "abcd aabc bd"
B = "aaa aa"

the function should return (3, 2), because:

All the strings in the array are strictly smaller than "aaa"
on the basis of the given comparison criteria;

Strings "abcd" and "bd" are strictly smaller than "aa".

Assume that:

• 1 <= N, M < 10000 
• 1 <= length of any string contained by A or B < 10
• All the input strings comprise only lowercase English alphabet letters (a-z)

In your solution, focus on correctness. 
The performance of your solution will not be the primary focus of the assessment.
 
*/


  
