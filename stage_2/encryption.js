function encryption(s){
    s = s.replace(/\s/g, '')
    let res = ''
    let row = Math.floor(Math.sqrt(s.length));
    row === Math.sqrt(s.length) ? row = row - 1 : row;
    const col = Math.ceil(Math.sqrt(s.length))
    for(let j = 0; j <= row; j++){
        for(let i = j; i < s.length; i += col){
            res += s[i]
        }
        res += ' '
    }
    return res
}

console.log(encryption('iffactsdontfittotheorychangethefacts'))