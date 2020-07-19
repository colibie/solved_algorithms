// number of subsequences of string A that form string B
function subseqInAB(A, B){
    let sub = [];
    for (let i = 0; i < A.length; i++) {
        for (let j = i+1; j <= A.length; j++) {
            sub.push(A.substring(i,j));
        }
    }
    sub = sub.sort(function(a, b) {
        return b.length - a.length || // sort by length, if equal then
               a.localeCompare(b);    // sort by dictionary order
      });
      console.log(sub)
    let count = 0;
    sub.forEach(el => {
        
        let mat = new RegExp(el,"g");
        let sum = B.match(mat)
        if (sum) {
            count += sum.length;
            B=B.replace(mat, "*");
        }
    })
    if (B != Array(B.length).fill('*').join("")) return -1;
    return count;
    
}
console.log(subseqInAB('abcd', 'acbcd')) // a + c + bcd = 3
console.log(subseqInAB('abcd', 'acbcgd')) // -1, no arrangement