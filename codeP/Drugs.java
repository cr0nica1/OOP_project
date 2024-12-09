import java.util.ArrayList;
import java.util.List;

public class Drugs {
    private final List<Potion> potions;  // Danh sách thuốc

    // Constructor khởi tạo Drugs
    public Drugs() {
        potions = new ArrayList<>();
        addPotions();
    }

    // Thêm thuốc vào Drugs
    private void addPotions() {
        // Thêm thuốc hồi máu
        potions.add(new Potion("Health Potion", 50, "Restore 50 HP", 50, 5,"A"));
        // Thêm thuốc hồi mana
        potions.add(new Potion("Mana Potion", 70, "Restore 30 MP", 30, 3,"A"));
    }

    // Phương thức lấy tất cả các thuốc
    public List<Potion> getPotions() {
        return potions;
    }

    // Hiển thị tất cả các thuốc
    public void showPotions() {
        System.out.println("Available Potions:");
        for (Potion potion : potions) {
            System.out.println(potion);
        }
    }

    // Sử dụng thuốc
    public String usePotion(String potionName) {
        for (Potion potion : potions) {
            if (potion.getName().equalsIgnoreCase(potionName)) {
                return potion.usingItems();
            }
        }
        return "Potion not found.";
    }

    // Lớp con đại diện cho Potion
    public static class Potion extends Items {
        private int duration; // Thời gian tác dụng (giây)

        public Potion(String name, int price, String effect, int healthRestore, int duration,String rarity) {
            super(name, "Drug", price, effect, healthRestore,rarity);
            this.duration = duration;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        @Override
        public String usingItems() {
            return "You used " + getName() + ". Effect: " + getEffect() + " for " + duration + " seconds.";
        }
    }
}
