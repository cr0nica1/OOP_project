package com.game.items;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Marketplace marketplace = new Marketplace();
        Drugs drugs = new Drugs();

        while (true) {
            String[] options = {"Show Items", "Use Item", "Show Potions", "Use Potion", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an action:", "Main Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                marketplace.showItems();
            } else if (choice == 1) {
                marketplace.useItemFromList();
            } else if (choice == 2) {
                drugs.showPotions();
            } else if (choice == 3) {
                drugs.usePotionFromList();
            } else if (choice == 4 || choice == JOptionPane.CLOSED_OPTION) {
                break;
            }
        }
    }
}


