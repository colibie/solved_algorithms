
function numberOfConnections(gridOfNodes) {
  // Write your code here
  const rows = gridOfNodes.length;
  const cols = gridOfNodes[0].length;
  let sum = 0;
  const noOfOnes = {}
  for (let row = 0; row < rows; row++) {
    let count = 0;
    for(let col = 0; col < cols; col++) {
      const el = gridOfNodes[row][col];
      if (el == 1) count++;
    }
    noOfOnes[row] = count;
  }

  for (let row = 0; row < rows - 1; row++) {
    if (noOfOnes[row] == 0) continue;
    for (let child = row+1; child < rows; child++) {
      if (noOfOnes[child] != 0) {
        sum = sum + (noOfOnes[child] * noOfOnes[row]);
        break;
      }
    }
  }
  return console.log(sum);
}

numberOfConnections([[1,0,1,1], [0,1,1,0], [0,0,0,0], [1,0,0,0]]);