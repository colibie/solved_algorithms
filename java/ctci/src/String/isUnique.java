package String;
/**
 * Write a function to determine if a s string haas all unique characters.
 * FOLLOW UP: What if you can't use additional DS?
 */
import java.util.*;

public class isUnique {
  public static boolean solution(String s) {
    Set<Character> seen = new HashSet<>();

    // O(N)
    for (int i = 0; i < s.length(); i++) {
      if (seen.contains(s.charAt(i))) return false;
      seen.add(s.charAt(i));
    }

    return true;
  }
  /**
   * FOLLOW UP; if not allowed to use additional DS, we can check the rest of
   * the characters, with respect to a current character. This is O(N2).
   * OR we can sort the string
   */
}