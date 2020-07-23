package recursion;

public class permutation {
  public permutation (String data) {
    helper("", data);
  }

  public void helper(String perm, String data) {
    if (data.length() == 0) System.out.println(perm);
    else {
      for (int i = 0; i < data.length(); i++) {
        char at = data.charAt(i);
        String rem = data.substring(0, i) + data.substring(i+1);
        String sum = perm + at;
        helper(sum, rem);
      }
    }
  }

  public static void main(String[] args) {
    permutation test = new permutation("abc");
    System.out.print(test);
  }
}