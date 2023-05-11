class Monster {
    constructor(name, max_hp, attack, aggression) {
        this.name = name;//이름
        this.max_hp = max_hp;//최대체력
        this.attack = attack;//공격
        this.location = 0;//등장위치
        this.current_hp = max_hp;//현재체력
        this.exp = 100;//주는 경험치
        this.gold = 50;// 주는 골드
        this.aggression = aggression;
    }

    info() {
        let str = "";
        str = this.name + "(" + this.max_hp + "/" + this.current_hp + ")"
              + "\n공격력 : " + this.attack
              + "\n적대 : " + this.aggression;

        return str;
    }
}

const orc = new Monster('Orc', 100, 15, 'H');
const scarecrow1 = new Monster('허수아비1', 50, 4, 'F');
const scarecrow2 = new Monster('허수아비2', 50, 4, 'F');
const scarecrow3 = new Monster('허수아비3', 50, 4, 'H');
const scarecrow4 = new Monster('허수아비4', 50, 4, 'H');
const rat1 = new Monster('쥐1', 30, 5, 'H');
const rat2 = new Monster('쥐2', 30, 5, 'H');
const monsters = [orc, scarecrow1, scarecrow2, scarecrow3, scarecrow4, rat1, rat2];