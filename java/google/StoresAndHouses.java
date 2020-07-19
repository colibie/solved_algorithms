package google;

import java.util.Arrays;
import java.util.HashMap;

/**
You are given 2 arrays representing integer locations of stores and houses (each
location in this problem is one-dementional). For each house, find the store
closest to it.
Return an integer array result where result[i] should denote the location of the
store closest to the i-th house. If many stores are equidistant from a
particular house, choose the store with the smallest numerical location. Note
that there may be multiple stores and houses at the same location.

Example 1:

Input: houses = [5, 10, 17], stores = [1, 5, 20, 11, 16]
Output: [5, 11, 16]
Explanation:
The closest store to the house at location 5 is the store at the same location.
The closest store to the house at location 10 is the store at the location 11.
The closest store to the house at location 17 is the store at the location 16.

Example 2:

Input: houses = [2, 4, 2], stores = [5, 1, 2, 3]
Output: [2, 3, 2]

Example 3:

Input: houses = [4, 8, 1, 1], stores = [5, 3, 1, 2, 6]
Output: [3, 6, 1, 1]

*/
public class StoresAndHouses {
  // brute force -> for each house, search each store O(HXS) time
  public static int[] brute(final int[] house, final int[] store) {
    final int[] res = new int[house.length];
    // because there may be many houses in same location, avoid recomputing
    final HashMap<Integer, Integer> cache = new HashMap<>();
    for (int i = 0; i < house.length; i++) {
      if (cache.get(house[i]) != null) {
        res[i] = cache.get(house[i]);
      }

      int minDis = Integer.MAX_VALUE;
      int storeVal = Integer.MAX_VALUE;

      for (int j = 0; j < store.length; j++) {
        final int curDis = Math.abs(house[i] - store[j]);
        if (curDis > minDis)
          continue;

        minDis = curDis; // 3
        // if equal and the current value is greater, overwrite
        if (curDis == minDis) {
          if (storeVal > store[j]) {
            res[i] = storeVal = store[j];
          } // 5
        } else {
          res[i] = storeVal = store[j]; // 5
        }
      }
    }
    return res;
  }

  // Solution, sort the stores in O(N) time using counting sort
  // for each house, use a modified binary search to find the house closest to
  // it.
  // O(SlogS + HlogS) time. O(N) space
  public static int[] optimized(final int[] inputH, final int[] inputS) {
    // defensive copy
    int[] houses = new int[inputH.length];
    int[] stores = new int[inputS.length];
    System.arraycopy(inputH, 0, houses, 0, inputH.length);
    System.arraycopy(inputS, 0, stores, 0, inputS.length);
    Arrays.sort(stores);

    int[] res = new int[houses.length];
    // algorithm
    for (int i = 0; i < houses.length; i++) {
      // because there may be many houses in same location, avoid recomputing
      final HashMap<Integer, Integer> cache = new HashMap<>();
      if (cache.get(houses[i]) != null) {
        res[i] = cache.get(houses[i]);
      }
      res[i] = binarySearch(stores, houses[i]);
    }
    return res;
  }

  private static int binarySearch(int[] stores, int target) {
    int start = 0;
    int end = stores.length - 1;
    int minDis = Integer.MAX_VALUE;
    int storeVal = Integer.MAX_VALUE;

    while (start <= end) {
      if (stores[start] == target || stores[end] == target)
        return target;

      int mid = start + (end - start) / 2;
      if (stores[mid] == target)
        return target;

      int curDis = Math.abs(target - stores[mid]);
      if (curDis <= minDis) {
        if (curDis == minDis) {
          storeVal = Math.min(storeVal, stores[mid]);
        } else {
          minDis = curDis;
          storeVal = stores[mid];
        }
      }

      if (stores[mid] > target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return storeVal;
  }
  // you can also use a tree set to store the store, then compare the math.ceil and math.floor values
  public static void main(final String[] args) {
    // Input: houses = [4, 8, 1, 1], stores = [5, 3, 1, 2, 6]
    // Output: [3, 6, 1, 1]
    // Input: houses = [2, 4, 2], stores = [5, 1, 2, 3]
    // Output: [2, 3, 2]
    // Input: houses = [5, 10, 17], stores = [1, 5, 20, 11, 16]
    // Output: [5, 11, 16]
    final int[] houses = {4, 8, 1, 1};
    final int[] stores = {5, 3, 1, 2, 6};
    final int[] res = StoresAndHouses.optimized(houses, stores);
    for (final int var : res) {
      System.out.print(var + " ");
    }
    System.out.println();
  }
}