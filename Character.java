public class Character {
    protected String name;
    protected int health;
    protected int def;
    
    public Character(String name, int health2, int def) {
        this.name = name;
        this.health = health2;
        this.def = def;
    }

    public Character(String string) {
    }

    public String getName() {
        return name;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getDefense() {
        return def;
    }

    public boolean isAlive() {
        return false;
    }
}