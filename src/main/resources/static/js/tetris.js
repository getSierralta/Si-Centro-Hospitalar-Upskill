let tetris = true;

const startTetris = function(){
    const getEcraTitle = document.querySelector("#ecratitle");
    const getEcraNumbers = document.querySelector(".tracknumberutente__ecra");
    const getTetrisButton = document.querySelector(".tracknumberutente__tetris");
    const getTetris = document.querySelector(".tetris");

    if(tetris === false){
        getTetris.style.display = "none";
        getEcraTitle.style.display = "initial";
        getEcraNumbers.style.display = "flex";
        getTetrisButton.style.marginTop = "2.5rem";
        tetris = true;

    }else if(tetris === true){

        getTetris.style.display = "inherit";
        getEcraTitle.style.display = "none";
        getEcraNumbers.style.display = "none";
        getTetrisButton.style.marginTop = "1px";
        playTetris();
        tetris = false;
    }
}

function clearCanvas(context, canvas) {
    context.clearRect(0, 0, canvas.width, canvas.height);
    var w = canvas.width;
    canvas.width = 1;
    canvas.width = w;
  }
function playTetris(){

    const canvas = document.getElementById('tetris');
    const context = canvas.getContext('2d');

    clearCanvas(context, canvas);

    context.scale(20,20);

    function arenaSweep(){
        let rowCount = 1;
        outer: for(let y = arena.length - 1; y > 0; --y){
            for(let x = 0; x < arena[y].length; ++x){
                //if there's a 0 then the line is full
                if(arena[y][x] === 0){
                    continue outer;
                }
            }

            //We take the line from the arena, we fill it with 0
            const row = arena.splice(y, 1)[0].fill(0);
            //We put the row on top
            arena.unshift(row);
            ++y;

            player.score += rowCount * 10;
            rowCount *= 2;
        }
    }

    function collide(area, player){
        const [m, o] = [player.matrix, player.pos];
        for(let y = 0; y < m.length; ++y){
            for(let x = 0; x < m[y].length; ++x){
                //We check for a colision
                //if we colide with something with a 1 is a collision
                //if the arena ends its also a collision
                if(m[y][x] !== 0 &&
                    (arena[y + o.y] &&
                    arena[y + o.y][x + o.x]) !==0){
                        return true;
                    }
            }
        }
        return false;
    }

    function createMatrix(w,h){
        const matrix = [];
        while(h--){
            matrix.push(new Array(w).fill(0));
        }
        return matrix;
    }

    function createPiece(type){
        switch(type){
            case 'T':
                return [
                    [0,0,0],
                    [1,1,1],
                    [0,1,0],
                ];
            case 'O':
                return [
                    [2,2],
                    [2,2],
                ];
            case 'L':
                return [
                    [0,3,0],
                    [0,3,0],
                    [0,3,3],
                ];
            case 'J':
                return [
                    [0,4,0],
                    [0,4,0],
                    [4,4,0],
                ];
            case 'I':
                return [
                    [0,5,0, 0],
                    [0,5,0, 0],
                    [0,5,0, 0],
                    [0,5,0, 0],
                ];
            case 'S':
                return [
                    [0,6,6],
                    [6,6,0],
                    [0,0,0],
                ];
            case 'Z':
                return [
                    [7,7,0],
                    [0,7,7],
                    [0,0,0],
                ];
            default:
                console.log("Error reseting the player");
                return;
        }
    }

    function draw(){
        context.fillStyle = '#000';
        context.fillRect(0, 0, canvas.width, canvas.height);

        drawMatrix(arena, {x:0, y:0});
        drawMatrix(player.matrix, player.pos);
    }

    function drawMatrix(matrix, offset){
        matrix.forEach((row, y) =>{
            row.forEach((value, x) =>{
                if(value !== 0){
                context.fillStyle = colors[value];
                context.fillRect(x + offset.x,
                    y + offset.y, 1, 1);
                }
            });
        });
    }

    function merge(arena, player){
        player.matrix.forEach((row, y) => {
            row.forEach((value, x) => {
                if (value !== 0) {
                    arena[y + player.pos.y][x + player.pos.x] = value;
                }
            });
        });
    }

    function playerDrop(){
        player.pos.y++;
        if(collide(arena, player)){
            player.pos.y--;
            merge(arena, player);
            playerReset();
            arenaSweep();
            updateScore();
        }
        dropCounter = 0;
    }

    function playerMove(dir){
        player.pos.x += dir;
        if(collide(arena, player)){
            player.pos.x -= dir;
        }
    }

    function playerReset(){
        const pieces = 'ILJOTSZ';
        player.matrix = createPiece(pieces[pieces.length * Math.random() | 0]);
        player.pos.y = 0;
        player.pos.x = (arena[0].length / 2 | 0) -
                        (player.matrix[0].length / 2 | 0);

        //If we reset the player an it collides inmmidiatetly it means the game is over
        if(collide(arena, player)){
            arena.forEach(row => row.fill(0));
            player.score = 0;
            updateScore();
        }
    }

    function playerRotate(dir){
        const pos = player.pos.x;
        let offset = 1;
        rotate(player.matrix, dir);
        //So we dont rotate in the wall
        while(collide(arena, player)){
            player.pos.x += offset;
            offset = -(offset + (offset > 0 ? 1 : -1));
            //Trigger so we dont loop forever
            if(offset > player.matrix[0].length){
                rotate(player.matrix, -dir);
                //reset the offset
                player.pos.x = pos;
                return;
            }
        }
    }

    //Transpose + Reverse = Rotate
    // Transpose = convert all row into columns
    // then we reverse each collumn
    function rotate(matrix, dir){
        for(let y = 0; y < matrix.length; ++y){
            for(let x = 0; x < y; ++x){
                [
                    matrix[x][y],
                    matrix[y][x],
                ] = [
                    matrix[y][x],
                    matrix[x][y]
                ];
            }
        }

        if (dir > 0){
            matrix.forEach(row => row.reverse());
        }else{
            matrix.reverse();
        }
    }

    let dropCounter = 0;
    let dropInterval = 1000;

    let lastTime = 0;

    function update(time = 0){
        const deltaTime = time - lastTime;
        lastTime = time;

        dropCounter += deltaTime;
        if(dropCounter > dropInterval){
            playerDrop();
        }
        draw();
        requestAnimationFrame(update);
    }

    function updateScore(){
        document.getElementById('score').innerText = player.score;
    }

    const colors = [
        null,
        '#FF0D72',
        '#0DC2FF',
        '#0DFF72',
        '#F538FF',
        '#FF8E0D',
        '#FFE138',
        '#3877FF',
    ]

    const arena = createMatrix(12,20);

    const player = {
        pos:{x:0, y:0},
        matrix: null,
        score: 0,
    }

    document.addEventListener('keydown', event =>{
        if(event.keyCode === 37){
            playerMove(-1);
        }else if(event.keyCode === 39){
            playerMove(1);
        }else if(event.keyCode === 40){
            playerDrop();
        }else if(event.keyCode === 81){
            playerRotate(-1);
        }else if(event.keyCode === 87){
            playerRotate(1);
        }
    });

    playerReset();
    updateScore();
    update();

}

