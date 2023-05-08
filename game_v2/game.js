// 가위 = 1, 바위 = 2, 보 = 3


window.onload = function() {
    var player = 0;
    var com = 0; 
    var log = document.querySelector("#result");
    var form = document.querySelector("form");
    
    form.addEventListener("submit", function(event) {
        var data = new FormData(form);      
        
        for (const entry of data) {
          player = entry[1];
        };

        com = Math.floor(Math.random() * 3) + 1;
        result = player - com;

        var output = "플레이어 : " + rpcText(player) + " 컴퓨터 : " + rpcText(com);
        
        if (result == -2 || result == 1) {
            output = output + " 승!";          
        }
        else if (result == 0) {
            output = output + " 무!";          
        }
        else if (result == 2 || result == -1) {
            output = output + " 패!";          
        }
    
        log.innerText = log.innerText +"\r"+ output;
        event.preventDefault();

      }, false);
    
}

function rpcText(a) {
    if(a == 1)
        return "가위";
    else if (a == 2)
        return "바위";    
    else (a == 3)
        return "보";    
}










// while (true) {
//     var input = prompt("가위 바위 보");

//     if (input == "가위")
//         {player = 1;break;}
//     else if (input == "바위")
//         {player = 2;break;}
//     else if (input == "보")
//         {player = 3;break;}
//     else
//         alert("다시하세요");
// }

// result = player - com;




