public abstract class Items {
    private String name;
    private final String type;
    private int price;
    private String effect;
    private int attributePoints;
    public String rarity;

    public Items(String name, String type, int price, String effect, int attributePoints, String rarity) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.effect = effect;
        this.attributePoints = attributePoints;
        this.rarity = rarity;
    }

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

    public int usingItems(String message) {
        if (message.equalsIgnoreCase("use " + name)) {
            System.out.println("Using item: " + name + ". Effect: " + effect);
            return attributePoints;
        } else {
            System.out.println("Message not recognized for item: " + name);
            return 0;
        }
    }

    public abstract String usingItems(); // Phương thức abstract cần được override trong lớp con

    @Override
    public String toString() {
        return "Item{name='" + name + "', type='" + type + "', price=" + price +
                ", effect='" + effect + "', attributePoints=" + attributePoints +
                ", rarity='" + rarity + "'}";
    }
}
