public class App {
    public static void main(String[] args) {
        // Static polymorphism on Hero and Enemy classes
        Hero hero = new Hero("Superman");
        hero.attack("Laser vision");

        Enemy enemy = new Enemy("Joker");
        enemy.attack("Acid flower");

        // Dynamic polymorphism using Character superclass
        Character[] characters = {
            new Hero("Batman"), new Enemy("Bane"), new Witch("Hermione"), new Fighter("Rocky");
        }

        for (Character character : characters) {
            character.sayHello();
            character.attack("Punch");
            System.out.println("");
        }

        // Dynamic polymorphism by casting a Witch object to a Fighter object
        Witch witch = new Witch("Gandalf");
        Character character = (Character) witch;
        Fighter fighter = (Fighter) character;
        fighter.useWeapon("Staff");
    }
}