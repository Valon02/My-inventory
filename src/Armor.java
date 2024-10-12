public abstract class Armor extends Item implements Equippable {
    private int defense;  // Defense value for the armor

    public Armor(String name, double value, int durability, int defense) {
        super(name, value, durability);  // Call to the superclass constructor
        this.defense = defense;           // Set the defense value
    }

    public int getDefense() {
        return defense;  // Getter for defense
    }

    @Override
    public void equip() {
        System.out.println(getName() + " has been equipped.");
    }
}
