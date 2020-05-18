function fibonacci(init, next, sum = (init % 2) === 0 ? init: 0){
  if (init < 0 || next < 0) return 'Init and next must be greater than 0'
  const term = init + next;
  if ((next % 2) === 0) sum += next;
  if (term > 4000000) return sum;
  return fibonacci(next, term, sum);
}

console.log(fibonacci(1, 2));