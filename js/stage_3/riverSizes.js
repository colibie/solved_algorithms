// print the number of each group of connected cells in a grid

function riverSizes(matrix) {
    // Write your code here.
      const rows = matrix.length;
      const columns = matrix[0].length;
      
      function isValid(x, y){
          if (x < 0 || y < 0 || x >= rows || y >= columns || matrix[x][y] < 1) return false;
          return true;
      }

      let count = 0;
      
      function dfs(x, y){
          if (!isValid(x, y)) return;
          const x_dir = [-1, 1, 0, 0]
          const y_dir = [0, 0, 1, -1]
          matrix[x][y] = -1;
          
          for(let i = 0; i < 4; i++){
              if (isValid(x + x_dir[i], y + y_dir[i])){
                    count += 1;
                  dfs(x+x_dir[i], y+y_dir[i])
              }
          }
      }
      //start
      let result = []
      for (let i = 0; i < rows; i++){
          for (let j = 0; j < columns; j++){
              if (isValid(i, j)){
                  count = 1;
                  dfs(i, j);
                  result.push(count);
              }              
              
          }
      }
      console.log(result)
  }

  let matrix = [
      [1, 0, 0, 1, 0],
      [1, 0, 1, 0, 0],
      [0, 0, 1, 0, 1],
      [1, 0, 1, 0, 1],
      [1, 0, 1, 1, 0]
  ]

riverSizes(matrix)