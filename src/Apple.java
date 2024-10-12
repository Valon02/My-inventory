public class Apple extends Item implements Usable {
    private boolean isStackable;

    public Apple(String name, double weight, int value, boolean isStackable) {
        super(name, weight, value);
        this.isStackable = isStackable;
    }

    @Override
    public void use(Player player) {
        if (isStackable) {
            player.heal(5); // Example healing amount
            System.out.println(player.getName() + " ate a " + getName() + " and healed 5 health.");
        } else {
            // Handle non-stackable logic here
            player.heal(5); // Same healing amount
            System.out.println(player.getName() + " ate a" + getName() + " and healed 5 health.");
        }
    }
}
