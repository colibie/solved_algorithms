function solve(x, value = '4') {
  let a = value.lastIndexOf('4');
  let b = value.length - a - 1;
  if (x <= Number(value)){

      if ((Number(value) % x) === 0) {
        return (2*(a+1))+b;
      }
  }
  if (value[a+1] == 0) {
    value = '4'.repeat(a+2) + '0'.repeat(b-1)
    return solve(x, value);
  }
  if(value[a+1] === undefined){
    value = '4' + '0'.repeat(a+1);
    return solve(x, value);
  }
}

console.log(solve(81));