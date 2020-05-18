import java.util.Scanner;
// new BufferedReader(new InputStreamReader(System.in)

/**
 * allocation... this uses min heap principle
 */
public class allocation {
  private int[] data;
  private int N;

  public allocation(int cap) { data = new int[cap + 1]; }

  private void swim(int k) {
    while (k > 1 && greater(k / 2, k)) {
      exch(k, k / 2);
      k = k / 2;
    }
  }

  private void sink(int k) {
    while (2 * k <= N) {
      int j = 2 * k;
      if (j < N && greater(j, j + 1))
        j++;
      if (!greater(k, j))
        break;
      exch(k, j);
      k = j;
    }
  }

  private boolean greater(int i, int j) { return data[i] > data[j]; }

  private void exch(int i, int j) {
    int temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }

  public void insert(int el) {
    data[++N] = el;
    swim(N);
  }

  public int delMin() {
    int min = data[1];
    exch(1, N--);
    sink(1);
    data[N + 1] = 0;
    return min;
  }

  public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int testsNo = Integer.parseInt(scan.nextLine());
      for (int i = 0; i < testsNo; i++) {
        int arrLength = scan.nextInt();
        int budget = scan.nextInt();
        allocation test = new allocation(arrLength);
        for (int j = 0; j < arrLength; j++) {
          int next = scan.nextInt();
          test.insert(next);
        }
        int total = 0, count = 0;
        while (total < budget && arrLength-- > 0) {
          int min = test.delMin();
          total += min;
          if (total > budget) break;
          count++;
        }

        System.out.printf("Case #%s: %s %n", i+1, count);
      }
      scan.close();
  }
}