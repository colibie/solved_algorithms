function connectedGrid(rows, cols, grid){
    function isValid(row, col){
        if (    row < 0 
            ||  col < 0 
            ||  row >= rows 
            ||  col >= cols 
            ||  grid[row][col] < 1
        ) {
            return false;
        }
        else {
            return true;
        }
    }

    // Stores size of current largest region
    let maxVal = 0, count=0;
    function dfs(row, col){
        // cordinates for up, down, right and left
        let rowNum = [-1, 1, 0, 0]
        let colNum = [0, 0, 1, -1]

        //mark grid as visited
        grid[row][col] = -1;

        for(let i = 0; i < 4; i++){
            if (isValid(row + rowNum[i], col + colNum[i])){
                count +=1
                dfs(row + rowNum[i], col + colNum[i])
            }
        }
    }

    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < cols; j++) {
            if (isValid(i, j)){
                count = 1;
                dfs(i, j);
                if(count > maxVal) {
                    maxVal = count; 
                }
            }
        }
    }
    return maxVal;
}

console.log(connectedGrid(4,5,	[[1, 0, 1, 1, 1],
                                [1, 0, 1, 1, 1],
                                [1, 0, 1, 1, 1],
                                [0, 1, 0, 0, 0]]))