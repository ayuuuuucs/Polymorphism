class Hero extends Character {

    private static int baseAtk = 58;
    private Weapon weapon;
    private int level = 1;
    private int attackPower;

    public Hero(String name) {
    super(name, health, def);
    this.health = health;
    this.weapon =weapon;
    this.def = def;
    }

    public String getName(){
        return name;
    }

    public int getDef() {
        return def;
    }

    public static int getBaseAtk() {
        return baseAtk;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getLevel() {
        return level;
    }
    
    public int getAttackPower() {
        return attackPower;
    }

    public int attack(Enemy en) {
        int damage = level * baseAtk + weapon.use() + attackPower - en.getDef() + Weapon.randomAtk(weapon);
        en.takeDamage(damage);
        en.def = 0;
        return damage;
    }

    public void doubleAtk(Enemy en){
        attack(en);
        attack(en);
    }

    public void ultimate(Enemy en){
        if (health <= health * 0.20) {
            doubleAtk(en);
        }
        else{
            attack(en);
            attack(en);
            attack(en);
        }
        heal();
    }
    
    public void defense() {
        def += baseAtk * level / 2;
    }

    public void heal() {
        health += 100;
    }

    public void setHehealth(int hp) {
        this.health = hp;
    }
    
    public void printStatus() {
        System.out.println("Hero Status:");
        System.out.println("HP: " + health);
        System.out.println("DEF: " + def);
        System.out.println("Level: " + level);
        System.out.println("Weapon: " + weapon.getName());
        System.out.println("Weapon ATK: " + weapon.getAtk());
        System.out.println("Weapon Condition: " + weapon.getCondition());
        System.out.println("---------------------");
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public void attack(String string) {
    }
}
