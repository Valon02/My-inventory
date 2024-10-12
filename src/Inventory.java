import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Item, Integer> items; // A map to hold items and their quantities

    // Constructor
    public Inventory() {
        this.items = new HashMap<>();
    }

    // Method to add an item to the inventory
    public void addItem(Item item) {
        items.put(item, items.getOrDefault(item, 0) + 1);
        System.out.println(item.getName() + " added to inventory. Total quantity: " + items.get(item));
    }

    // Method to remove an item from the inventory
    public void removeItem(Item item) {
        if (items.containsKey(item)) {
            int quantity = items.get(item);
            if (quantity > 1) {
                items.put(item, quantity - 1);
                System.out.println(item.getName() + " removed from inventory. Remaining quantity: " + (quantity - 1));
            } else {
                items.remove(item);
                System.out.println(item.getName() + " removed from inventory. No more left.");
            }
        } else {
            System.out.println(item.getName() + " not found in inventory.");
        }
    }

    // Method to check if an item is in the inventory
    public boolean containsItem(Item item) {
        return items.containsKey(item) && items.get(item) > 0;
    }

    // Method to check the quantity of a specific item
    public int getItemQuantity(Item item) {
        return items.getOrDefault(item, 0);
    }

    // Method to display items in the inventory
    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("No items in inventory.");
            return;
        }
        System.out.println("Items in Inventory:");
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            // Display equipable items without quantity
            if (item instanceof Equippable) {
                System.out.println("- " + item.getName()); // Only show the name for equipable items
            } else {
                System.out.println("- " + item.getName() + " (x" + quantity + ")"); // Show quantity for others
            }
        }
    }

    // Method to get all items in the inventory (for external access)
    public Map<Item, Integer> getItems() {
        return items;
    }
}
