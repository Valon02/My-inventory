public class Boots extends Item implements Equippable {
    public Boots(String name, double value, int durability) {
        super(name, value, durability);
    }

    @Override
    public void equip() {
        System.out.println(getName() + " has been equipped.");
    }
}
