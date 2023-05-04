// 가위 = 1, 바위 = 2, 보 = 3


console.log(input);
var player = 0;

var com = Math.floor(Math.random()*3)+1;

while (true) {
    var input = prompt("가위 바위 보");

    if (input == "가위")
        {player = 1;break;}
    else if (input == "바위")
        {player = 2;break;}
    else if (input == "보")
        {player = 3;break;}
    else
        alert("다시하세요");
}

result = player - com;


if((result == -2)||(result == 1))
    alert("win!");
    else if(result == 0)
    alert("draw");
    else if((result == 2) || (result == -1)) 
    alert("lose");

