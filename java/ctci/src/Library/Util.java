package Library;

import java.util.Random;

public class Util {
  final static Random rand = new Random();

  /**
   * Returns an array with random integers;
   */
  public static int[] randomIntArray() {
    final int N = rand.nextInt(10);

    final int[] data = new int[N];

    for (int i = 0; i < N; i++) {
      data[i] = rand.nextInt(1000);
    }
    return data;
  }

  /**
  * Returns an array with random doubles;
  * @param bound the length of the array, if omitted a random length is used
  */

  public static double[] randomDoubleArray() {
    final int N = rand.nextInt(10);

    final double[] data = new double[N];

    for (int i = 0; i < N; i++) {
      data[i] = Math.random() * rand.nextInt(1000);
    }
    return data;
  }

  /**
   * @param num1
   * @param num2
   * @return 1 if less, -1 if greater or 0 if equal
   *  
   */

  public static double less(double num1, double num2) {
    if (num1 > num2) return -1;
    if (num1 < num2) return 1;
    return 0;
  }

    /**
   * @param num1
   * @param num2
   * @return 1 if less, -1 if greater or 0 if equal
   */

  public static int less(int num1, int num2) {
    if (num1 > num2) return -1;
    if (num1 < num2) return 1;
    return 0;
  }

  public static void exch(final double[] arr, final int i, final int j) {
    final double temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void exch(final int[] arr, final int i, final int j) {
    final int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}