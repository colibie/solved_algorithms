package String;

import java.util.*;

/**
 * Given two strings, write a method to see if one is a permutation of the other
 */
public class IsPermuation {
  public static Boolean solution(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    int N = s1.length();
    if (N == 0) return false;

    Map<Character, Integer> freqCount = new HashMap<>();
    for (int i = 0; i < N; i++) {
      char cur = s1.charAt(i);
      if (freqCount.get(cur) == null) {
        freqCount.put(cur, 1);
      } else {
        freqCount.put(cur, freqCount.get(cur) + 1);
      }      
    }

    for (int i = 0; i < N; i++) {
      char cur = s2.charAt(i);
      if (freqCount.get(cur) == null || freqCount.get(cur) == 0) return false;
      freqCount.put(cur, freqCount.get(cur) - 1);
    }

    return true;
  }

  public static void main(String[] args) {
    String s1 = "leetcode";
    String s2 = "lletcode";

    System.out.println(IsPermuation.solution(s1, s2));
  }
}