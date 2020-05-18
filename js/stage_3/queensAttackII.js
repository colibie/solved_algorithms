// find how many moves a queen can make in all direction with specified obstacles

function queensAttackII(n, noOfObstacles, rQueen, cQueen, obstacles){
        let rRObstacle = -1;
        let cRObstacle = -1;
        let rBRObstacle = -1;
        let cBRObstacle = -1;
        let rBObstacle = -1;
        let cBObstacle = -1;
        let rBLObstacle = -1;
        let cBLObstacle = -1;
        let rLObstacle = -1;
        let cLObstacle = -1;
        let rTLObstacle = -1;
        let cTLObstacle = -1;
        let rTObstacle = -1;
        let cTObstacle = -1;
        let rTRObstacle = -1;
        let cTRObstacle = -1;
        
        //Total squares attacked by the queen
        let reachableSquares = 0;
        
        //Finds the closest object in each direction
        for(let i = 0; i < noOfObstacles; i++){
            let rObstacle = obstacles[i][0];
            let cObstacle = obstacles[i][1];
            
            //Right
            // if obstacle is closer to queen or no obstacle yet, and obstacle on the right of queen and on same row
            if((cObstacle < cRObstacle || rRObstacle == -1) && cObstacle > cQueen && rObstacle == rQueen)
            {
                rRObstacle = rObstacle;
                cRObstacle = cObstacle;
            }
            
            //Bottom Right
            //if on same slope as queen, right and bottom of quuen and obstacle closer to queen or no obstacle yet
            if(rQueen - rObstacle == cObstacle - cQueen && cObstacle > cQueen && rObstacle < rQueen 
               && ((rObstacle > rBRObstacle && cObstacle < cBRObstacle) || rBRObstacle == -1))
            {
                rBRObstacle = rObstacle;
                cBRObstacle = cObstacle;
            }
            
            //Bottom    
            // If closer to queen or not found && below the queen and on same column
            if((rObstacle > rBObstacle || cBObstacle == -1) && rObstacle < rQueen && cObstacle == cQueen)
            {
                rBObstacle = rObstacle;
                cBObstacle = cObstacle;
            }
            
            //Bottom Left
            if(rQueen - rObstacle == cQueen - cObstacle && cObstacle < cQueen && rObstacle < rQueen 
               && ((rObstacle > rBLObstacle && cObstacle > cBLObstacle) || rBLObstacle == -1))
            {
                rBLObstacle = rObstacle;
                cBLObstacle = cObstacle;
            }
            
            //Left
            if((cObstacle > cLObstacle || rLObstacle == -1) && cObstacle < cQueen && rObstacle == rQueen)
            {
                rLObstacle = rObstacle;
                cLObstacle = cObstacle;
            }
            
            //Top Left
            if(cQueen - cObstacle == rObstacle - rQueen && cObstacle < cQueen && rObstacle > rQueen 
               && ((rObstacle < rTLObstacle && cObstacle > cTLObstacle) || rTLObstacle == -1))
            {
                rTLObstacle = rObstacle;
                cTLObstacle = cObstacle;
            }
            
            //Top
            if((rObstacle < rTObstacle || cTObstacle == -1) && rObstacle > rQueen && cObstacle == cQueen)
            {
                rTObstacle = rObstacle;
                cTObstacle = cObstacle;
            }
            
            //Top Right
            if(rObstacle - rQueen == cObstacle - cQueen && cObstacle > cQueen 
               && rObstacle > rQueen && ((rObstacle < rTRObstacle && cObstacle < cTRObstacle) || rTRObstacle == -1))
            {
                rTRObstacle = rObstacle;
                cTRObstacle = cObstacle;
            }
                           
        }
        
        //Calculates the distance to the closest obstacle in each direction and adds it to reachableSquares
        //R B L T
        reachableSquares += (cRObstacle != -1) ? (cRObstacle - cQueen -1) : n - cQueen;     
        reachableSquares += (rBObstacle != -1) ? (rQueen - rBObstacle - 1) : rQueen - 1;   
        reachableSquares += (cLObstacle != -1) ? (cQueen - cLObstacle -1) : cQueen - 1;  
        reachableSquares += (rTObstacle != -1) ? (rTObstacle - rQueen - 1) : n - rQueen;

        //BR BL TL TR
        reachableSquares += (cBRObstacle != -1) ? (cBRObstacle - cQueen -1) : Math.min(n - cQueen, rQueen - 1); 
        reachableSquares += (rBLObstacle != -1) ? (cQueen - cBLObstacle - 1) : Math.min(cQueen - 1, rQueen - 1); 
        reachableSquares += (cTLObstacle != -1) ? (cQueen - cTLObstacle -1) : Math.min(cQueen - 1, n - rQueen);  
        reachableSquares += (rTRObstacle != -1) ? (cTRObstacle - cQueen - 1) : Math.min(n - cQueen, n - rQueen); 
        return reachableSquares;
    }

    console.log(queensAttackII(88587,9,20001, 20003, [[20001, 20002],
                                [20001, 20004],
                                [20000, 20003],
                                [20002, 20003],
                                [20000, 20004],
                                [20000, 20002],
                                [20002, 20004],
                                [20002, 20002],
                                [564, 323]]))

console.log(queensAttackII(5,3,4, 3, [[5, 5],
    [4, 2],
    [2, 3]])) //10

console.log(queensAttackII(4,0,4, 4)) //9

console.log(queensAttackII(100000,0,4187, 5068))
