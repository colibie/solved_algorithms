// Complete the viralAdvertising function below.
function viralAdvertising(n, sum = 0, shared = 5) {
  if (n == 0) return sum;
  let likedBy = Math.floor(shared/2);
  sum += likedBy;
  shared = likedBy * 3
  return viralAdvertising(n-1, sum, shared);
}

console.log(viralAdvertising(5))