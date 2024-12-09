public class Potion extends Items {
    public Potion(String name, int price, String effect, int healthRestore, String rarity) {
        super(name, "Drug", price, effect, healthRestore, rarity);
    }

    @Override
    public String usingItems() {
        return "You used " + getName() + ". Effect: " + getEffect();
    }
}
