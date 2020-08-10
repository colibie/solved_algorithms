package google;

import java.util.*;

public class countdown {
  public int solve(int[] arr, int k) {
    int i = 0, count = 0;
    while (i <= arr.length - k) {
      if (arr[i] == k) {
        boolean valid = true;
        for (int j = 0; j < k - 1; j++) {
          if (arr[i + 1] != arr[i] - 1) {
            valid = false;
            break;
          }
          i++;
        }
        if (valid) {
          count++;
        }
      }
      i++;
    }
    return count;
  }

  // keep a decreasing counter and restart the counter each time the countdown
  // is incorrect
  public int solve2(int[] arr, int k) {
    int counter = 0, res = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == arr[i - 1] - 1) {
        counter++;
      } else {
        counter = 0;
      }
      if (arr[i] == 1 && counter >= k - 1) {
        res++;
      }
    }
    return res;
  }
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int testsNo = Integer.parseInt(scan.nextLine());
    for (int i = 0; i < testsNo; i++) {
      int arrLength = scan.nextInt();
      int K = scan.nextInt();
      countdown test = new countdown();
      int[] input = new int[arrLength];
      for (int j = 0; j < arrLength; j++) {
        int next = scan.nextInt();
        input[j] = next;
      }
      int count = test.solve(input, K);

      System.out.printf("Case #%s: %s %n", i + 1, count);
    }
    scan.close();
  }
}