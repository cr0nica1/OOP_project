public class SpecialWeapon extends Weapon {
    private final String specialEffectName;

    public SpecialWeapon(String name, int price, String effect, int attackPower, String rarity,
                         double attackSpeed, float range, String specialEffectName) {
        super(name, price, effect, attackPower, rarity, attackSpeed, range);
        this.specialEffectName = specialEffectName;
    }

    // Tính tổng damage bao gồm cả damage từ hiệu ứng đặc biệt
    public int getTotalAttackDamage() {
        return getattackPower() + SpecialEffect.getEffectDamage(specialEffectName);
    }

    @Override
    public String usingItems() {
        StringBuilder result = new StringBuilder();
        result.append("You are using special weapon: ").append(getName())
                .append("\nBase Damage: ").append(getattackPower())
                .append("\nAttack Speed: ").append(getAttackSpeed())
                .append("\nRange: ").append(getRange())
                .append("\nSpecial Effect: ").append(SpecialEffect.getEffectDetails(specialEffectName))
                .append("\nTotal Damage: ").append(getTotalAttackDamage());

        return result.toString();
    }
}
