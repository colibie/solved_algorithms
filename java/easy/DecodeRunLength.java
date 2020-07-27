package easy;

import java.util.*;
public class DecodeRunLength {
  public static int[] solve(int[] nums) {
    ArrayList<Integer> res = new ArrayList<>();
        
    for (int i = 2; i < nums.length; i += 2) {
        for (int count = 0; count < nums[i - 1]; count++) {
            res.add(nums[i]);
        }
    }
    int[] ret = new int[res.size()];

    for (int i =0; i < res.size(); i++) {
      ret[i] = res.get(i); 
    }
            
    return ret;
  }
}