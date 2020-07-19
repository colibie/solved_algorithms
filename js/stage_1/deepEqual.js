/**Given two values, check if they are equal
 * ie have the same values
 */

function deepEqual(obj1, obj2) {
  if (obj1 === obj2) return true;
  else if ((typeof(obj1) === 'object' && obj1 !== null) 
  && (typeof(obj2) === 'object' && obj2 !== null)) {
    //first check to see that they have same number of keys
    if (Object.keys(obj1).length !== Object.keys(obj2).length) return false;
    //check each property
    for (let prop in obj1){
      if (obj2.hasOwnProperty(prop)){
        if (!deepEqual(obj1[prop], obj2[prop])) return false;
      } else return false
    }
    return true;
  }
  else return false
}

let obj1 = {data: 1, left: {right: 1}};
let obj2 = {data: 1, left: {right: {right: 3}}};
console.log(deepEqual(obj1, obj2));