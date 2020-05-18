const array = [1, 2, 3, 4, -1, -3]
const target = 0

//using pointers: for each element, add from left and extreme right. If sum > target, reduce the right,
// else if less increase the left,
// else push to array and alter both left and right

function threeSumToTarget(array, target){
    let sums = []
    array = array.sort((a, b) => a - b)
    for (let i = 0; i < array.length - 2; i++){
        let left = i+1;
        let right = array.length - 1
        while (left < right){
            let cS = array[i] + array[left] + array[right];
            if (cS === target ) {
                sums.push([array[i], array[left], array[right]]);
                left++;
                right--;
            }
            else if (cS > target) right--;
            else if (cS < target) left++;
        }
    }
    return sums
}

console.log(threeSumToTarget(array, target))