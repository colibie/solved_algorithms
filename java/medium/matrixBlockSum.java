package medium;

/**
Given a m * n matrix mat and an integer K, return a matrix answer where each answer[i][j] is the sum of all 
elements mat[r][c] for i - K <= r <= i + K, j - K <= c <= j + K, and (r, c) is a valid position in the matrix.

Example 1:
Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
Output: [[12,21,16],[27,45,33],[24,39,28]]

Example 2:
Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
Output: [[45,45,45],[45,45,45],[45,45,45]]

*/

public class matrixBlockSum {
  private int rows;
  private int cols;
  public int[][] brute(int[][] mat, int K) {
    rows = mat.length;
    cols = mat[0].length;
    int[][] answer = new int[rows][cols];
    // O(r * c * (2k + 1))
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        int sum = 0;
        for (int i = row - K; i <= row + K; i++) {
          for (int j = col - K; j <= col + K; j++) {
            if (isValid(i, j)) {
              sum += mat[i][j];
            }
          }
        }
        answer[row][col] = sum;
      }
    }

    return answer;
  }

  private boolean isValid(int row, int col) {
    if (row >= 0 && row < rows && col >= 0 && col < cols)
      return true;
    return false;
  }

  // see solution explanation here: https://computersciencesource.wordpress.com/2010/09/03/computer-vision-the-integral-image/

  public int[][] rangeSum(int[][] matrix, int K) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int[][] sumTable = new int[rows + 1][cols + 1];
    generateSumsTable(matrix, sumTable);

    return getBlockSums(sumTable, K);
  }

  private void generateSumsTable(int[][] matrix, int[][] sumTable) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= cols; j++) {            // top                  
        sumTable[i][j] = matrix[i - 1][j - 1] + sumTable[i - 1][j] +
                          // left               // top-left dia
                         sumTable[i][j - 1] - sumTable[i - 1][j - 1];
      }
    }
  }

  private int[][] getBlockSums(int[][] sumTable, int K) {
    int rows = sumTable.length - 1;
    int cols = sumTable[0].length - 1;
    int[][] ans = new int[rows][cols];
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        int r1 = Math.max(0, r - K), c1 = Math.max(0, c - K);
        int r2 = Math.min(rows, r + K + 1), c2 = Math.min(cols, c + K + 1);
        ans[r][c] = sumTable[r1][c1] + sumTable[r2][c2] -
                    sumTable[r1][c2] - sumTable[r2][c1];
      }
    }
    return ans;
  }
}