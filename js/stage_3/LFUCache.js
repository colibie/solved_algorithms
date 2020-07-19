class Node {
  constructor(key, val, count) {
    this.key = key;
    this.val = val;
    this.count = count;
    this.prev = null;
    this.next = null;
  }
}

class Dll {
  constructor() {
    this.head = new Node(null, null, 0);
    this.tail = new Node(null, null, 0);
    this.head.next = this.tail;
    this.tail.prev = this.head;
    this.size = 0;
  }

  insertAtHead(node) {
    // Head <--> 3 <--> 4 <--> Tail
    node.prev = this.head;
    node.next = this.head.next;
    this.head.next.prev = node;
    this.head.next = node;

    this.size++;
  }

  removeNode(node) {
    // Head <--> 3 <--> 4 <--> Tail
    node.prev.next = node.next;
    node.next.prev = node.prev;
    this.size--;
  }

  removeTail() {
    // Node(Head) <--> Node(4) <--> Node(1) <--> Node(6) <--> Node(Tail)
    this.tail.prev.prev.next = this.tail;
    this.size--;
  }

  length() { return this.size; }

  getTailNode() {
    return this.tail.prev;
  }

}
/**
 * @param {number} capacity
 */
const LFUCache = function (capacity) {
  this.capacity = capacity;
  this.cache = {};
  this.freqCache = { 1: new Dll() };
  this.min = -1;
  this.size = 0;

};

/** 
 * @param {number} key
 * @return {number}
 */
