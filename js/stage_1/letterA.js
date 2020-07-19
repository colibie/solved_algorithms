/**
 * Prints the capital letter A in asterisks
 * @param {*} n , the height of the letter
 */
function letterA(n) {
  let space = n;
  let string = "";
  for (let i = 1; i <= n; i++) {
    for (let k = 1; k <= space; k++) {
      string +=" ";
    }
    string += "*" ;
    for (let m = 1; m < 2 * i - 1; m++) {
      if (i == Math.ceil(n / 2)) { string += "*"; }
      else { string += " "; }
    }
    if (i != 1) string += "*";
    string += "\n";
    space--;
  }
  console.log(string);
}

letterA(7);