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
