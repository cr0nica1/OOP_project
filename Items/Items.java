public class Items {
    private String name;         // Tên vật phẩm
    private final String type;         // Loại vật phẩm (Weapon, Armor, Drug, etc.)
    private int price;           // Giá vật phẩm
    private String effect;       // Hiệu ứng đặc biệt
    private int attributePoints; // Điểm thuộc tính (tùy loại vật phẩm)
    private String rarity;       // Độ hiếm của vật phẩm (Common, Rare, Epic, Legendary)
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

    // Override toString
    @Override
    public String toString() {
        return "Item{name='" + name + "', type='" + type + "', price=" + price +
                ", effect='" + effect + "', attributePoints=" + attributePoints +
                ", rarity='" + rarity + "'}";
    }
}
class Weapon extends Items {

    public double attackSpeed;     //Toc do tan cong
    public float range;           //Pham vi tan cong

    public Weapon(String name, int price, String effect, int attackPower, String rarity, double attackSpeed, float range) {
        super(name, "Weapon", price, effect, attackPower, rarity);
        this.attackSpeed = attackSpeed;
        this.range = range;
    }

    //Getters Setters
    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
}
class Armor extends Items {
    public Armor(String name, int price, String effect, int defensePower, String rarity) {
        super(name, "Armor", price, effect, defensePower, rarity);
    }
}

class Potion extends Items {
    public Potion(String name, int price, String effect, int healthRestore, String rarity) {
        super(name, "Drug", price, effect, healthRestore, rarity);
    }
}
class SpecialWeapon extends Weapon {
    private final int specialEffectDamage;  // Damage từ hiệu ứng đặc biệt
    private final double effectDuration;       // Thời gian hiệu ứng đặc biệt kéo dài (giây)

    // Constructor cho SpecialWeapon
    public SpecialWeapon(String name, int price, String effect, int attackPower, String rarity,double attackSpeed,float range,int specialEffectDamage, double effectDuration ) {
        super(name, price, effect, attackPower, rarity, attackSpeed, range); // Gọi constructor từ Weapon
        this.specialEffectDamage = specialEffectDamage;
        this.effectDuration = effectDuration;
    }

    // Getters cho các thuộc tính mới
    public int getSpecialEffectDamage() {
        return specialEffectDamage;
    }
    public double getEffectDuration() {
        return effectDuration;
    }
    @Override
    public String toString() {
        return super.toString() +
                ", specialEffectDamage=" + specialEffectDamage +
                ", effectDuration=" + effectDuration;
    }
}




