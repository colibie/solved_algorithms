package linkedlist;

import java.util.HashSet;

/**
 * Write code to remove duplicates from an unsorted linkedlist.
 * FOLLOW UP; How would you do it if a temporary buffer was not allowed?
 */
import java.util.*;

public class RemoveDuplicates {  
  private class LinkedListNode {
    char value;
    LinkedListNode next; 
  }

  private LinkedListNode solve(LinkedListNode head) {
    if (head == null) return head;
    // keep track of previous node
    // connect prevous to next of node if node is duplicate
    Set<Character> seen = new HashSet<>();

    LinkedListNode prev = null;
    LinkedListNode cur = head;    
    while (cur != null) {
      if (seen.contains(cur.value)) {
        prev.next = cur.next;
      } else {
        seen.add(cur.value);
        prev = cur;
      }
      cur = cur.next;
    }
    return head;
  }

  /**
   * Follow up, use an additional pointer to check the rest of the list while in cur
   */
}