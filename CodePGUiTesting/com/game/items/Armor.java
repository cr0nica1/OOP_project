package com.game.items;
import javax.swing.*;

public class Armor extends Items {
    public Armor(String name, int price, String effect, int defensePower, String rarity) {
        super(name, "Armor", price, effect, defensePower, rarity);
    }

    @Override
    public String usingItems() {
        JOptionPane.showMessageDialog(null, String.format("You equipped %s. Effect: %s", getName(), getEffect()));
        return String.format("You equipped %s. Effect: %s", getName(), getEffect());
    }
}
