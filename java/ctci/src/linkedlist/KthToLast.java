package linkedlist;

/**
 * Given a singly LinkedList, find the Kth to Last element;
 */
import Library.*;
public class KthToLast {
  public static ListNode solution(ListNode head, int K) {
    if (K == 0) return null;
    if (head == null) return head;

    ListNode current = head;
    ListNode running = head;

    while(K > 0) {
      if (running == null) return null;
      running = running.next;
      K--;
    }

    while (running != null) {
      current = current.next;
      running = running.next;
    }

    return current;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode();
    head.value = '1';
    ListNode cur = head;
    for (char i = '2'; i < '9'; i++) {
      ListNode next = new ListNode();
      next.value = i;
      cur.next = next;
      cur = cur.next;
    }

    System.out.println(KthToLast.solution(head, 1));
    System.out.println(KthToLast.solution(head, 2));
    System.out.println(KthToLast.solution(head, 3));
    // System.out.println(KthToLast.solution(head, 9));
    System.out.println(KthToLast.solution(head, 8));
  }
}