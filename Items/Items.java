public class Items {
    private String name;       // Tên vật phẩm
    private String type;       // Loại vật phẩm (Weapon, Armor, Drug, etc.)
    private int price;         // Giá vật phẩm
    private String effect;     // Hiệu ứng đặc biệt (ví dụ: hồi máu, tăng sức mạnh)

    // Các chỉ số cho các vật phẩm
    private int attackPower;   // Sát thương (dành cho vũ khí)
    private int defensePower;  // Phòng thủ (dành cho giáp)
    private int healthRestore; // Lượng máu phục hồi (dành cho thuốc)
    private int shieldPower;   // Lượng khiên (dành cho vật phẩm phòng thủ)

    // Constructor khởi tạo cho tất cả các thuộc tính
    public Items(String name, String type, int price, String effect, int attackPower, int defensePower, int healthRestore, int shieldPower) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.effect = effect;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.healthRestore = healthRestore;
        this.shieldPower = shieldPower;
    }

    // Getters và Setters cho các thuộc tính
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    public int getHealthRestore() {
        return healthRestore;
    }

    public void setHealthRestore(int healthRestore) {
        this.healthRestore = healthRestore;
    }

    public int getShieldPower() {
        return shieldPower;
    }

    public void setShieldPower(int shieldPower) {
        this.shieldPower = shieldPower;
    }

    // Override toString để in thông tin đầy đủ của vật phẩm
    @Override
    public String toString() {
        String info = "Item{name='" + name + "', type='" + type + "', price=" + price + ", effect='" + effect + "'";

        if (type.equals("Weapon")) {
            info += ", attackPower=" + attackPower;
        }
        if (type.equals("Armor")) {
            info += ", defensePower=" + defensePower + ", shieldPower=" + shieldPower;
        }
        if (type.equals("Drug")) {
            info += ", healthRestore=" + healthRestore;
        }
        info += "}";
        return info;
    }
}
