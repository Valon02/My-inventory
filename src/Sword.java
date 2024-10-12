public class Sword extends Weapon {
    public Sword(String name, double value, int durability, int damage) {
        super(name, value, durability, damage); // Update this line to match the constructor
    }

    @Override
    public void equip() {
        System.out.println(getName() + " has been equipped.");
    }

    @Override
    public void attack() {
        System.out.println(getName() + " slashes with " + getDamage() + " damage!");
    }
}
