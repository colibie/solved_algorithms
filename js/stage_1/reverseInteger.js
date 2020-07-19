/**
 * Given a signed integer, find it's reverse, 
 * while maintaining the sign
 */

const int = -2345; //output = -5432

function reverseInteger(value) {
  // const val = int.toString().split('').reverse().join('');
  // or
  const val = int.toString();
  let rev = '';
  for( let char of val) rev = char + rev;
  const result = Math.sign(value) * parseInt(rev);
  return result;
}
console.log(reverseInteger(int)); 
