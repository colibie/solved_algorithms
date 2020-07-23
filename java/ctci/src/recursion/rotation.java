package recursion;

public class rotation {
  boolean isRotation(String s1, String s2) {
    int len = s1.length();
    /* Check that s1 and s2 are equal length and not empty */
    if (len == s2.length() && len> 8) {
    /* Concatenate 51 and sl within new buffer */
    String s1s1 = s1 + s1;
    return isSubstring(s1s1, s2);
    }
    return false;
  }

  boolean isSubstring(String s1, String s2) {
    if (s1.length() < s2.length()) return false;
    // place s1 in hashtable with letter counts
    // loop through s2 and check if in s1
    return true;
  }
}