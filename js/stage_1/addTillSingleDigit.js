/**
 * Given an integer, add it's digits till it results to a single digit
 */

function addRepeatedly(num){
  let val = num.toString();
  if (val.length == 1) return parseInt(val);
  val = val.split('');
  let result = val.reduce((prev, next) => {
    return parseInt(prev) + parseInt(next);
  }, 0);
  return addRepeatedly(result);
}

// console.log(addRepeatedly(119));