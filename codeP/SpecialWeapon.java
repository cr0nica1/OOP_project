public class SpecialWeapon extends Weapon {
    private final int specialEffectDamage;
    private final double effectDuration;

    public SpecialWeapon(String name, int price, String effect, int attackPower, String rarity, double attackSpeed, float range, 
                         int specialEffectDamage, double effectDuration) {
        super(name, price, effect, attackPower, rarity, attackSpeed, range);
        this.specialEffectDamage = specialEffectDamage;
        this.effectDuration = effectDuration;
    }

    public int getSpecialEffectDamage() {
        return specialEffectDamage;
    }

    public double getEffectDuration() {
        return effectDuration;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", specialEffectDamage=%d, effectDuration=%.2f", specialEffectDamage, effectDuration);
    }
}
