public class Armor extends Items {
    private int defensePower;
    public Armor(String name, int price, String effect, int defensePower, String rarity) {
        super(name, "Armor", price, effect, defensePower, rarity);
    }
    public int getDefensePower(){
        return defensePower;
    }
    public void setDefensePower(int defensePower){
        this.defensePower=defensePower;
    }

    @Override
    public String usingItems() {
        return "You equipped " + getName() + ". Effect: " + getEffect();
    }
}
