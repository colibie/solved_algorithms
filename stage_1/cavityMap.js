function cavityMap(grid) {
  let len = grid.length
  for (let i = 1; i <= len-2; i++){
      for (let j = 1; j<=len-2; j++){
          if ((grid[i][j] > grid[i+1][j]) &&
              (grid[i][j] > grid[i-1][j]) &&
              (grid[i][j] > grid[i][j+1]) &&
              (grid[i][j] > grid[i][j-1])) {
                let str = grid[i].split('');
                str.splice(j, 1, 'X');
                grid[i] = str.join('')
          }                
      }
  }
  return grid;

}

console.log(cavityMap(['1112', '1912','1892','1234']));