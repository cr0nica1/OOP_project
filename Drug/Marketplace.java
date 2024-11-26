import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    private List<Items> items;  // Danh sách các vật phẩm trong marketplace

    // Constructor khởi tạo marketplace với các vật phẩm
    public Marketplace() {
        items = new ArrayList<>();
        // Thêm các vũ khí vào marketplace
        items.add(new Items("Sword of Fire", "Weapon", 1000, "Burns enemies", 50, 0, 0, 0));
        items.add(new Items("Axe of Power", "Weapon", 1200, "Deals massive damage", 70, 0, 0, 0));

        // Thêm các giáp vào marketplace
        items.add(new Items("Shield of Valor", "Armor", 800, "Blocks attacks", 0, 0, 0, 40));
        items.add(new Items("Helmet of Wisdom", "Armor", 500, "Increases defense", 0, 30, 0, 0));

        // Thêm các thuốc vào marketplace
        items.add(new Items("Health Potion", "Drug", 50, "Restore 50 HP", 0, 0, 50, 0));
        items.add(new Items("Mana Potion", "Drug", 70, "Restore 30 MP", 0, 0, 0, 0));
    }

    // Phương thức lấy tất cả các vũ khí
    public List<Items> getWeapons() {
        List<Items> weapons = new ArrayList<>();
        for (Items item : items) {
            if (item.getType().equals("Weapon")) {
                weapons.add(item);
            }
        }
        return weapons;
    }

    // Phương thức lấy tất cả các giáp
    public List<Items> getArmors() {
        List<Items> armors = new ArrayList<>();
        for (Items item : items) {
            if (item.getType().equals("Armor")) {
                armors.add(item);
            }
        }
        return armors;
    }

    // Phương thức lấy tất cả các thuốc
    public List<Items> getDrugs() {
        List<Items> drugs = new ArrayList<>();
        for (Items item : items) {
            if (item.getType().equals("Drug")) {
                drugs.add(item);
            }
        }
        return drugs;
    }

    // Hiển thị tất cả các vật phẩm trong marketplace
    public void showItems() {
        for (Items item : items) {
            System.out.println(item);
        }
    }
}
