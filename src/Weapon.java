public abstract class Weapon extends Item implements Equippable {
    private int damage;

    public Weapon(String name, double value, int durability, int damage) {
        super(name, value, durability);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void equip() {
        System.out.println(getName() + " has been equipped.");
    }

    // Declare an abstract method for attack
    public abstract void attack(); 
}
