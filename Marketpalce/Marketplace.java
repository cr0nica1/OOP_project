import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    private List<Weapon> weapons;  // Danh sách vũ khí
    private List<Armor> armors;    // Danh sách giáp

    // Constructor khởi tạo marketplace
    public Marketplace() {
        weapons = new ArrayList<>();
        armors = new ArrayList<>();

        // Thêm các vật phẩm vào marketplace
        addWeapons();
        addArmors();
    }

    // Thêm vũ khí vào marketplace
    private void addWeapons() {
        weapons.add(new Weapon("Sword of Fire", 1000, "Burns enemies", 50));
        weapons.add(new Weapon("Axe of Power", 1200, "Deals massive damage", 70));
    }

    // Thêm giáp vào marketplace
    private void addArmors() {
        armors.add(new Armor("Shield of Valor", 800, "Blocks attacks", 40));
        armors.add(new Armor("Helmet of Wisdom", 500, "Increases defense", 30));
    }

    // Phương thức lấy tất cả các vũ khí
    public List<Weapon> getWeapons() {
        return weapons;
    }

    // Phương thức lấy tất cả các giáp
    public List<Armor> getArmors() {
        return armors;
    }

    // Hiển thị tất cả các vật phẩm
    public void showItems() {
        System.out.println("Weapons:");
        for (Weapon weapon : weapons) {
            System.out.println(weapon);
        }

        System.out.println("\nArmors:");
        for (Armor armor : armors) {
            System.out.println(armor);
        }
    }
}
