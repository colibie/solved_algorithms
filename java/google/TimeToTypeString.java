package google;

/** SEE QUESTION ON LINE 38 */

public class TimeToTypeString {
  public static int calculateTimeTaken(String kb, String text) {
    if (kb.length() == 0 || text.length() == 0) {
      return 0;
    }
    
    // store the index of the the keyboard characters
    int[] positions = buildPosition(kb);
    int totaltime = positions[text.charAt(0) - 'a'];

    for (int i = 0; i < text.length() - 1; i++) {
      // get diff between prev char position and next char position
      int index_i = positions[text.charAt(i) - 'a'];
      int index_j = positions[text.charAt(i + 1) - 'a'];
      totaltime += Math.abs(index_j - index_i);
    }

    return totaltime;
  }
  private static int[] buildPosition(String kb) {
    int[] positions = new int[26];
    for (int i = 0; i < 26; i++) {
      positions[kb.charAt(i) - 'a'] = i;
    }
    return positions;
  }

  public static void name() {
    String kb = "abcdefghijklmnopqrstuvwxy";
    String text = "yay";
    int result = TimeToTypeString.calculateTimeTaken(kb,text);
    System.out.println("Print total time taken: " + result);
  }
}
/*
Imagine you have a special keyboard with all keys in a single row.
The layout of characters on a keyboard is denoted by a string keyboard of
length 26.
Initially your finger is at index 0. To type a character, you have to move
your finger to the index of the desired character.
The time taken to move your finger from index i to index j is abs(j - i).

Given a string keyboard that describe the keyboard layout and a string text,
return an integer denoting the time taken to type string text.

Example 1:

Input: keyboard = "abcdefghijklmnopqrstuvwxy", text = "yay"
Output: 4
Explanation:
Initially your finger is at index 0. First you have to type 'c'.
The time taken to type 'c' will be abs(2 - 0) = 2 because character 'c' is at
index 2.
The second character is 'b' and your finger is now at index 2.
The time taken to type 'b' will be abs(1 - 2) = 1 because character 'b' is at
index 1.
The third character is 'a' and your finger is now at index 1.
The time taken to type 'a' will be abs(0 - 1) = 1 because character 'a' is at
index 0.
The total time will therefore be 2 + 1 + 1 = 4.

Constraints:

    length of keyboard will be equal to 26 and all the lowercase letters will
    occur exactly once;
    the length of text is within the range [1..100,000];
    string text contains only lowercase letters [a-z].

string - 26 chars
start = 0
sum = 0 + 2 + 1 + 1 = 4
2  1  0
c  b  a

*/