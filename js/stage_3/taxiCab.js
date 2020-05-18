/**
 * returns the taxicab value of a given number.
 * A taxicab number is a number that is a sum of the cube of two different numbers in n ways.
 * Eg the taxicab value of 5 would have 5 instances a sum of cube of two numbers.
 * There are two versions of taxicab numbers
 * The running time of the algorithm below is too expensive.
 */

class TaxiCab {
  constructor(k) {
    this.k = k;
    this.hash = {};
  }

  solve() {
    
    let value, stop = false;
    let n;
    if (this.k < 6) n = Math.pow(10, this.k + 1) - 1;
    else if (this.k > 6 && this.k < 9) n = Math.pow(10, this.k + Math.ceil(this.k/2)) - 1;
    else n = Math.pow(10, this.k*2) - 1;
    for (let i = 1; i < n; i++) {
      for (let j = 1; j < n; j++) {
        if (j < i) continue;
        value = Math.pow(i, 3) + Math.pow(j, 3);
        this.hash[value] = this.hash[value] == null ? 1 : this.hash[value] + 1;
        if (this.hash[value] == this.k) {
          stop = true;
          break;
        }
      }
      if (stop) break;
    }
    return value;
  }
}

let sample = new TaxiCab(5);
console.log(sample.solve());

function taxiCab(k) {
  let num = 2, hash = {}, stop = false, res; // base num
  while (!stop) {
    for (let i = 1; i < Math.cbrt(num); i++) {
      // check if taxicab ie a3 + b3 = num
      let value = Math.cbrt(num - Math.pow(i, 3));
      if (value < i) continue;
      if (Number.isInteger(value)) {
        hash[num] = hash[num] == null ? 1 : hash[num] + 1;
        if (hash[num] == k) {
          stop = true;
          res = num;
          break;
        }
      }
    }
    num++;
  }
  return res;
}

// console.log(taxiCab(3));