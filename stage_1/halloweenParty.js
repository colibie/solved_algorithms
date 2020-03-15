function halloweenParty(k) {
    /*
     * Write your code here.
     */
    let horizontal = Math.floor(k/2);
    let vertical = Math.ceil(k/2)
    return horizontal*vertical

}

console.log(halloweenParty(8))