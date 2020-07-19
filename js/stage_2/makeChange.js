/**
 * Given an integer representing a given amount of change, 
 * write a function to compute the min total amount of coins required to make that amount of change.
 * You can assume that there's always a N1 coin
 * Eg given coins = {1, 5, 10, 25}
 * makeChange(1) = 1 (1)
 * makeChange(6) = 2 (5 + 1)
 * makeChange(49) = 7 (25 + 10 + 10 + 1 + 1 + 1 + 1);
 */

/**
 * Brute force checks all possible combinations of change and returns the min
 * @param {Number[]} coins 
 * @param {Number} target 
 */
// 25        [10, 6, 1]
/**

 */
function bruteForce(target, coins) {
  if (target === 0) return 0;

  let minCoins = Infinity;
  // check all combinations by removing each coin
  for (const coin of coins) {
    if (target - coin < 0) continue; // we can't make change with this current coin, so next one
    let curMinCoins = 1 + bruteForce(target - coin, coins);
    if (curMinCoins < minCoins) {
      minCoins = curMinCoins;
    }
  }
  return minCoins;
}

// Since each make coin calls a subproblem, we will see from the graph that we can optimize it
/** [10, 6, 1] a = -10, b = -6, c = -1
 *                                    25
 *                                /a     \
 *                               15
 *                        /a     |b    \c
 *                      5        9     14
 *                  /a |b \c /a |b \c    ...
 *                 F   F   4 F   3   8
 *                        ...   ...  ...
 *                            
 * 
 */
function DPTopDown(target, coins) {
  // initialize cache
  return DPTopDownHelper(target, coins, [0]);
}

function DPTopDownHelper(target, coins, cache) {
  if (cache[target] !== undefined) return cache[target];

  let minCoins = Infinity;
  // check all combinations by removing each coin
  for (const coin of coins) {
    if (target - coin < 0) continue; // we can't make change with this current coin, so next one
    let curMinCoins = 1 + DPTopDownHelper(target - coin, coins, cache);
    if (curMinCoins < minCoins) {
      minCoins = curMinCoins;
    }
  }
  cache[target] = minCoins;
  return cache[target];

}

// calculate the amount of coins needed to make change from 1 up till target - 1, then get for target
// this works because there is always a one dollar coin or maybe not. What do you think?

function DPBottomUp(target, coins) {
  const cache = [0];
  for(let i = 1; i <= target; i++) {
      let minCoins = Infinity;

      for (const coin of coins) {
        if (i - coin < 0) continue;
        let curMinCoins = 1 + cache[i-coin];
        if (curMinCoins < minCoins) {
          minCoins = curMinCoins;
        }
      }
      cache[i] = minCoins;
  }
  return cache[target];
}
console.time("bruteForce");
console.log(bruteForce(49, [1, 5, 10, 25]));
console.timeEnd("bruteForce");

console.time("DPTopDown");
console.log(DPTopDown(49, [1, 5, 10, 25]));
console.timeEnd("DPTopDown");

console.time("DPBottomUp");
console.log(DPBottomUp(49, [1, 5, 10, 25]));
console.timeEnd("DPBottomUp");
