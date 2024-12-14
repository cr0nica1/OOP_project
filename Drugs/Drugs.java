import java.util.ArrayList;
import java.util.List;

public class Drugs {
    private final List<Potion> potions;

    public Drugs() {
        potions = new ArrayList<>();
        addPotions();
    }

    private void addPotions() {
        potions.add(new Potion("Health Potion", 50, "Restore 50 HP", 50, 5, "A"));
        potions.add(new Potion("Mana Potion", 70, "Restore 30 MP", 30, 3, "A"));
        potions.add(new Potion("Health Potion", 50, "Restore 50 HP", 50, 5, "C"));
        potions.add(new Potion("Mana Potion", 70, "Restore 30 MP", 30, 3, "C"));
        potions.add(new Potion("Greater Health Potion", 150, "Restore 150 HP", 150, 7, "B"));
        potions.add(new Potion("Greater Mana Potion", 200, "Restore 100 MP", 100, 6, "B"));
        potions.add(new Potion("Elixir of Strength", 300, "Increase attack power by 20%", 0, 10, "A"));
        potions.add(new Potion("Elixir of Defense", 300, "Increase defense by 20%", 0, 10, "A"));
        potions.add(new Potion("Antidote", 100, "Cures poison", 0, 5, "C"));
        potions.add(new Potion("Stamina Potion", 120, "Restore 50 stamina", 50, 4, "B"));
        potions.add(new Potion("Invisibility Potion", 500, "Grants invisibility for 30 seconds", 0, 2, "S"));
        potions.add(new Potion("Phoenix Elixir", 1000, "Revives with full health", 0, 1, "S"));

    }

    public List<Potion> getPotions() {
        return potions;
    }

    public void showPotions() {
        System.out.println("Potions:");
        for (Potion potion : potions) {
            System.out.println(potion);
        }
    }

    public String usePotion(String potionName) {
        for (Potion potion : potions) {
            if (potion.getName().equalsIgnoreCase(potionName)) {
                return potion.usingItems();
            }
        }
        return "Potion not found.";
    }
}
