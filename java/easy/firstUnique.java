package easy;

import java.util.*;

class firstUnique {
  // O(N) time and space
  static public int firstUniqueCharacter(String s) {
    HashMap<Character, Integer> freq = new HashMap<>();

    // count freq
    for(int i = 0; i < s.length(); i++) {
      char val = s.charAt(i);
      Integer count = freq.get(val);
      if (count == null) {
        freq.put(val, 1);
      } else {
        freq.put(val, count + 1);
      }
    }

    // check string
    for (int i = 0; i < s.length(); i++) {
      if (freq.get(s.charAt(i)) == 1) return i;
    }
    return -1;
  }

  public static void main(String args[] ) {
    System.out.println(firstUnique.firstUniqueCharacter("loveleetcode"));
  }
}



/** 
#### First Unique Character in a String

Given a string, find the first non-repeating character in it and return its index. 
If it doesn't exist, return -1.

Examples:
s = "leetcode"
return 0.

s = "loveleetcode"
return 2.



index = -1;
count = 0;
looping the string
 


dict = { l: 1, e: 3, t: 1, c: 1, o: 1, d: 1} O(N) O(N)


for(int i=0; i < s.length; i++) { O(N) time complexity
  if (dict.get(s[i]) == 1) return i; O(1)
}
return -1;

O(N) time and O(N)


{
  l: 1, e: 3, t: 1, c: 1, o: 1, d: 1
}
  

*/