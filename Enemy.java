
public class Enemy extends Character {
    private static int baseAtk = 46;
    private Weapon weapon;
    private int level = 1;
    private int attackPower;

    
    public Enemy(String name, int health, Weapon weapon, int def) {
        super(name, health, def);
        this.health = health;
        this.weapon = weapon;
        this.def = def;
        }

    
    public Enemy(String string) {
    }


    public String getName(){
        return name;
    }
    
    public int getAp(){
        return attackPower;
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
    
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }

    public void doubleAtk(Hero hero){
        attack(hero);
        attack(hero);
    }

    public void ultimate(Hero hero){
        if (health <= health * 0.20) {
            doubleAtk(hero);
        }
        else{
            attack(hero);
            attack(hero);
            attack(hero);
        }
        remedy();
    }
    
    public int attack(Character target, Weapon weapon) {
        int damage = baseAtk - target.def;
        if (damage > 0) {
            target.setHealth(target.getHealth() - damage);
            System.out.println(this.name + " attacks " + target.getName() + " for " + damage + " damage.");
        } else {
            System.out.println(this.name + " attacks " + target.getName() + " but it has no effect.");
        }
        return damage;
    }

    public int attack(Hero hero) {
        int damage = level * baseAtk + weapon.use() - hero.getDef() + weapon.randomAtk();
        hero.takeDamage(damage);
        hero.def = 0;
        return damage;
    }
    
    public void defense() {
        def += baseAtk * level / 2;
    }
    
    public void remedy() {
        health += 100;
        if (health > 1000) {
            health = 1000;
        }
    }
    
    public boolean isDefeated() {
        return health <= 0;
    }
    
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }
    
    public void printStatus() {
        System.out.println("Enemy Status:");
        System.out.println("HP: " + health);
        System.out.println("DEF: " + def);
        System.out.println("Level: " + level);
        System.out.println("Weapon: " + weapon.getName());
        System.out.println("Weapon ATK: " + weapon.getAtk());
        System.out.println("Weapon Condition: " + weapon.getCondition());
        System.out.println("---------------------");
    }


    public void attack(String string) {
    }

}
