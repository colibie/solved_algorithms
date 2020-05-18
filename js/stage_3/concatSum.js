function concatenationsSum(a) {
    let sum = 0;
    for (let i = 0; i < a.length; i++){
        //go forward
        for (let j = i; j < a.length; j++){
            let concat = a[i] + `${a[j]}`
            console.log(concat)
            sum += parseInt(concat)
        }

        // go backward
        for (let k = i - 1; k >= 0; k--){
            let concat = a[i] + `${a[k]}`
            console.log(concat)
            sum += parseInt(concat)
        }
    }
    return sum;
}

console.log(concatenationsSum([10, 2]))