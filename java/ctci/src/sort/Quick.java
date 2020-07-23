package sort;

import java.util.Random;
import Library.Util;

public class Quick {

  private static int[] shuffle(final int[] data) {
    final Random rand = new Random();
    final int N = data.length;
    for (int i = 0; i < N; i++) {
      // obtain random num between i and N; rand.nextInt((max - min) + 1) + min
      final int ran = rand.nextInt(N - i) + i;
      final int temp = data[i];
      data[i] = data[ran];
      data[ran] = temp;
    }
    return data;
  }

  /**
   * @param data
   * @param lo
   * @param hi
   * @return the partition element correct position
   */

  public int partition(final int[] data, final int lo, final int hi) {
    final int k = data[lo];
    int i = lo, j = hi + 1;

    while (true) {
      // find item on left greater than k
      while (Util.less(data[++i], k) > 0) {
        if (i == hi) break;
      }
      // find item on right less than k
      while (Util.less(data[--j], k) <= 0) {
        if (j == lo) break;
      }

      if (i >= j) {
        break;
      }
      Util.exch(data, i, j);
    }

    // swap with partition item
    Util.exch(data, lo, j);

    return j;
  }

  /**
   * recursively partitions the data using divide and conquer
   * @param data
   * @param lo
   * @param hi
   */
  private void sort(final int[] data, final int lo, final int hi) {
    if (lo >= hi) return;
    final int j = partition(data, lo, hi);
    sort(data, lo, j);
    sort(data, j + 1, hi);
  }

  public void sort(int[] data) {
    // shuffle data
    data = shuffle(data);
    sort(data, 0, data.length - 1);
  }

  public static void main(final String[] args) {
    final Random rand = new Random();
    final int N = rand.nextInt(10);
    final int[] data = new int[N];

    for (int i = 0; i < N; i++) {
      data[i] = rand.nextInt(1000);
    }

    final Quick quick = new Quick();

    quick.sort(data);

    System.out.println("Recursive quick sort");

    for (int i = 0; i < N; i++) {
      System.out.print(data[i] + " ");
    }
    System.out.println();
  }
}