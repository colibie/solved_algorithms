/**
 * Given a value, check if it's a palindrome. That is
 * the value is same when reversed, eg mum, 1001
 */

function palindrome(value){
  const val = value.toString();
  let rev = '';
  for (let char of val) rev = char + rev;
  if ( value === rev ) return true;
  return false;
}