// subsequence = arrangement of substrings in concurrent order ( adjacent?? I think)
function subsequence(word){
    // ive no idea what's going on here. I think this is brute force. Checked all letters
    // check below
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
// console.time('sub1');
// console.log(subsequence('dera'));
// console.timeEnd('sub1');

let res = []
function subsequence1(word){
    findSub(word, '');
    return res
}
function findSub(word, ans){
    if (word.length == 0) {
        if (res.includes(ans)) return;
        res.push(ans);
        return;
    }
    // find subsequences with current index
    findSub(word.substring(1), ans + word.charAt(0));
    // find subsequences without current index
    findSub(word.substring(1), ans);
}

// console.time('sub1');
// console.log(subsequence1('dera'));
// console.timeEnd('sub1')

function findSubsequence(word) {
    let res = ['']
    for(let i = 0; i < word.length; i++) {
        const resLen = res.length;
        for (let j = 0; j < resLen; j++) {
            // append each letter to the already found subsequences
            res.push(res[j].concat(word[i]))
        }
    }
    return res;
}
// console.time('sub3');
// console.log(findSubsequence('dera'));
// console.timeEnd('sub3')

function findSubsequenceArray(arr) {
    let res = [[]]
    for(let i = 0; i < arr.length; i++) {
        const resLen = res.length;
        for (let j = 0; j < resLen; j++) {
            // append each letter to the already found subsequences
            let temp = [...res[j]];
            temp.push(arr[i]);

            res.push(temp);
        }
    }
    return res;
}

console.time('sub4');
console.log(findSubsequenceArray([1, 2, 3, 4]));
console.timeEnd('sub4')
