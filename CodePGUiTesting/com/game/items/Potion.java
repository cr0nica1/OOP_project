package com.game.items;
import javax.swing.*;

public class Potion extends Items {
    public Potion(String name, int price, String effect, int healthRestore, String rarity) {
        super(name, "Potion", price, effect, healthRestore, rarity);
    }

    @Override
    public String usingItems() {
        JOptionPane.showMessageDialog(null, String.format("You used %s. Effect: %s", getName(), getEffect()));
        return String.format("You used %s. Effect: %s", getName(), getEffect());
    }
}
