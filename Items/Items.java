public abstract class Items {
    private String name;         // Tên vật phẩm
    private final String type;         // Loại vật phẩm (Weapon, Armor, Drug, etc.)
    private int price;           // Giá vật phẩm
    private String effect;       // Hiệu ứng đặc biệt
    private int attributePoints; // Điểm thuộc tính (tùy loại vật phẩm)
    public String rarity;       // Độ hiếm của vật phẩm (Common, Rare, Epic, Legendary)
    // Constructor cho lớp cha
    public Items(String name, String type, int price, String effect, int attributePoints, String rarity) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.effect = effect;
        this.attributePoints = attributePoints;
        this.rarity = rarity;
    }

    // Getters và Setters
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


    // Phương thức xử lý việc sử dụng vật phẩm
    public int usingItems(String message) {
        if (message.equalsIgnoreCase("use " + name)) {
            System.out.println("Using item: " + name + ". Effect: " + effect);
            return attributePoints; // Trả về giá trị thuộc tính của vật phẩm
        } else {
            System.out.println("Message not recognized for item: " + name);
            return 0; // Không làm gì nếu message không hợp lệ
        }
    }

    public abstract String usingItems();

    // Override toString
    @Override
    public String toString() {
        return "Item{name='" + name + "', type='" + type + "', price=" + price +
                ", effect='" + effect + "', attributePoints=" + attributePoints +
                ", rarity='" + rarity + "'}";
    }
}




