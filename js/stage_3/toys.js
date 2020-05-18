function toys(w){
    w = w.sort((a, b) => a-b)
    let count = 1;
    let i = 0
    while (i < w.length){
        console.log(count)
        let currentNum = w[i];
        let next = currentNum + 4
        for (let j = i; j < w.length;){
            if (w[j] < next) {
                j++;
                i++
            }
            else{
                count++
                i = j
                break;
            }

        }
        
    }
    return count
    
}

console.log(toys([1, 2, 3, 21, 7, 12, 14, 21]))