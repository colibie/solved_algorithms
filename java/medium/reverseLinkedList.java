package medium;

/**
* Reverse a linked list from position m to n. Do it in one-pass.
* Note: 1 ≤ m ≤ n ≤ length of list.
*
* Example:
*
* Input: 1->2->3->4->5->NULL, m = 2, n = 4
* Output: 1->4->3->2->5->NULL
*
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
      if (head == null) return head;
      ListNode start = null, first = head;
      
      // initialize start position
      if (m-1 > 0) {
          start = advancePointer(m-1, head);
          first = start.next;
      }
      
      if (first == null) return head;
      
      ListNode prev = first, current = first.next;
      
      int i = m;
      while (i < n && current != null) {
          ListNode temp = current.next;
          current.next = prev;
          prev = current;
          current = temp;
          i++;
      }
      first.next = current;
      if (start == null) {
          head = prev; 
      } else {
          start.next = prev;
      }
      
      return head;
  }
  private ListNode advancePointer(int offset, ListNode head) {
      ListNode current = head;
      for (int i = 1; i < offset; i++) {
          current = current.next;
      }
      return current;
  }
}

class MainClass {
  public static int[] stringToIntegerArray(String input) {
      input = input.trim();
      input = input.substring(1, input.length() - 1);
      if (input.length() == 0) {
        return new int[0];
      }
  
      String[] parts = input.split(",");
      int[] output = new int[parts.length];
      for(int index = 0; index < parts.length; index++) {
          String part = parts[index].trim();
          output[index] = Integer.parseInt(part);
      }
      return output;
  }
  
  public static ListNode stringToListNode(String input) {
      // Generate array from the input
      int[] nodeValues = stringToIntegerArray(input);
  
      // Now convert that list into linked list
      ListNode dummyRoot = new ListNode(0);
      ListNode ptr = dummyRoot;
      for(int item : nodeValues) {
          ptr.next = new ListNode(item);
          ptr = ptr.next;
      }
      return dummyRoot.next;
  }
  
  public static String listNodeToString(ListNode node) {
      if (node == null) {
          return "[]";
      }
  
      String result = "";
      while (node != null) {
          result += Integer.toString(node.val) + ", ";
          node = node.next;
      }
      return "[" + result.substring(0, result.length() - 2) + "]";
  }
  
  public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String line;
      while ((line = in.readLine()) != null) {
          ListNode head = stringToListNode(line);
          line = in.readLine();
          int m = Integer.parseInt(line);
          line = in.readLine();
          int n = Integer.parseInt(line);
          
          ListNode ret = new Solution().reverseBetween(head, m, n);
          
          String out = listNodeToString(ret);
          
          System.out.print(out);
      }
  }
}