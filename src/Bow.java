public class Bow extends Weapon {
    public Bow(String name, double value, int durability, int damage) {
        super(name, value, durability, damage); // Correct parameters for the constructor
    }

    @Override
    public void equip() {
        System.out.println(getName() + " has been equipped.");
    }

    @Override
    public void attack() {
        System.out.println(getName() + " shoots an arrow dealing " + getDamage() + " damage!");
    }  
}