LFUCache.prototype.get = function (key) {
  // We also use the function in put(key, value)
  // provided that the key exist in cache
  // note that we have already mutate its value in the put(key, value) function.

  if (this.cache[key] === undefined) { return -1; }

  // get the node for this key
  const node = this.cache[key];

  // get the previous freq
  const prevFreq = node.count;

  // modify the node's freq and assign new freq
  const newFreq = ++node.count; // Note that the previous method is still valid. Yes

  // get the list from prevFreq
  let list = this.freqCache[prevFreq];

  // remove the node from the prev freq
  list.removeNode(node);

  // create new freq Listnode if not exist
  if (this.freqCache[newFreq] === undefined) {
    this.freqCache[newFreq] = new Dll();
  }
  // add to head of the new freq Listnode
  this.freqCache[newFreq].insertAtHead(node);

  // and see if you can update the minimum
  if (list.length() === 0) {
    if (prevFreq !== 1) { //dont delete one because it's default and must not be deleted
      list = undefined; // To help our Space Complexity
    }
    if (prevFreq === this.min) {
      this.min++;
    }
  }

  return node.val;
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LFUCache.prototype.put = function (key, value) {
  // Correct
  if (this.capacity <= 0) return;

  // Correct
  // IF KEY EXIST
  // Mutate the value of the node key in cache
  if (this.cache[key] !== undefined) {
    const node = this.cache[key];
    node.val = value;
    this.get(key);
    return;
  }

  // 
  // IF KEY DOESN'T EXIST
  // check capacity is full
  if ((this.size >= this.capacity)) {
    // --- Invalidate least frequency node and the least recently used

    // Get List corresponding to the minimum frequency
    const list = this.freqCache[this.min];

    // Invalidate least frequency node and the least recently used at the same time 
    const nodeToRemove = list.getTailNode();
    list.removeTail();
    this.cache[nodeToRemove.key] = undefined;
    this.size--;
  }

  // Correct
  // Insert new Node no matter what.
  // Create new node
  const newNode = new Node(key, value, 1);

  // new minimum would be 1
  this.min = 1;

  // Add the new node to the cache
  this.cache[key] = newNode;

  this.freqCache[this.min].insertAtHead(newNode);
  this.size++;

};

const cache = new LFUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
console.log(cache.get(1));       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
console.log(cache.get(3));       // returns 3.
cache.put(4, 4);    // evicts key 1.
console.log(cache.get(1));       // returns -1 (not found)
console.log(cache.get(3));       // returns 3
console.log(cache.get(4));       // returns 4
/*
### LFU Cache

Design and implement a data structure for Least Frequently Used (LFU) cache.
It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
           otherwise return -1.

put(key, value) - Set or insert the value if the key is not already present.
                  When the cache reaches its capacity, it should invalidate
                  the least frequently used item before inserting a new item.
                  For the purpose of this problem, when there is a tie
                  (i.e., two or more keys that have the same frequency),
                  the least recently used key would be evicted.

Note that the number of times an item is used is the number of calls to the
get and put functions for that item since it was inserted.
This number is set to zero when the item is removed.


Follow up:
Could you do both operations in O(1) time complexity?


Example:

LFUCache cache = new LFUCache( 2 // capacity // );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4


                            1(0)
                            /   \
                         2(1)    3(2)
                        /    \  /    \

HashMap = {key1: Node(key1, val1, count), key2: Node(key2, val2, count), ...}

FreqHashMap = {freq1: Dll(nodes), freq2: Dll(nodes), ...}

freq | Node(key, val, count)
  1  | Node1 -> Node2 -> ... -> NodeN
  2  | Node1 -> Node2 -> ... -> NodeN
 ... | ...
  n  | Node1 -> Node2 -> ... -> NodeN

LFUCache cache = new LFUCache( 2 // capacity // );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

Capacity (cap): 2
HashMap: {}
FreqHashMap: {1: Dll(empty)}
min: 1

put(1, 1)  HashMap.size(0) < cap (2)
HashMap: {1: Node(1, 1, 1)}
FreqHashMap: {1: Dll(HEAD <--> Node(1) <--> TAIL)}

put(2, 2)  HashMap.size(1) < cap (2)
HashMap: {1: Node(1, 1, 1), 2: Node(2, 2, 1)}
FreqHashMap: {1: Dll(HEAD <--> Node(2) <--> Node(1) <--> TAIL)}

get(1)
HashMap: {1: Node(1, 1, 2), 2: Node(2, 2, 1)}
FreqHashMap: {
  1: Dll(HEAD <--> Node(2) <--> TAIL),
  2: Dll(HEAD <--> Node(1) <--> TAIL),
}

put(3, 3)  # min
- if key doesn't exist, check if HashMap.size(2) == cap(2)
    - if size == cap,
        - get and remove tailNode from FreqHashMin(min),
          FreqHashMap: {
            1: Dll(HEAD <--> TAIL),
            2: Dll(HEAD <--> Node(1) <--> TAIL),
          }
       - delete that tailNode from hashMap
          HashMap: {1: Node(1, 1, 2)}
       - update min = 1
       - add the frequency 1,
          FreqHashMap: {
            1: Dll(HEAD <--> Node(3) <--> TAIL),
            2: Dll(HEAD <--> Node(1) <--> TAIL),
          }
       - add to hashMap
            HashMap: {1: Node(1, 1, 2) 3: Node(3, 3, 1)}
   - if size < cap
       - update min = 1
       - add the frequency 1,
          FreqHashMap: {
            1: Dll(HEAD <--> Node(3) <--> TAIL),
            2: Dll(HEAD <--> Node(1) <--> TAIL),
          }
       - add to hashMap
            HashMap: {1: Node(1, 1, 2) 3: Node(3, 3, 1)}

- if key exist,
   - get hashMap(key)
   - oldfreq = count
   - mutate the Node(key, newVal, count++)
   - remove from prev freq
   - update min
             1         1
     - if curMin == oldFreq and freqHashMap(min) is empty, min = min+1
   - add to freqHashMap:
      if oldfreq exists, insert at head,
      else, create newFreq and assign to LinkedList with node(key)

put(3, 3)  HashMap.size(2) == cap (2) | min = 1
HashMap: {1: Node(1, 1, 2), 3: Node(3, 3, 1)}
FreqHashMap: {
  1: Dll(HEAD <--> Node(3) <--> TAIL),
  2: Dll(HEAD <--> Node(1) <--> TAIL),
}

get(2)
HashMap: {1: Node(1, 1, 2), 3: Node(3, 3, 1)}
return -1

get(3)
HashMap: {1: Node(1, 1, 2), 3: Node(3, 3, 2)}
FreqHashMap: {
  1: Dll(HEAD <--> TAIL),
  2: Dll(HEAD <--> Node(3) <--> Node(1) <--> TAIL),
}
min = 2

put(4, 4)
min = 2  size == cap
HashMap: {3: Node(3, 3, 2), 4: Node(4, 4, 1)}
FreqHashMap: {
  1: Dll(HEAD <--> Node(4) TAIL),
  2: Dll(HEAD <--> Node(3) <--> TAIL),
}
min = 1

*/
