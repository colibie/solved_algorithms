// calculate number of flavors you can buy with the money

function whatFlavors(cost, money) {
  const costHash = {};
  for(let i = 0; i < cost.length; i++) {
      costHash[cost[i]] = i+1;
  }

  for(let i = 0; i < cost.length; i++) {
      let diff = money - cost[i];
      if (i+1 == costHash[diff]) continue;
      if (costHash[diff]) {
          const res = costHash[diff] > i+1 ? `${i+1} ${costHash[diff]}` : `${costHash[diff]} ${i+1}`;
          console.log(res);
          return res;
      }
  }

}

whatFlavors([7,2,5,4,11], 12);
whatFlavors([4,3,2,5,7], 8);