public abstract class Item {
    private String name;          // Name of the item
    private double value;         // Price or value of the item
    private int durability;       // Durability or other relevant attributes

    // Constructor
    public Item(String name, double value, int durability) {
        this.name = name;
        this.value = value;
        this.durability = durability;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public int getDurability() {
        return durability;
    }

}
