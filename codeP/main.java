public class Main {
    public static void main(String[] args) {
        // Initialize Marketplace and show items
        Marketplace marketplace = new Marketplace();
        marketplace.showItems();

        // Initialize Drugs and show potions
        Drugs drugs = new Drugs();
        drugs.showPotions();

        // Use potions
        System.out.println(drugs.usePotion("Health Potion"));
        System.out.println(drugs.usePotion("Mana Potion"));
    }
}
