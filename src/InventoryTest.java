import java.util.InputMismatchException;
import java.util.Scanner;

public class InventoryTest {
    public static void main(String[] args) {
        // Create a new inventory
        Inventory inventory = new Inventory();
        Player player = new Player("Hero", 100, 100); 

        // Create items
        Sword sword = new Sword("Sword", 10.0, 15, 25); // name, weight, value, damage
        Bow bow = new Bow("Longbow", 10.0, 20, 15); 
        MagicOgreArmor armor = new MagicOgreArmor("Magic Ogre Armor", 15.0, 30, 25); 
        Boots boots = new Boots("Boots", 5.0, 10); 
        HealthPotion potion = new HealthPotion("Health Potion", 5.0, 10, 20, true); 
        Apple apple = new Apple("Apple", 1.0, 5, true);
        Shield shield = new Shield("Knight's Shield", 15.0, 50, 20);

        // Add items to the inventory
        inventory.addItem(sword);
        inventory.addItem(bow);
        inventory.addItem(armor);
        inventory.addItem(boots);
        inventory.addItem(potion);
        inventory.addItem(apple);
        inventory.addItem(shield); 

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nInventory Menu:");
            System.out.println("1. Show Items");
            System.out.println("2. Remove an Item");
            System.out.println("3. Use an Item");
            System.out.println("4. Equip an Item");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): "); // Updated to 5

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Show all items in the inventory
                        inventory.showItems();
                        break;

                    case 2:
                        // Remove an item from the inventory
                        System.out.print("Enter the name of the item to remove: ");
                        String itemNameToRemove = scanner.next();
                        Item itemToRemove = findItemByName(inventory, itemNameToRemove);
                        if (itemToRemove != null) {
                            inventory.removeItem(itemToRemove);
                            System.out.println("Removed: " + itemToRemove.getName());
                        } else {
                            System.out.println("Item not found.");
                        }
                        break;

                    case 3:
                        // Use an item from the inventory
                        System.out.print("Enter the name of the item to use: ");
                        String itemNameToUse = scanner.next();
                        Item itemToUse = findItemByName(inventory, itemNameToUse);
                        if (itemToUse != null && itemToUse instanceof Usable) {
                            ((Usable) itemToUse).use(player); // Pass the player to use method
                        } else {
                            System.out.println("Item not found or not usable.");
                        }
                        break;

                    case 4: // New case for equipping an item
                        System.out.print("Enter the name of the item to equip: ");
                        String itemNameToEquip = scanner.next();
                        Item itemToEquip = findItemByName(inventory, itemNameToEquip);
                        if (itemToEquip != null && itemToEquip instanceof Equippable) {
                            player.equipItem(itemToEquip); // Equip the item
                        } else {
                            System.out.println("Item not found or not equippable.");
                        }
                        break;

                    case 5:
                        running = false; // Exit the loop
                        break;

                    default:
                        System.out.println("Invalid option, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next(); // Clear the invalid input
            }
        }
        scanner.close();
        System.out.println("Exiting Inventory Test.");
    }

    // Helper method to find an item by name in the inventory
    private static Item findItemByName(Inventory inventory, String itemName) {
        for (Item item : inventory.getItems().keySet()) { // Iterate over the keys (items)
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null; // Return null if item is not found
    }
}
