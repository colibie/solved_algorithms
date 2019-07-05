/** given a string containing only the characters, 
 * (, ), {, }, [, ]. Check if the string is valid ie
 * that each closing bracket has a corresponding closing bracket
 * in the right order
 * eg [(((]))) is invalid
 * while {()[{}()]} is valid
 */

function isValid(brackets) {
  let stack = [], popped;
  let open = ['(', '{', '['];
  for (let i = 0; i < brackets.length; i++) {

    //check if the bracket is open and not at the end
    if (open.includes(brackets[i])) {
      if (i === brackets.length - 1) return false;
      stack.push(brackets[i]);
      continue;
    }

    // checks that stack is not empty since there's no open bracket
    if (stack.length === 0) return false;

    // checks that closing bracket corresponds with that of open
    switch (brackets[i]){
      case ')':
        popped = stack.pop();
        if ( popped !== '(') return false;
        break;
      
      case '}':
        popped = stack.pop();
        if ( popped !== '{') return false;
        break;
      
      case ']':
        popped = stack.pop();
        if ( popped !== '[') return false;
        break;
    }
  }
  return true;
}

// You can also solve for validity of brackets
//even with extra characters. eg [(a+b){a-b}]