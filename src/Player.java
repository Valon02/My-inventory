public class Player {
    private String name;
    private int gold;
    private int maxHealth;
    private int currentHealth;
    private Inventory inventory; 

    // Constructor
    public Player(String name, int gold, int maxHealth) {
        this.name = name;
        this.gold = gold;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth; // Start with full health
        this.inventory = new Inventory(); // Initialize inventory
    }

    public void showInventory() {
        System.out.println("Inventory:");
        inventory.showItems(); 
    }

    public void addGold(int amount) {
        gold += amount;
        System.out.println(name + " received " + amount + " gold. Total gold: " + gold);
    }

    public void pickUpItem(Item item) {
        inventory.addItem(item);
        System.out.println(name + " picked up " + item.getName());
    }

    public void buyItem(Item item, Shop shop) {
        if (gold >= item.getValue()) {
            gold -= item.getValue();
            shop.removeItemFromShop(item);
            pickUpItem(item);
            System.out.println(name + " bought " + item.getName());
        } else {
            System.out.println(name + " doesn't have enough gold to buy " + item.getName());
        }
    }

    public void equipItem(Item item) {
        if (item instanceof Equippable) {
            ((Equippable) item).equip();
            System.out.println(item.getName() + " equipped.");
        } else {
            System.out.println(item.getName() + " cannot be equipped.");
        }
    }

    public void sellItem(Item item, Shop shop) {
        if (inventory.containsItem(item)) {
            // Get the value of the item and add it to the player's gold
            int itemValue = (int) item.getValue(); // Cast to int if you want gold to be whole numbers
            inventory.removeItem(item); 
            gold += itemValue; 
            shop.addItemToShop(item); 
            System.out.println(name + " sold " + item.getName() + " for " + itemValue + " gold. Total gold: " + gold);
        } else {
            System.out.println(name + " doesn't have " + item.getName() + " to sell.");
        }
    }

    public void heal(int amount) {
        currentHealth += amount;
        if (currentHealth > maxHealth) {
            currentHealth = maxHealth; // Ensure we don't exceed max health
        }
        System.out.println(name + " healed for " + amount + " health.");
    }

    // Getters for player attributes
    public String getName() {
        return name;
    }

    public int getGold() {
        return gold;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
