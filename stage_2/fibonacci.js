function fibonacci(n){
  let init = 0, next = 1, term = 0;
  for(let i = 0; i<n; i++){
    term = init + next;
    init = next;
    next = term;
  }
  let result = term % (Math.pow(10, 8) + 7);
  return result
}
console.log(fibonacci(1))