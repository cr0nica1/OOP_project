package com.game.items;

public abstract class Items {
    private String name;
    private final String type;
    private int price;
    private String effect;
    private int attributePoints;
    private String rarity;

    public Items(String name, String type, int price, String effect, int attributePoints, String rarity) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.effect = effect;
        this.attributePoints = attributePoints;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getEffect() {
        return effect;
    }

    public int getAttributePoints() {
        return attributePoints;
    }

    public String getRarity() {
        return rarity;
    }

    public abstract String usingItems();

    @Override
    public String toString() {
        return String.format("Item{name='%s', type='%s', price=%d, effect='%s', attributePoints=%d, rarity='%s'}",
                name, type, price, effect, attributePoints, rarity);
    }
}
