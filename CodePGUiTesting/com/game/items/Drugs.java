package com.game.items;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Drugs {
    private final List<Potion> potions;

    public Drugs() {
        potions = new ArrayList<>();
        addPotions();
    }

    private void addPotions() {
        potions.add(new Potion("Health Potion", 50, "Restore 50 HP", 50, "A"));
        potions.add(new Potion("Mana Potion", 70, "Restore 30 MP", 30, "B"));
        potions.add(new Potion("Elixir", 150, "Restore 100 HP and MP", 100, "S"));
    }

    public void showPotions() {
        StringBuilder potionList = new StringBuilder("Available Potions:\n");
        for (Potion potion : potions) {
            potionList.append(potion.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, potionList.toString());
    }

    public void usePotionFromList() {
        String[] potionNames = potions.stream().map(Potion::getName).toArray(String[]::new);

        String selectedPotion = (String) JOptionPane.showInputDialog(null, "Choose a potion to use:",
                "Use Potion", JOptionPane.QUESTION_MESSAGE, null, potionNames, potionNames[0]);

        if (selectedPotion != null) {
            for (Potion potion : potions) {
                if (potion.getName().equalsIgnoreCase(selectedPotion)) {
                    JOptionPane.showMessageDialog(null, potion.usingItems());
                    return;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No potion selected.");
        }
    }
}
