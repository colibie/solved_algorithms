package sort;

import Library.Util;

// compare the current idx with further items and select the minimum, and
// exchange. ~ O(N2)
public class selection {

  public selection(final double[] data) {
    final double[] res = sort(data);
    for (final double i : res) {
      System.out.println(i + " ");
    }
    System.out.println();
  }

  double[] sort(final double[] data) {
    for (int i = 0; i < data.length; i++) {
      int min = i;
      for (int j = i + 1; j < data.length; j++) {
        if (Util.less(data[j], data[i]) >
            0) {  // if data is less than or equal curData
          min = j;
        }
      }
      Util.exch(data, i, min);
    }
    return data;
  }

  public static void main(final String[] args) {
    final double[] data = Util.randomDoubleArray();
    new insertion(data);
  }
}