import java.util.List;

public class Enemy {
    private String name;
    private int health;
    private int gold;
    private List<Item> loot;

    public Enemy(String name, int health, int gold, List<Item> loot) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.loot = loot;
    }

    public String getName() {
        return name;
    }

    public int getGold() {
        return gold;
    }

    public List<Item> getLoot() {
        return loot;
    }

    public int getCurrentHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(name + " has been defeated!");
        }
    }

    public void defeat(Player player) {
        System.out.println("You have defeated " + name + "!");
        player.addGold(gold);
        System.out.println("You received " + gold + " gold!");

        for (Item item : loot) {
            if (Math.random() < 0.5) { // 50% chance to get the item caan be changed
                player.pickUpItem(item);
                System.out.println("You found a " + item.getName() + "!");
            }
        }
    }
}
