/*
 * Complete the 'fizzBuzz' function below.
 *
 * The function accepts INTEGER n as parameter.
 */

function fizzBuzz(n) {
  // Write your code here
  if (n % 3 == 0 && n%5 == 0) {console.log("FizzBuzz");}
  else if (n % 3 == 0 && n % 5 != 0) {console.log("Fizz");}
  else if (n % 5 == 0 && n % 3 != 0) {console.log("Buzz");}
  else { console.log(n) }

}

fizzBuzz(15);
fizzBuzz(5);
fizzBuzz(3);
