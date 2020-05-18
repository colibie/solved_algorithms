//max stack exceeded for large data set, see queensAttackII

function queensAttackv1(rows, noOfObstacles, r_q, c_q, obstacles){
    // helper functions
    function isValid(row, col){
        if (row < 0 ||  col < 0 ||  row >= rows ||  col >= rows ||  grid[row][col] < 1) return false
        return true;
    }
    
    function dfs(row, col, dir_x, dir_y){
        //mark grid as visited        
        grid[row][col] = -1;
        console.table(grid)
        if (isValid(row + dir_x, col + dir_y)){
            count +=1
            //keep going in that direction
            dfs(row + dir_x, col + dir_y, dir_x, dir_y)
        }
    }

    //end of helper functions

    //set grid and initialize count
    let grid = [], count = 0;
    for (let i = 0; i < rows; i++){
        const set = Array(rows).fill(1);
        grid.push(set)
    }
    // set obstacles, in reverse direction
    for (let i = 0; i < noOfObstacles; i++){
        grid[rows - obstacles[i][0]][obstacles[i][1] - 1] = -1
    }

    if (isValid(rows - r_q, c_q - 1)){

        // cordinates for up-left, up, up-right, right, down-right, down, down-left and left
        let rowNum = [-1, -1, -1, 0, 1, 1, 1, 0]
        let colNum = [-1, 0, 1, 1, 1, 0, -1, -1]

        //mark grid as visited
        grid[rows - r_q][c_q - 1] = -1;

        for(let i = 0; i < 8; i++){
            if (isValid(rows - r_q + rowNum[i], c_q - 1 + colNum[i])){
                count +=1
                dfs(rows - r_q + rowNum[i], c_q - 1 + colNum[i], rowNum[i], colNum[i])
            }
        }
    }
    
    return count;
}

function queensAttack(rows, noOfObstacles, r_q, c_q, obstacles){
    // helper functions
    function isValid(row, col){
        if (row < 0 ||  col < 0 ||  row >= rows ||  col >= rows) return false
        else if (grid[row] && grid[row][col] === -1) return false
        return true;
    }
    
    function dfs(row, col, dir_x, dir_y){
        //mark grid as visited
        if ( grid[row] == undefined) grid[row] = []        
        grid[row][col] = -1;
        if (isValid(row + dir_x, col + dir_y)){
            count +=1
            //keep going in that direction
            dfs(row + dir_x, col + dir_y, dir_x, dir_y)
        }
    }

    //end of helper functions

    //set grid and initialize count
    let grid = [], count = 0;

    // set obstacles, in reverse direction
    for (let i = 0; i < noOfObstacles; i++){
        if (grid[rows - obstacles[i][0]] == undefined) grid[rows - obstacles[i][0]] = []
        grid[rows - obstacles[i][0]][obstacles[i][1] - 1] = -1
    }

    if (isValid(rows - r_q, c_q - 1)){

        // cordinates for up-left, up, up-right, right, down-right, down, down-left and left
        let rowNum = [-1, -1, -1, 0, 1, 1, 1, 0]
        let colNum = [-1, 0, 1, 1, 1, 0, -1, -1]

        //mark grid as visited
        if (grid[rows - r_q] == undefined) grid[rows - r_q] = []
        grid[rows - r_q][c_q - 1] = -1;

        for(let i = 0; i < 8; i++){
            if (isValid(rows - r_q + rowNum[i], c_q - 1 + colNum[i])){
                count +=1
                dfs(rows - r_q + rowNum[i], c_q - 1 + colNum[i], rowNum[i], colNum[i])
            }
        }
    }
    
    return count;
}

// console.log(queensAttack(88587,9,20001, 20003, [[20001, 20002],
//                                 [20001, 20004],
//                                 [20000, 20003],
//                                 [20002, 20003],
//                                 [20000, 20004],
//                                 [20000, 20002],
//                                 [20002, 20004],
//                                 [20002, 20002],
//                                 [564, 323]]))

console.log(queensAttackv1(5,3,4, 3, [[5, 5],
                                [4, 2],
                                [2, 3]]))

// console.log(queensAttack(4,0,4, 4))

// console.log(queensAttackv1(100000,0,4187, 5068))