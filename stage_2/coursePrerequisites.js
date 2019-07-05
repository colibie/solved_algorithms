//I'M NOT SURE IF THIS SOLUTION IS CORRECT--

// There are a total of n courses you have to take, labeled from 0 to n-1.
// Some courses may have prerequisites, 
// For example to take course 0 you have to first take
// course 1, which is expressed as a pair: [0,1]
// Given the total number of courses and a list of prerequisite pairs, is it possible for you to
// finish all courses? 
// For the course given below, it is not possible because
// for the first pair: 
// to take course 0, you have to take course 1
// and for the second pair:
// to take course 1, you have to take course 0,
// which is impossible.

let totalCourses = 2;
let courses = [[1, 0], [1, 0]];

function search(arr){
  let obj = {};
  for( let elm of arr){
    if (Object.keys(obj).includes(elm[0].toString()) 
    && obj[elm[0]] == elm[1]) return false;
    obj[elm[1]] = elm[0];
  }
  return true;
}
// console.log(search(courses));