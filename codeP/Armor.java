public class Armor extends Items {
    public Armor(String name, int price, String effect, int defensePower, String rarity) {
        super(name, "Armor", price, effect, defensePower, rarity);
    }

    @Override
    public String usingItems() {
        return "You equipped " + getName() + ". Effect: " + getEffect();
    }
}
