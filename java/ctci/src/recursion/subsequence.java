package recursion;

public class subsequence {
  public subsequence (String data) {
    helper("", data);
  }

  public void helper(String perm, String data) {
    System.out.println(perm);
    if (data.length() == 0) return;
    else {
      for (int i = 0; i < data.length(); i++) {
        char at = data.charAt(i);
        String rem = data.substring(i+1);
        String sum = perm + at;
        helper(sum, rem);
      }
    }
  }

  public static void main(String[] args) {
    subsequence test = new subsequence("abcd");
    System.out.print(test);
  }
}