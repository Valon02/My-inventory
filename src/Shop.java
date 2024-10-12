public class Shop {
    private Inventory inventory;
    private int gold;

    // Constructor to initialize the shop with an initial amount of gold
    public Shop(int initialGold) {
        this.inventory = new Inventory();
        this.gold = initialGold;
    }

    // Method to add items to the shop's inventory
    public void addItemToShop(Item item) {
        inventory.addItem(item);
        System.out.println(item.getName() + " added to shop.");
    }

    // Method to remove items from the shop's inventory
    public void removeItemFromShop(Item item) {
        inventory.removeItem(item);
        System.out.println(item.getName() + " removed from shop.");
    }

    // Method to display items available in the shop
    public void displayShopItems() {
        System.out.println("Items available in the shop:");
        inventory.showItems(); // Assuming Inventory has a showItems() method
    }

    // Method to purchase an item from the shop
    public void purchaseItem(Item item, Player player) {
        if (player.getGold() >= item.getValue()) {
            player.buyItem(item, this);
            gold += item.getValue(); // Increment shop's gold when a purchase is made
            System.out.println("Purchased " + item.getName() + " for " + item.getValue() + " gold.");
        } else {
            System.out.println("Not enough gold to purchase " + item.getName());
        }
    }

    // Method to sell an item to the shop
    public void sellItem(Item item, Player player) {
        // Ensure the player actually has the item to sell
        if (player.getInventory().containsItem(item)) {
            player.sellItem(item, this);
            gold += item.getValue(); // Increase shop's gold when an item is sold back
            System.out.println("Sold " + item.getName() + " for " + item.getValue() + " gold.");
        } else {
            System.out.println("Item not found in player's inventory.");
        }
    }

    // Method to allow the shop to buy an item
    public void buyItem(Item item) {
        inventory.addItem(item);
        System.out.println("Shop bought " + item.getName() + " for " + item.getValue() + " gold.");
    }

    // Getter for the shop's gold
    public int getGold() {
        return gold;
    }

    // Method to get the shop's inventory
    public Inventory getInventory() {
        return inventory;
    }
}
