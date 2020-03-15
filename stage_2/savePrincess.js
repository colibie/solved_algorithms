function displayPathtoPrincess(dimension, grid)
{
    // Your Code here
    //get bot position
    var bot, princess, move = '';
    for(let r = 0; r < dimension; r++){
      for(let c = 0; c < dimension; c++){
        if (grid[r][c] === 'm') {
          bot = [r, c];
          if (princess) break;
        }
        //get princess position
        if (grid[r][c] === 'p') {
          princess = [r, c];
          if (bot) break;
        }
      }
    }
    function moveDown(){
      bot[0] += 1;
      move += 'DOWN \n';
    }
    function moveUp(){
      bot[0] -= 1;
      move += 'UP \n';
    }
    function moveRight(){
      bot[1] += 1;
      move += 'RIGHT \n';
    }
    function moveLeft(){
      bot[1] -=1;
      move += 'LEFT \n';
    }
    // move up, down, right  till bot position = princess
    while(bot[0] !== princess[0]|| bot[1] !== princess[1]){
      if (bot[0] > princess[0]) moveUp();
      else if (bot[0] < princess[0]) moveDown();
      if (bot[1] > princess[1]) moveLeft();
      else if (bot[1] < princess[1]) moveRight();
    }
    return move;
}

console.log(displayPathtoPrincess(3, [['-','-','-'], ['-','m','-'], ['p','-','-']]))