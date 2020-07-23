package sort;

import Library.Util;
// selection sort going back h times at a time; O(N2) worst case
public class shell {

  public shell(final double[] data) {
    final double[] res = sort(data);
    for (final double i : res) {
      System.out.println(i + " ");
    }
    System.out.println();
  }

  double[] sort(final double[] data) {
    // obtain h sequence, starting from the largest within the file using 3h +
    // 1:Knuth formular
    int h = 1, N = data.length;
    while (h < N / 3) h = 3 * h + 1;

    while (h >= 1) {  // while the sorting sequence still holds
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h; j -= h) {  // go back h spaces
          if (Util.less(data[j], data[j - h]) >
              0) {  // if data is less than or equal curData
            Util.exch(data, j, j - h);
          }
        }
      }
      h = h / 3;  // reduce h
    }
    return data;
  }

  public static void main(final String[] args) {
    final double[] data = Util.randomDoubleArray();
    new shell(data);
  }
}