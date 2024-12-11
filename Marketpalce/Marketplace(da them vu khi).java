public class Marketplace {
    private List<Weapon> weapons;  // Danh sách vũ khí
    private List<Armor> armors;    // Danh sách giáp

    // Constructor khởi tạo marketplace
    public Marketplace() {
        weapons = new ArrayList<>();
        armors = new ArrayList<>();

        // Thêm các vật phẩm vào marketplace
        addWeapons();
        addArmors();
    }

    // Thêm vũ khí vào marketplace
    private void addWeapons() {
        weapons.add(new Weapon("Sword of Fire", 1000, "Burns enemies", 50));
        weapons.add(new Weapon("Axe of Power", 1200, "Deals massive damage", 70));
        weapons.add(new Weapon("Bow of Precision", 900, "Shoots with great accuracy", 40));
        weapons.add(new Weapon("Dagger of Stealth", 500, "Increases agility", 30));
        weapons.add(new Weapon("Staff of Wisdom", 1500, "Increases magic power", 60));
        weapons.add(new Weapon("Mace of Justice", 1100, "Deals high damage to evil creatures", 80));
        weapons.add(new Weapon("Spear of the Sea", 800, "Pierces through enemies with speed", 45));
        weapons.add(new Weapon("Hammer of Thor", 2000, "Thunder damage on hit", 100));
        weapons.add(new Weapon("Crossbow of Silence", 1200, "Silent and deadly", 55));
        weapons.add(new Weapon("Claymore of the Titan", 1800, "Deals massive area damage", 95));
    }

    // Thêm giáp vào marketplace
    private void addArmors() {
        armors.add(new Armor("Shield of Valor", 800, "Blocks attacks", 40));
        armors.add(new Armor("Helmet of Wisdom", 500, "Increases defense", 30));
        armors.add(new Armor("Armor of Fortitude", 1000, "Increases health points", 50));
        armors.add(new Armor("Cloak of Invisibility", 1200, "Makes you invisible", 0)); // No defense, but invisibility
        armors.add(new Armor("Plate of Immortality", 2000, "Restores health over time", 60));
        armors.add(new Armor("Gauntlets of Strength", 700, "Increases attack power", 35));
        armors.add(new Armor("Boots of Speed", 600, "Increases movement speed", 0)); // No defense, but speed
        armors.add(new Armor("Bracers of Protection", 750, "Reduces incoming damage", 25));
        armors.add(new Armor("Crown of the Ancients", 1300, "Increases intelligence", 20)); // Increases magic defense
        armors.add(new Armor("Chestplate of the Immortal", 1500, "Grants resistance to physical attacks", 45));
    }

    // Phương thức lấy tất cả các vũ khí
    public List<Weapon> getWeapons() {
        return weapons;
    }

    // Phương thức lấy tất cả các giáp
    public List<Armor> getArmors() {
        return armors;
    }

    // Hiển thị tất cả các vật phẩm
    public void showItems() {
        System.out.println("Weapons:");
        for (Weapon weapon : weapons) {
            System.out.println(weapon);
        }

        System.out.println("\nArmors:");
        for (Armor armor : armors) {
            System.out.println(armor);
        }
    }
}
