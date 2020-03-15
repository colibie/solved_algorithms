//number of connected grids
function noOfOffices(rows, cols, grid){
    function isValid(x, y){
        if ( x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] < 1 ) return false;
        return true
    }

    function dfs(x, y){
        if (!isValid(x, y)) return;

        const row_dir = [-1, 1, 0, 0]
        const col_dir = [0, 0, -1, 1]

        grid[x][y] = -1;

        for (let i = 0; i<4; i++){
            if (isValid(x+row_dir[i],y+col_dir[i])){
                dfs(x+row_dir[i],y+col_dir[i]);
            }
        }
        return 1;
    }

    let count = 0;
    for(let i = 0; i<rows; i++){
        for(let j=0; j<cols; j++){
            if (isValid(i,j)){
                count = count + dfs(i,j);
            }
        }
    }
    return count;
}

console.log(noOfOffices(5,4,	[[1, 1, 0, 0],
                                [0, 0, 1, 0],
                                [0, 0, 0, 0],
                                [1, 0, 1, 1],
                                [1, 1, 1, 1]]))