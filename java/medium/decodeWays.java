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

  private static int decodeVariationIterative(String s) {
    // at i, the number of ways to decode it is, the number of ways to decode
    // i+1 and the number of ways to decode i+2 if valid
    int N = s.length();
    int[] decode = new int[N + 1];
    decode[N] = 1;
    decode[N - 1] = 1;
    // 1 2 0 6
    //[1 ,1, 0 ,1]
    for (int i = N - 2; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        decode[i] = 0;
      } else if (s.charAt(i) == '1') {
        decode[i] = decode[i + 1] + decode[i + 2];
      } else if (s.charAt(i) == '2') {
        decode[i] = decode[i + 1];
        if (i + 1 < s.length() && s.charAt(i + 1) < '7') {
          decode[i] += decode[i + 2];
        } else {
          decode[i] = decode[i + 1];
        }
      }
    }

    return decode[0];
  }

  public static void main(String[] args) {
    String s = "1216";
    System.out.println(decodeWays.decodeVariation(s));
    System.out.println(decodeWays.decodeVariationIterative(s));
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
 *
 *
 * 1222
 * 1, 222
 * 1, 2, 22
 * 1, 22, 2
 * 1, 2, 2, 2
 * 12, 22
 * 12, 2, 2
 *  i = 0
 *  1222
 *  if (i == s.length) return 0;
 *  if (i == s.length - 1) return 1;
 *  if (s.charAt(i) == 0) return 0;
 *  if [memo[i] > -1] return memo[i]
 *  let count = decode(s, i+1);
 *
 * if (s.charAt(i) == 1) {
 *  count += decode(s, i+2)
 * }
 * if (s.charAt(i) == 2 && (i+1 < s.length && s.charAt(i+1) < 7)) {
 *      count += decode(s, i+2)
 * }
 * memo[i] = count;
 * return memo[i];
 * 0123
 * 1222 * count = 1   count = 3
 *
 *
 * i = 2
 * i = 0
 */