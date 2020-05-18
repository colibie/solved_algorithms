// subsequence = arrangement of substrings in concurrent order ( adjacent?? I think)
function subsequence(word){
    let node = "";
    let subseq = [], fringe = []
    word = word.split('');
    for(let i = 0; i<word.length; i++){
        node = word[i];
        subseq.push(word[i])
        fringe.push(word[i])
        while (fringe.length != 0){
            let el = fringe.shift();
            let start = word.indexOf(el.charAt(el.length - 1)) + 1;
            for (let j = start; j<word.length; j++){
                let notRepeated = el + word[j];
                if (!subseq.includes(notRepeated)){
                    subseq.push(notRepeated);
                    fringe.push(notRepeated);
                }
            }        
        }

    }
    return subseq

}
let res = []
function subsequence1(word){
    findSub(word, '');
    return res
}
function findSub(word, ans){
    console.log( ans,'-', word)
    if (word.length == 0) {
        if (res.includes(ans)) return;
        res.push(ans);
        return;
    }
    findSub(word.substring(1), ans + word.charAt(0));
    findSub(word.substring(1), ans);
}

//console.log(subsequence('apple'))
console.log(subsequence1('abc'))
