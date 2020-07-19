package medium;

// Given a string of integers encoded using the numbers of the letters of the
// alphabet,
// return how many ways the string can be decoded
// Eg, Given 1236 can be decoded as
// 1, 2, 3, 6
// 12, 3, 6
// 1, 23, 6
public class decodeWays {
  static int decodeVariation(String s) { return decodeVariationHelper(0, s); }

  private static int decodeVariationHelper(int start, String s) {
    if (start == s.length())
      return 1; // passes

    int left = 0, right = 0; // initialize to fail
    int leftNumber = Integer.parseInt(s.substring(start, start + 1));
    if (leftNumber > 0 && leftNumber < 10) {
      left = decodeVariationHelper(start + 1, s);
    }
    if (start + 2 <= s.length()) {
      int rightNumber = Integer.parseInt(s.substring(start, start + 2));
      if (rightNumber >= 10 && rightNumber <= 26) {
        right = decodeVariationHelper(start + 2, s);
      }
    }

    return left + right;
  }

  public static void main(String[] args) {
    String s = "1206";
    System.out.println(decodeWays.decodeVariation(s));
  }
}

/**
 *                              .
 *                              1226
 *                        /             \
 *                      .                  .
 *                     1226              1226
 *                  /         \         /       \
 *              .             .        .          .
 *            1226        1226 (P)  1226       1226(P)
 *          /     \                 /     \
 *       .         .                 .    F     
 *    1226     1226 (P)          1226(P)
 *     /  \
 *      .   F
 *  1226(P)
 */