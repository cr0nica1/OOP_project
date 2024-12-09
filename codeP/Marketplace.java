import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    private final List<Weapon> weapons;
    private final List<Armor> armors;

    public Marketplace() {
        weapons = new ArrayList<>();
        armors = new ArrayList<>();
        addWeapons();
        addArmors();
    }

    private void addWeapons() {
        weapons.add(new Weapon("Axe of Power", 1200, "Hit", 70, "B+", 1.0, 2));
        weapons.add(new Weapon("Machine Gun", 2000, "Shoot", 120, "A", 7.6, 4));
    }

    private void addArmors() {
        armors.add(new Armor("Shield of Valor", 800, "Blocks attacks", 40, "A"));
        armors.add(new Armor("Helmet of Wisdom", 500, "Increases defense", 30, "B"));
    }

    public void showItems() {
        System.out.println("Available Weapons:");
        for (Weapon weapon : weapons) {
            System.out.println(weapon);
        }

        System.out.println("\nAvailable Armors:");
        for (Armor armor : armors) {
            System.out.println(armor);
        }
    }
}
