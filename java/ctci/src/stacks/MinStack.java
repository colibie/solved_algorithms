package stacks;
import static org.junit.Assert.assertEquals;

/**
 * Design a stack, that in addition to push and pop has a function, Min, that
 * returns the min element in the stack. All operations should be O(1);
 */
import java.util.*;

import org.junit.Test;
public class MinStack {
  private int min;
  Stack<Integer> stack;

  public MinStack() {
    stack = new Stack<>();
    min = Integer.MAX_VALUE;
  }

  /**
   * SOLUTION: Each time we want to push a value that is less than min, we push
   * the previous min and then the value.
   * Such that, when we want to pop a min value, we pop twice. The first time to
   * get the actual value to be returned and the second, to get the old Min
   * value;
   */

  public int pop() {
    if (stack.isEmpty()) throw new EmptyStackException();
    int cur = stack.pop();
    if (cur == min) {
      min = stack.pop();
    }
    return cur;
  }

  public void push(int value) {
    if (value < min) {
      stack.push(min);
      min = value;
    }
    stack.push(value);
  }

  public int min() {
    if (stack.isEmpty()) return Integer.MAX_VALUE;
    return min;
  }

  @Test
  public static void main(String[] args) {
    MinStack stack = new MinStack();
    stack.push(1);
    stack.push(2);
    assertEquals("min should be 1", 1, stack.min());
    stack.push(-1);
    assertEquals("min should be -1", -1, stack.min());
    assertEquals("pop should be -1", -1, stack.pop());
    assertEquals("min should be 1", 1, stack.min());
    stack.push(-2);
    assertEquals("min should be -2", -2, stack.min());
    assertEquals("pop should be -2", -2, stack.pop());
    assertEquals("min should be 1", 1, stack.min());
  }
}