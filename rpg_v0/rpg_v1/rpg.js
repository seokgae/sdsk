class Monster {
    constructor(name ,hp, attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    info() {
        document.write("name: "+this.name);br();
        document.write("hp: "+this.hp);br();
        document.write("attack: "+this.attack);br();
    }
}

class Character {
    constructor(name ,hp, attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    info() {
        document.write("name: "+this.name);br();
        document.write("hp: "+this.hp);br();
        document.write("attack: "+this.attack);br();
    }
}

function Battle_turn(mon, cha) {
    mon.hp -= RandomizeAttack(cha.attack);
    cha.hp -= RandomizeAttack(mon.attack);
    mon.info(); br(); cha.info(); hr();
}

const orc = new Monster('Orc', 120, 20);
const elf = new Character('Elf', 100, 10);
orc.info(); br(); elf.info();

Battle_start();Battle_turn(orc, elf); Battle_turn(orc, elf);






