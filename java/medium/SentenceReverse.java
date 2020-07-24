package medium;

/**
 * Given an array of char, where an empty char indicates a sentence space, reverse the sentence;
 * Eg:
 * input: [p, r, a, c, t, i, c, e, , m, a, k, e, s,  , p, e, r, f, e, c, t]
 * output: [p, e, r, f, e, c, t, ,m, a, k, e, s, ,p, r, a, c, t, i, c, e]
 */

import java.util.*;

class SentenceReverse {
  public static char[] sentenceReverse(char[] arr) {
    // start from the back and copy to front; keeping track of where we are on both sides

    int len = arr.length - 1;
    int start = len;
    int cur = 0;
    char[] res = new char[len + 1];

    while (start >= 0) {
      if (arr[start] == ' ') {
        res[cur] = arr[start];
        start--; cur++;
      }

      while(start >= 0 && arr[start] != ' ') {
        start--;
      }

      int reverseFrom = start + 1;

      while (cur < len - start) {
        res[cur] = arr[reverseFrom];
        cur++; reverseFrom++;
      }
    }

    return res;
 }  

 public static void main(String[] args) {
   char[] input = {'p', 'r', 'a', 'c', 't', 'i', 'c', 'e',' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'e', 'r', 'f', 'e', 'c', 't'};
   char[] res = SentenceReverse.sentenceReverse(input);
   System.out.println(res.toString());
 }
}