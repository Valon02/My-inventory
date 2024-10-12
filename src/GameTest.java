import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class GameTest {
    public static void main(String[] args) {
        // Create a player and shop with initial gold
        Player player = new Player("Hero", 100, 100); // Example with initial gold and max health
        Shop shop = new Shop(500);
        Scanner scanner = new Scanner(System.in);

        // Add items to the shop
        Bow bow = new Bow("Longbow", 10.0, 20, 15); // name, weight, value, damage
        MagicOgreArmor armor = new MagicOgreArmor("Magic Ogre Armor", 15.0, 30, 25); // name, weight, value, defense
        HealthPotion potion = new HealthPotion("Health Potion", 5.0, 10, 20, true); // Add isStackable
        Apple apple = new Apple("Apple", 1.0, 5, true); // name, weight, value, stackable
        Shield shield = new Shield("Knight's Shield", 15.0, 50, 20); // Create a new Shield

        shop.addItemToShop(bow);
        shop.addItemToShop(armor);
        shop.addItemToShop(potion);
        shop.addItemToShop(apple);
        shop.addItemToShop(shield); // Add the shield to the shop

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Fight an enemy");
            System.out.println("2. Enter the shop");
            System.out.println("3. View inventory");
            System.out.println("4. Exit game");
            System.out.print("Your choice: ");
            
            int choice = safeNextInt(scanner);
            switch (choice) {
                case 1:
                    // Create an enemy with loot
                    List<Item> enemyLoot = new ArrayList<>();
                    enemyLoot.add(new HealthPotion("Health Potion", 5.0, 10, 20, true)); // Example loot
                    Enemy enemy = new Enemy("Goblin", 100, 20, enemyLoot); // Example enemy with 100 HP

                    System.out.println("You encounter a " + enemy.getName() + " with " + enemy.getCurrentHealth() + " HP.");
                    // Simulate fighting the enemy until defeated
                    while (enemy.getCurrentHealth() > 0) {
                        System.out.println("Choose your attack:");
                        System.out.println("1. Use sword (melee attack)");
                        System.out.println("2. Use bow (ranged attack)");
                        System.out.print("Your choice: ");
                        
                        int attackChoice = safeNextInt(scanner);
                        switch (attackChoice) {
                            case 1:
                                Sword sword = new Sword("Sword", 10.0, 15, 25); // name, weight, value, damage
                                sword.attack(); // Display sword attack
                                enemy.takeDamage(sword.getDamage()); // Apply damage to enemy
                                break;
                            case 2:
                                Bow bowAttack = new Bow("Longbow", 10.0, 20, 15); // name, weight, value, damage
                                bowAttack.attack(); // Display bow attack
                                enemy.takeDamage(bowAttack.getDamage()); // Apply damage to enemy
                                break;
                            default:
                                System.out.println("Invalid attack choice.");
                                continue; // Skip to the next iteration
                        }
                        System.out.println("Enemy now has " + enemy.getCurrentHealth() + " HP.");
                    }
                    
                    // If enemy is defeated, drop loot
                    System.out.println("You have defeated the " + enemy.getName() + "!");
                    for (Item lootItem : enemy.getLoot()) {
                        player.pickUpItem(lootItem); // Player picks up loot
                        System.out.println("You found: " + lootItem.getName());
                    }
                    break;

                case 2:
                    // Enter the shop
                    boolean shopping = true;
                    while (shopping) {
                        shop.displayShopItems();
                        System.out.println("1. Buy an item");
                        System.out.println("2. Sell an item");
                        System.out.println("3. Exit shop");
                        System.out.print("Your choice: ");
                        
                        int shopChoice = safeNextInt(scanner);
                        switch (shopChoice) {
                            case 1:
                                System.out.print("Enter the name of the item you want to buy: ");
                                String itemNameToBuy = scanner.next();
                                Item itemToBuy = findItemByName(shop.getInventory(), itemNameToBuy);
                                if (itemToBuy != null) {
                                    shop.purchaseItem(itemToBuy, player);
                                } else {
                                    System.out.println("Item not found in shop.");
                                }
                                break;

                            case 2:
                                // Show inventory before selling an item
                                player.showInventory(); // Show player's inventory
                                System.out.print("Enter the name of the item you want to sell: ");
                                scanner.nextLine(); // Consume the leftover newline
                                String itemNameToSell = scanner.nextLine(); // Read the full line for item name
                                Item itemToSell = findItemByName(player.getInventory(), itemNameToSell);
                                if (itemToSell != null) {
                                    player.sellItem(itemToSell, shop); // Call sellItem method
                                } else {
                                    System.out.println("Item not found in inventory.");
                                }
                                break;

                            case 3:
                                shopping = false; // Exit shop
                                break;

                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                    break;

                case 3:
                    // Display inventory
                    player.showInventory();
                    break;

                case 4:
                    running = false; // Exit game
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
        System.out.println("Exiting game.");
    }

    // Helper method to find an item by name in a given inventory
    private static Item findItemByName(Inventory inventory, String itemName) {
        for (Item item : inventory.getItems().keySet()) { // Iterate through the keys of the map
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null; // Return null if item is not found
    }

    // Safe method to read an integer from the scanner
    private static int safeNextInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt(); // Try to read an integer
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }
    }
}
