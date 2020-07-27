function islandCount(binaryMatrix) {
    // your code goes here
    let currentIsland = 1;
    let sub = 0;
    for(let i = 0; i < binaryMatrix.length; i++){
      for(let j = 0; j < binaryMatrix[i].length; j++){
        if(binaryMatrix[i][j] === 1){
          // keep count of islands as you go and merge islands

          let above = binaryMatrix[i-1] ? binaryMatrix[i-1][j] : 0
          let left = binaryMatrix[i][j-1] ? binaryMatrix[i][j-1] : 0
          if(above >= 1 && left >= 1 && left !== above){
            binaryMatrix[i][j] = binaryMatrix[i-1][j];
            binaryMatrix[i][j-1] = binaryMatrix[i-1][j];
            sub--; // merge island cause you must've seen either left or above before.
          } else if(left >= 1){
             binaryMatrix[i][j] = binaryMatrix[i][j-1];
          } else if(above >= 1){
             binaryMatrix[i][j] = binaryMatrix[i-1][j];
          } else {
            binaryMatrix[i][j] = currentIsland + 1; // new island
            currentIsland++;
            console.log(currentIsland)
          }
        }
      }
    }
    return currentIsland - 1 + sub;
}
/**
[1, 0, 2, 0]
[0, 2, 2, 2]
[0, 0, 2, 0]
[3, 0, 0, 0]
 */
