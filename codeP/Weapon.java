public class Weapon extends Items {
    private double attackSpeed;
    private float range;
    public int attackPower;

    public Weapon(String name, int price, String effect, int attackPower, String rarity, double attackSpeed, float range) {
        super(name, "Weapon", price, effect, attackPower, rarity);
        this.attackSpeed = attackSpeed;
        this.attackPower=attackPower;
        this.range = range;
    }
    public int getattackPower(){
        return attackPower;

    }
    public void setAttackPower(int attackPower){
        this.attackPower=attackPower;
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
        return "You are using: " + getName() + ". Effect: " + getEffect() +".BaseDamage:"+getattackPower()+
               ", Attack Speed: " + attackSpeed + ", Range: " + range;
    }
}
