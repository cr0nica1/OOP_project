public abstract class Items {
    private String name;
    private final String type;
    private int price;
    private String effect;
    private int attributePoints;
    private String rarity;

    public Items(String name, String type, int price, String effect, int attributePoints, String rarity) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.effect = effect;
        this.attributePoints = attributePoints;
        this.rarity = rarity;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getAttributePoints() {
        return attributePoints;
    }

    public void setAttributePoints(int attributePoints) {
        this.attributePoints = attributePoints;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    // Abstract method to be implemented by subclasses
    public abstract String usingItems();

    @Override
    public String toString() {
        return String.format("Item{name='%s', type='%s', price=%d, effect='%s', attributePoints=%d, rarity='%s'}",
                name, type, price, effect, attributePoints, rarity);
    }
}
