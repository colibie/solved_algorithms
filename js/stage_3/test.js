function queensAttack(rows, noOfObstacles, r_q, c_q, obstacles){
    // helper functions
    function isValid(row, col){
        if (row < 0 ||  col < 0 ||  row >= rows ||  col >= rows) return false
        return true;
    }

    function hasObstacleOnDia(row, col){
        let distance = Infinity, cods;
        let length = obstacles != undefined ? obstacles.length : noOfObstacles;
        if (length > 0) {
            for (let i = 0; i < obstacles.length; i++){
                console.log(row, col, obstacles[i][0] - 1, obstacles[i][1] - 1)
                let x_dia = Math.abs(row - obstacles[i][0] - 1);
                let y_dia = Math.abs(col - obstacles[i][1] - 1);
                if (x_dia === y_dia){
                    if (distance > Math.max(x_dia, y_dia)) {
                        distance = Math.max(x_dia, y_dia);
                        console.log('here')
                        cods = [obstacles[i][0] - 1, obstacles[i][1] - 1]
                        obstacles.splice(i, 1)
                        i = i - 1;
                    }
                }
            }
            return cods || false;
        }    
    }

    function hasObstacleOnRow(row){
        let distance = Infinity, cods;
        let length = obstacles != undefined ? obstacles.length : noOfObstacles;
        if (length > 0) {
            for (let i = 0; i < obstacles.length; i++){
                console.log(row, obstacles[i][0] - 1, obstacles[i][1] - 1)
                if (row === obstacles[i][0] - 1){
                    if (distance > Math.abs(rq - obstacles[i][0] - 1)) {
                        distance = Math.abs(rq - obstacles[i][0] - 1);
                        console.log('here')
                        cods = [obstacles[i][0] - 1, obstacles[i][1] - 1]
                        obstacles.splice(i, 1)
                        i = i - 1;
                    }
                }
            }
            return cods || false;
        }    
    }

    function hasObstacleOnCol(col){
        let distance = Infinity, cods;
        let length = obstacles != undefined ? obstacles.length : noOfObstacles;
        if (length > 0) {
            for (let i = 0; i < obstacles.length; i++){
                console.log(col, obstacles[i][0] - 1, obstacles[i][1] - 1)
                if (col === obstacles[i][1] - 1){
                    if (distance > Math.abs(cq - obstacles[i][1] - 1)) {
                        distance = Math.abs(cq - obstacles[i][1] - 1);
                        console.log('here')
                        cods = [obstacles[i][0] - 1, obstacles[i][1] - 1]
                        obstacles.splice(i, 1)
                        i = i - 1;
                    }
                }
            }
            return cods || false;
        }    
    }

    let total = 0
    const cq = c_q - 1
    const rq = r_q - 1

    function getDis(calc, cod){            
            if (cod){
                total += Math.max(Math.abs(rq - cod[0]), Math.abs(cq - cod[1])) -1
            } else {
                total += calc
            }
        }
    
    if (isValid(rq, cq)){
        // cordinates for up-left, up, up-right, right, down-right, down, down-left and left
        let rowNum = [-1, -1, -1, 0, 1, 1, 1, 0]
        let colNum = [-1, 0, 1, 1, 1, 0, -1, -1]

        // case up-left
        if (isValid(rq + rowNum[0], cq + colNum[0])){
            const calc = Math.min(rq, cq)
            const cod = hasObstacleOnDia(rq + rowNum[0], cq + colNum[0])

            getDis(calc, cod)
        }

        // case up
        if (isValid(rq + rowNum[1], cq + colNum[1])){
            const calc = Math.abs(rq)
            const cod = hasObstacleOnCol(cq + colNum[1])
            getDis(calc, cod)
        }

        // case up-right
        if (isValid(rq + rowNum[2], cq + colNum[2])){
            const calc = Math.min(rq, Math.abs(rows - 1 - cq))
            const cod = hasObstacleOnDia(rq + rowNum[2], cq + colNum[2])
            getDis(calc, cod)
        }

        // case right
        if (isValid(rq + rowNum[3], cq + colNum[3])){
            const calc = Math.abs(rows - 1 - cq)
            const cod = hasObstacleOnRow(rq + rowNum[3])
            getDis(calc, cod)        }

        // case down-right
        if (isValid(rq + rowNum[4], cq + colNum[4])){
            const calc = Math.min(Math.abs(rows - 1 - rq), Math.abs(rows - 1 - cq))
            const cod = hasObstacleOnDia(rq + rowNum[4], cq + colNum[4])
            getDis(calc, cod)        }

        // case down
        if (isValid(rq + rowNum[5], cq + colNum[5])){
            const calc = Math.abs(rows - 1 - cq)
            const cod = hasObstacleOnCol(cq + colNum[5])
            getDis(calc, cod)        
        }

        // case down-left 
        if (isValid(rq + rowNum[6], cq + colNum[6])){
            const calc = Math.min(Math.abs(rows - 1 - rq), cq)
            const cod = hasObstacleOnDia(rq + rowNum[6], cq + colNum[6])
            getDis(calc, cod)        
        }

        // case left
        if (isValid(rq + rowNum[7], cq + colNum[7])){
            const calc = Math.abs(cq)
            const cod = hasObstacleOnRow(rq + rowNum[7])
            getDis(calc, cod)        
        }
    }
    return total
}

// let ar = []
// ar[5] = 'good'
// ar[4] = []
// ar[4][2] = 'here'
// console.log(ar[2], ar[5], ar)

// console.log(queensAttack(88587,9,20001, 20003, [[20001, 20002],
//                                 [20001, 20004],
//                                 [20000, 20003],
//                                 [20002, 20003],
//                                 [20000, 20004],
//                                 [20000, 20002],
//                                 [20002, 20004],
//                                 [20002, 20002],
//                                 [564, 323]]))

console.log(queensAttack(5,3,4, 3, [[5, 5],
                                [4, 2],
                                [2, 3]])) //10

//console.log(queensAttack(4,0,4, 4)) //9

// console.log(queensAttack(100000,0,4187, 5068))