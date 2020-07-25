package hard;

public class makePalindrome {
  public static int inMinWays(String s) {
    int N = s.length();
    int[][] memo = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        memo[i][j] = -1;
      }
    }
    return inMinWaysHelper(s, 0, N - 1, memo);
  }

  private static int inMinWaysHelper(String s, int start, int end, int[][] memo) {
    if (start >= end) return 0;

    if (memo[start][end] > -1) { return memo[start][end]; }

    if (s.charAt(start) == s.charAt(end)) {
      memo[start][end] = inMinWaysHelper(s, start + 1, end - 1, memo);
      return memo[start][end];
    }

    memo[start][end] = Math.min(inMinWaysHelper(s, start + 1, end, memo), inMinWaysHelper(s, start, end - 1, memo)) + 1;
    return memo[start][end];
  }
}