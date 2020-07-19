package medium;

/**
 * Given a list of items with values and weights, as well as a max weight, find
 * the maximum value you can generate from items, where the sum of the weights
 * is less than or equal to the max
 *
 * Eg
 * items = {(w: 1, v: 6), (w:2, v, 10), (w: 3, v: 12)}
 * max_weight = 5
 * knapsack(items, max_weight) = 22
 */

public class knapSack {
  private class Item {
    int weight;
    int value;
  }
  private static int getMax(Item[] items, int maxWeight) {
    // get max value, starting from 0
    return getMax(items, maxWeight, 0);
  }
  private static int getMax(Item[] items, int maxWeight, int idx) {
    if (idx > items.length) return 0;

    // if the current item's weight, greater than maxWeight, check the next item
    if (items[idx].weight > maxWeight) {
      return getMax(items, maxWeight, idx + 1);
    }

    return Math.max(getMax(items, maxWeight - items[idx].weight + items[idx].value, idx + 1) /*include cur */, 
                    getMax(items, maxWeight, idx+1) /*exclude cur*/);
  }
}
/** for each weight, you either add or not add it with the remaining items 
take the maximum weight you'll get between the two above
i = 0: adding 1 -> 18, not adding 1 -> i(2)
i = 1: adding 2 -> 10 + i(3), not adding 2 -> i(3)
i = 2: adding 3 -> 12, not adding 3 -> 0
it's a bit more complicated, take into considering that the weight must not exceed 5
thus, my result is 22

                                         5,i=0
                        /include 1                                \exclude 1
                     4,i=1,w=6                                     5,i=1,w=0
              /inc 2             \exc 2                         /inc 2          \exc 2 
        2,i=2,w=16             4,i=2,w=6                    3,i=2,w=10           5,i=2,w=0
      /inc 3    \exc 3       /inc3       \exc3            /inc 3   \exc 3        /inc 3  \exc      
      F         2,i=3,w=16  1,i=3,w=18  4,i=3,w=6    0,i=3,w=22   3,i=3,w=10  2,i=3,w=12   5,i=3,w=0
                end        end(Max here)    end      end(Maxhere)    end      end            end
              
*/