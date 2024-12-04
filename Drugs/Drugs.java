import java.util.ArrayList;
import java.util.List;

public class Drugs {
    private List<Potion> potions;  // Danh sách thuốc

    // Constructor khởi tạo Drugs
    public Drugs() {
        potions = new ArrayList<>();
        addPotions();
    }

    // Thêm thuốc vào Drugs
    private void addPotions() {
        potions.add(new Potion("Health Potion", 50, "Restore 50 HP", 50));
        potions.add(new Potion("Mana Potion", 70, "Restore 30 MP", 30));
    }

    // Phương thức lấy tất cả các thuốc
    public List<Potion> getPotions() {
        return potions;
    }

    // Hiển thị tất cả các thuốc
    public void showPotions() {
        System.out.println("Potions:");
        for (Potion potion : potions) {
            System.out.println(potion);
        }
    }
}

