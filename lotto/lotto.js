//~2개 꽝 ; 3개 5등; 4개 4등 ; 5개 3등 ; 6개 1등 ; 5개 + 틀린번호가 보너스 번호면 2등;

var lotto = new Array();
var player_lotto = new Array();
// var forcont = 0;//반복횟수

function compare(a, b) {    //번호비교
    var cnt = 0; // 일치번호갯수
    for (i = 0; i < a.length; i++) {
        for (j = 0; j < b.length; j++) {
            if (a[i] == b[j])
                cnt++;
        }
    }
    return cnt;
}

for (i = 0; i < 6; i++) { ///로또 번호 생성
    var posnum = Math.floor(Math.random() * 45 + 1);
    var check = 0; //중복체크
    if (i == 0)
        lotto[i] = posnum;
    else
        for (j = 0; j < lotto.length; j++) {
            if (lotto[j] == posnum)
                check++;
        }
    if (check == 0)
        lotto[i] = posnum;
    else {
        i--; continue;
    }
}
console.log(lotto);

for (i = 0; i < 7; i++) { //사용자 번호 입력
    var temp;//입력 임시저장
    var check = 0;
    while (true) {
        temp = prompt(i + 1 + "번째 숫자 입력\r" + player_lotto);
        if (0 < Number(temp) && Number(temp) < 46 && Number.isInteger(Number(temp)))
            break;
        else
            alert("1~45사이의 정수 입력!");
    }
    if (i == 0)
        player_lotto[i] = temp;
    else {
        for (j = 0; j < player_lotto.length; j++) {
            if (player_lotto[j] == temp)
                check++;
        }
        if (check == 0)
            player_lotto[i] = temp;
        else {
            i--; continue;
        }
    }
}

var bonus = new Array();
bonus[0]= player_lotto.pop();

var result = compare(player_lotto, lotto);
var bonus_result = compare(bonus, lotto);

var place ="";

switch(result){
    case 6:
        place = "1등!";break;
    case 5:
        if(bonus_result == 1)
            {place = "2등!";break;}
        else
            {place = "3등!";break;}
    case 4:
        place = "4등!";break;
    case 3:
        place = "5등!";break;
    default :
        place = "꽝!";break;
}

alert(lotto + "\r" + player_lotto +" 보너스: "+ bonus + "\r" + place);


// console.log(lotto);
// console.log(forcont);
// console.log(player_lotto);
// console.log(cnt);