public class SpecialWeapon extends Weapon {
    private final int specialEffectDamage;  // Damage từ hiệu ứng đặc biệt
    private final double effectDuration;       // Thời gian hiệu ứng đặc biệt kéo dài (giây)

    // Constructor cho SpecialWeapon
    public SpecialWeapon(String name, int price, String effect, int attackPower, String rarity, double attackSpeed, float range, int specialEffectDamage, double effectDuration ) {
        super(name, price, effect, attackPower, rarity, attackSpeed, range); // Gọi constructor từ Weapon
        this.specialEffectDamage = specialEffectDamage;
        this.effectDuration = effectDuration;
    }

    // Getters cho các thuộc tính mới
    public int getSpecialEffectDamage() {
        return specialEffectDamage;
    }

    public double getEffectDuration() {
        return effectDuration;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", specialEffectDamage=" + specialEffectDamage +
                ", effectDuration=" + effectDuration;
    }
}
