function mergeStrings(s1, s2) {
    // create a hashtable for each
    let left = 0;
    let right = 0;
    let res = []
    while (left < s1.length || right < s2.length){
        if (s1[left] < s2[right]){
            res.push(s1[left])
            left++
        }else if (s2[right] < s1[left]){
            res.push(s2[right]);
            right++
        }else {
            res.push(s1[left])
            res.push(s2[right])
            left++
            right++
        }
    }
    return res.join('')
}

let ar1 = 'dce';
let ar2 = 'cccbd'; //dcecccbd

console.log(mergeStrings(ar1, ar2))