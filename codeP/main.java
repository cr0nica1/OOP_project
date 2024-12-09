public class Main {
    public static void main(String[] args) {
        // Khởi tạo Marketplace và hiển thị vật phẩm
        Marketplace marketplace = new Marketplace();
        marketplace.showItems(); // Hiển thị vũ khí và giáp

        // Khởi tạo Drugs và hiển thị potions
        Drugs drugs = new Drugs();
        drugs.showPotions(); // Hiển thị các potion

        // Sử dụng các potion
        System.out.println(drugs.usePotion("Health Potion"));
        System.out.println(drugs.usePotion("Mana Potion"));
    }
}
