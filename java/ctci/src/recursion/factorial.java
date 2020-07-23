package recursion;

public class factorial {

  // private int n;
  // public factorial(int n) {
  //   this.n = n;
  // }

  public int result(final int n) {
    if (n == 0) return 1;
    return n * result(n - 1);
  }

  public static void main(final String[] args) {
    final factorial fact = new factorial();

    System.out.println(fact.result(5));
  }
}