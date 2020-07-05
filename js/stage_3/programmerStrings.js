// Incorrect

// consider implementing lookups
function programmerStrings(str) {
  let strLen = str.length;
  let FWi
  let SWi

  if (strLen < 10 || strLen <= 20) return 0

  for (let i = 9; i < strLen - 1; i++) {
       let testStr = str.substring(0, i)
       var patt = new RegExp("(([programer][a-z]{0,}){1}|(m[a-z]{0,}){1}){10}$");
       let match = patt.test(testStr);

       if (match) {
            FWi = i
            break
       }
  }

  if (isNaN(FWi)) return 0

  if ((strLen - FWi) < 11) return 0

  let s = strLen - 10
  let xx = (strLen - FWi) - 10

  for (let k = s; k > xx; k--) {
       let testStr = str.substring(k, strLen)
       // if( i <= FWi ) return 0
      //  var patt = new RegExp("^[progra(m){2}era-z]{10,}$");
       var patt = new RegExp("(([programer]([a-z]){0,}){1}|(m[a-z]{0,}){1}){10}$");
       let match = patt.test(testStr);

       if (match) {
            SWi = k
            break
       }
  }

  return SWi - FWi - 1
}

console.log(programmerStrings("xppbroraxmmverxxxxprproxgracmmer"))