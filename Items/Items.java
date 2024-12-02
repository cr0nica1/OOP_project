public class Items {
    private String name;         // Tên vật phẩm
    private String type;         // Loại vật phẩm (Weapon, Armor, Drug, etc.)
    private int price;           // Giá vật phẩm
    private String effect;       // Hiệu ứng đặc biệt
    private int attributePoints; // Điểm thuộc tính (tùy loại vật phẩm)

    // Constructor cho lớp cha
    public Items(String name, String type, int price, String effect, int attributePoints) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.effect = effect;
        this.attributePoints = attributePoints;
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

    // Phương thức được gọi khi sử dụng vật phẩm
    public int useItem() {
        System.out.println(name + " is used! Effect: " + effect);
        return attributePoints;
    }

    // Override toString
    @Override
    public String toString() {
        return "Item{name='" + name + "', type='" + type + "', price=" + price +
                ", effect='" + effect + "', attributePoints=" + attributePoints + "}";
    }
}

class Weapon extends Items {
    public Weapon(String name, int price, String effect, int attackPower) {
        super(name, "Weapon", price, effect, attackPower);
    }

    @Override
    public int useItem() {
        System.out.println("Equipping weapon: " + getName() + " with attack power: " + getAttributePoints());
        return getAttributePoints(); // Attack Power được cộng vào chỉ số Player
    }
}

class Armor extends Items {
    public Armor(String name, int price, String effect, int defensePower) {
        super(name, "Armor", price, effect, defensePower);
    }

    @Override
    public int useItem() {
        System.out.println("Equipping armor: " + getName() + " with defense power: " + getAttributePoints());
        return getAttributePoints(); // Defense Power được cộng vào chỉ số Player
    }
}

class Potion extends Items {
    public Potion(String name, int price, String effect, int healthRestore) {
        super(name, "Drug", price, effect, healthRestore);
    }

    @Override
    public int useItem() {
        System.out.println("Using potion: " + getName() + " to restore " + getAttributePoints() + " health.");
        return getAttributePoints(); // Health restore được cộng vào chỉ số máu của Player
    }
}