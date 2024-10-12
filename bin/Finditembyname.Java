// Helper method to find an item by name in the inventory
private static Item findItemByName(Inventory inventory, String itemName) {
    // Normalize input by trimming and converting to lower case
    itemName = itemName.trim().toLowerCase(); 
    
    // Iterate over the keys (items) in the inventory
    for (Item item : inventory.getItems().keySet()) { 
        // Check if the item's name matches the input name (also normalized)
        if (item.getName().trim().toLowerCase().equals(itemName)) {
            return item; // Return the matching item
        }
    }
    return null; // Return null if item is not found
}
