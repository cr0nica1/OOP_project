public class Weapon extends Items {

    public double attackSpeed;     //Toc do tan cong
    public float range;           //Pham vi tan cong

    public Weapon(String name, int price, String effect, int attackPower, String rarity, double attackSpeed, float range) {
        super(name, "Weapon", price, effect, attackPower, rarity);
        this.attackSpeed = attackSpeed;
        this.range = range;
    }

    //Getters Setters
    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    @Override
    public String usingItems() {
        return "";
    }
}
