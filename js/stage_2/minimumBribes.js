// Complete the minimumBribes function below. See question below
function minimumBribes(q) {
  let sum = 0;
  for(let i = 0; i < q.length; i++) {
      if (q[i] <= i + 1) continue;
      let dis = q[i] - 1 - i;
      if (dis > 2) return console.log("Too chaotic");
      sum += dis;
  }
  return console.log(sum);
}

minimumBribes([2,1,5,3,4]);
minimumBribes([2,5,1,3,4]);

/**It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride! 
 * There are a number of people queued up, and each person wears a sticker indicating their 
 * initial position in the queue. Initial positions increment by 1 from 1at the front of the line to
 * n at the back.

Any person in the queue can bribe the person directly in front of them to swap positions. If two people swap positions, they still wear the same sticker denoting their original places in line. One person can bribe at most two others. For example, if
and Person 5 bribes Person 4, the queue will look like this: 1, 2, 3, 4, 5, 6, 7,8.

Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state! */