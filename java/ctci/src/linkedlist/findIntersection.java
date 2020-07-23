// LinkedListNode findIntersection(LinkedListNode l1, LinkedListNode l2) {
//   // find size and tail
//   // chop off difference in length on longer list
//   // find intersection by looping at same time

//   if (l1 == null || l2 == null) {
//     return null;
//   }

//   Result result1 = getTailAndSize(l1);
//   Result result2 = getTailAndSize(l2);

//   // if different tails return
//   if (result1.tail != result2.tail) {
//     return null;
//   }

//   LinkedListNode shorter = result1.size < result2.size ? l1 : l2;
//   LinkedListNode longer = result1.size < result2.size ? l2 : l1;

//   // cut off diffence ie advance pointer of longer
//   longer = getKthNode(longer, Math.abs(result1.size - result2.size));

//   while (shorter != longer) {
//     shorter = shorter.next;
//     longer = longer.next;
//   }

//   return shorter;
// }

// Result getTailAndSize(LinkedListNode l) {
//   if (l == null) return null;

//   int size = 1;
//   LinkedListNode current = l;

//   while (current.next != null) {
//     size++;
//     current = current.next;
//   }
//   return new Result(tail, size); 
// }

// class Result {
//   public LinkedListNode tail;
//   public int size;
//   public Result(LinkedListNode tail, int size) {
//     this.tail = tail;
//     this.size = size;
//   }
// }