/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * Example 1:
 * Input: 123
 * Output: "One Hundred Twenty Three"
 */


const unit = ['', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine'];
const tens = ['', 'ten', 'twenty', 'thirty', 'fourty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety'];
const above10 = ['', 'eleven', 'twelve', 'thirteen', 'fouteen', 'fifteen', 'sixteen', 'seventeen', 'eighteen', 'nineteen'];

function english(num){
  let str = '';
  let arr = []
  num = num.toString().split('');
  while(num.length != 0){
    len = num.length - 1;
    arr.push(num[num.length-1]);
      switch(arr.length){
        case 1: {
          str = unit[num[len]]+ str;
          num.pop();
          break;
        }
        case 2: {
          str = tens[num[len]] + ' ' + str;
          num.pop();
          break;
        }
        case 3: {
          str = unit[num[len]] + ' Hundred' + ' ' + str;
          num.pop();
          break;
        }
        case 4: {
          if (`${num[len-1]}` + num[len].toString() < 20){
            str = above10[num[len]] + ' thousand' + ' ' + str;
            num.pop();
            num.pop();
            break;
          }
          else{
            str = unit[num[len]] + ' Thousand' + ' ' + str;
            num.pop();
            break;
          }
        }
        case 5: {
          str = tens[num[len]] + ' ' + str;
          num.pop();
          break;
        }
        case 6: {
          str = unit[num[len]] + ' Hundred' + ' ' + str;
          num.pop();
          break;
        }
        case 7: {
          str = unit[num[len]] + ' Million' + ' ' + str;
          num.pop();
          break;
        }
        case 8: {
          if (`${num[len-1]}` + num[len].toString() < 20){
            str = above10[num[len]] + ' thousand' + ' ' + str;
            num.pop();
            num.pop();
            break;
          }
            else{
            str = tens[num[len]] + ' ' + str;
            num.pop();
            break;
          }
        }
        case 9: {
          str = unit[num[len]] + ' Hundred' + str;
          num.pop();
          break;
        }
        case 10: {
          str = unit[num[len]] + ' Billion' + str;
          num.pop();
          break;
        }
      }
    }
    return str;
  }

  console.log(english(123476));