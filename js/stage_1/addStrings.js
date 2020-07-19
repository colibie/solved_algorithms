/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var addStrings = function (num1, num2) {
  let nums = {}
  for (let i = 0; i < 10; i++) {
    nums[i] = i;
  }
  let sum = 0;
  let i = num1.length - 1;
  let j = num2.length - 1;
  while (i >= 0 || j >= 0) {
    if (i >= 0) { sum += nums[num1[i]]; }
    if (j >= 0) { sum += nums[num2[j]]; }
    res.push(sum % 10);
    sum = Math.floor(sum / 10);
    i--; j--;
  }
  if (sum > 0) res.push(sum);

  return res.reverse().join("");
};



/*
Given two non-negative integers num1 and num2 represented as string,
return the sum of num1 and num2.

Note:
The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.

You must not use any built-in BigInteger library or convert the inputs to integer directly.

*/

