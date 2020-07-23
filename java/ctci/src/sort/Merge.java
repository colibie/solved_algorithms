package sort;

import Library.Util;

public class Merge {
  private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
    //  copy a into aux
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    int i = lo, j = mid + 1;

    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (Util.less(aux[i], aux[j]) > 0) {
        a[k] = aux[i++];
      } else {
        a[k] = aux[j++];
      }
    }
  }

  private static void sort(final int[] data, int[] aux, int lo, int hi) {
    // divide and conquer
    // divide in 2, sort left, sort right and merge
    if (hi <= lo) return;

    int mid = lo + (hi - lo) / 2;
    sort(data, aux, lo, mid);
    sort(data, aux, mid + 1, hi);
    merge(data, aux, lo, mid, hi);
  }

  private static void sort2(int[] data, int[] aux) {
    int N = data.length;
    for (int sz = 1; sz < N; sz += sz) {               // O(log N)
      for (int lo = 0; lo <= N - sz; lo += sz + sz) {  // O(log N/2)
        merge(data, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
      }
    }
  }

  public static void main(String[] args) {
    int[] data = Util.randomIntArray();
    int N = data.length;
    int[] aux = new int[N];

    Merge.sort(data, aux, 0, N - 1);

    System.out.println("Recursive sort");

    for (int i = 0; i < N; i++) {
      System.out.print(data[i] + " ");
    }
    System.out.println("----------------");

    // bottom-up merge sort
    data = Util.randomIntArray();
    N = data.length;
    aux = new int[N];

    Merge.sort2(data, aux);

    System.out.println("Iterative sort");

    for (int i = 0; i < N; i++) {
      System.out.print(data[i] + " ");
    }
    System.out.println("----------------");
  }
}