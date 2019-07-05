/**Question: 
 * Find the angle between the hour and minutes hands
 * of a clock, given the time
 */

function angleBetween(time){
  let times = time.split(':');
  let hour = times[0];
  let min = times[1];
  hour = hour > 12 ? hour - 12: hour;
  let minAngle  = min * 6;
  let hourAngle = (hour * 30) + (min/2);
  let degreesBetween = Math.abs(hourDegree - minDegree);
  return degreesBetween;
}

// console.log(degreesBetween('2:30'));
// console.log(degreesBetween('24:00'));