package String;
/**
 * Write a function to determine if a s string haas all unique characters.
 * FOLLOW UP: What if you can't use additional DS?
 */
import java.util.*;

public class isUnique {
  public static boolean solution(String s) {
    Map<Character, Integer> freqCount = new HashMap<>();

    // O(N)
    for (int i = 0; i < s.length(); i++) {
      if (freqCount.get(s.charAt(i)) != null) return false;
      freqCount.put(s.charAt(i), i);
    }

    return true;
  }
  /**
   * FOLLOW UP; if not allowed to use additional DS, we can check the rest of
   * the characters, with respect to a current character. This is O(N2).
   * OR we can sort the string
   */
}