// split number into k, ignore leading zeros
function splitNum(number, k){
    let i = 0, rsl = [];
    while(i < number.length){
        let n = k, el = '';
        while(n > 0 && i < number.length){
            if (number[i] === "0" && el === '') i++;
            else if (number[i] === "0" && number[i+1] === undefined){
                el += number[i];
                i++;
                n--;
            }else {
                el += number[i];
                i++;
                n--;
            }
        }
        rsl.push(el)
    }
    return rsl;
}

console.log(splitNum('0050010020', 4))