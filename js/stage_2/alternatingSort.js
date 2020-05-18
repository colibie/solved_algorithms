function alternatingSort(a) {
    let left = 0;
    let right = a.length - 1;
    while (left <= right){
        console.log(a[left], a[right])
        if (a[left] > a[right]) return false;
        else if (left === right && a[left] < a[right + 1]) return false
        left++;
        right--;
    }
    return true
}

console.log(alternatingSort([-92, -23, 0, 45, 89, 96, 99, 95, 89, 41, -17, -48]))