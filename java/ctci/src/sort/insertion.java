package sort;

import Library.Util;
// compares the current idx with the previous items and moves it till it gets to min o(N2)
public class insertion {

  public insertion(final double[] data) {
    final double[] res = sort(data);
    for (final double i : res) {
      System.out.println(i + " ");
    }
    System.out.println();
  }

  double[] sort(final double[] data) {
    for (int i = 1; i < data.length; i++) {
      for (int j = i; j > 0; j--) {
        if (Util.less(data[j], data[j - 1]) >
            0) {  // if data is less than or equal curData
          Util.exch(data, j, j - 1);
        }
      }
    }
    return data;
  }

  public static void main(final String[] args) {
    final double[] data = Util.randomDoubleArray();
    new insertion(data);
  }
}