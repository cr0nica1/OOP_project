package com.game.items;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    private final List<Weapon> weapons;
    private final List<Armor> armors;
    private final List<SpecialWeapon> specialWeapons;

    public Marketplace() {
        weapons = new ArrayList<>();
        armors = new ArrayList<>();
        specialWeapons = new ArrayList<>();
        addWeapons();
        addArmors();
        addSpecialWeapons();
    }

    private void addWeapons() {
        weapons.add(new Weapon("Axe of Power", 1200, "Hit", 70, "B+", 1.0, 2));
        weapons.add(new Weapon("Machine Gun", 2000, "Shoot", 120, "A", 7.6, 4));
    }

    private void addArmors() {
        armors.add(new Armor("Shield of Valor", 800, "Blocks attacks", 40, "A"));
        armors.add(new Armor("Helmet of Wisdom", 500, "Increases defense", 30, "B"));
    }

    private void addSpecialWeapons() {
        specialWeapons.add(new SpecialWeapon("Flaming Sword", 3000, "Burns enemies", 150, "S", 1.5, 3.0f, 50, 5.0));
        specialWeapons.add(new SpecialWeapon("Ice Lance", 2500, "Freezes enemies", 120, "A", 1.2, 4.5f, 30, 6.0));
    }

    public void showItems() {
        StringBuilder itemList = new StringBuilder("Items in Marketplace:\n");
        for (Weapon weapon : weapons) {
            itemList.append(weapon.toString()).append("\n");
        }
        for (Armor armor : armors) {
            itemList.append(armor.toString()).append("\n");
        }
        for (SpecialWeapon specialWeapon : specialWeapons) {
            itemList.append(specialWeapon.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, itemList.toString());
    }

    public void useItemFromList() {
        List<Items> allItems = new ArrayList<>();
        allItems.addAll(weapons);
        allItems.addAll(armors);
        allItems.addAll(specialWeapons);

        String[] itemNames = allItems.stream().map(Items::getName).toArray(String[]::new);

        String selectedItem = (String) JOptionPane.showInputDialog(null, "Choose an item to use:",
                "Use Item", JOptionPane.QUESTION_MESSAGE, null, itemNames, itemNames[0]);

        if (selectedItem != null) {
            for (Items item : allItems) {
                if (item.getName().equalsIgnoreCase(selectedItem)) {
                    JOptionPane.showMessageDialog(null, item.usingItems());
                    return;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No item selected.");
        }
    }
}
