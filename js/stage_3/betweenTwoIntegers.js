// Incorrect???

function betweenTwoIntegers(a, b){
    const maxA = Math.max(...a)
    const maxB = Math.max(...b)
    let factorA = []
    let factorB = []
    for (let i = maxA, j = 1; i <= maxB; i = maxA*++j ){
        let factor = true;
        for(let el of a){
            if (i%el != 0) {
                factor = false;
                break;
            }
        }
        factor ? factorA.push(i) : ''
    }

    for (let i = 0; i < factorA.length; i++ ){
        let factor = true;
        for(let el of b){
            if (el%factorA[i] != 0) {
                factor = false;
                break; 
            }  
        }
        factor ? factorB.push(factorA[i]) : ''
    }
    return factorB.length
}

console.log(betweenTwoIntegers([2,4], [16 ,32 ,96]))