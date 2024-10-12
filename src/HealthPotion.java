public class HealthPotion extends Item implements Usable {
    private int healingAmount;
    private boolean isStackable;

    public HealthPotion(String name, double weight, int value, int healingAmount, boolean isStackable) {
        super(name, weight, value);
        this.healingAmount = healingAmount;
        this.isStackable = isStackable;
    }

    @Override
    public void use(Player player) {
        player.heal(healingAmount);
        if (isStackable) {
            System.out.println(player.getName() + " used a stackable " + getName() + " and healed " + healingAmount + " health.");
        } else {
            System.out.println(player.getName() + " used a non-stackable " + getName() + " and healed " + healingAmount + " health.");
        }
    }
}
