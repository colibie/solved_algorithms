/* Question: 
Given an nxn matrix, compute the hourglass sum and return the max.
for example, given the matrix
[a1, a2, a3, a4
  b1, b2, b3, b4
  c1, c2, c3, c4
  d1, d2, d3, d4]
  It's possible hourglass would be
1. a1, a2, a3
      b2          ;sum = a1+a2+a3+b2+c1+c2+c3
   c1, c2, c3

2. a2, a3, a4
      b3          ;sum = sum them all;
   c2, c3, c4

3. b1, b2, b3
      c2
   d1, d2, d3

3. b2, b3, b4
       c3
   d2, d3, d4
*/

const DATA = [[-1, -1, 0, -9, -2, -2], [-2, -1, -6, -8, -2, -5], [-1, -1, -1, -2, -3, -4],
          [-1, -9, -2, -4, -4, -5], [-7, -3, -3, -2, -9, -9], [-1, -3, -1, -2, -4, -5]];

const hourGlassMax = (ar) => {
  let max = -Infinity;
  for(let i = 0; i < ar.length - 2; i++) {
    for(let j = 0; j < 4; j++) {
      //computing the sum of each hourglass figure
      const sum = ar[i][j] + ar[i][j+1] + ar[i][j+2] + ar[i+1][j+1] 
              + ar[i+2][j] + ar[i+2][j+1] + ar[i+2][j+2];
              
      //computing the max
      max = sum > max ? sum : max;
    }
  }
  return max;
}