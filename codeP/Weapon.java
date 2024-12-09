public class Weapon extends Items {
    private double attackSpeed;
    private float range;

    public Weapon(String name, int price, String effect, int attackPower, String rarity, double attackSpeed, float range) {
        super(name, "Weapon", price, effect, attackPower, rarity);
        this.attackSpeed = attackSpeed;
        this.range = range;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }

    @Override
    public String usingItems() {
        return String.format("You equipped %s. Effect: %s", getName(), getEffect());
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", attackSpeed=%.2f, range=%.2f", attackSpeed, range);
    }
}
