function findDigits(n) {
  n = ''+n+'';
  let count = 0;
  let split = n.split('');
  for (let i of split){
      if(n % Number(i) === 0) count++;
  }
  return count

}

console.log(findDigits(55))