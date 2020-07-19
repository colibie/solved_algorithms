/**
 * Count the number of prime numbers less than a non-negative number, num.         
 * @param {*} num any num  
 */

function isPrime(num){
  for (let i = 2; i< 10; i++){
    if ((num % i) == 0 && (num != i)) return false;
  }
  return true;
}

function primes(num){
  let count = 0;
  if (num == 1 || num < 1) return 0;
  for (let i = 2; i < num; i++){
    if (isPrime(i)) {
      console.log(i)
      count++;
    }
    }
  return count;
}

console.log(primes(25));