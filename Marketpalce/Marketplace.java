
import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    private final List<Weapon> weapons;  // Danh sách vũ khí
    private final List<Armor> armors;    // Danh sách giáp


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
        weapons.add(new Weapon("Axe of Power", 1200, "Hit", 70,"B+",1.0,2)); // Riu gay dame vat ly
        weapons.add(new Weapon("Machine Gun",2000,"Shoot",120,"A",7.6,4)); //Sung may 6 nong sieu khoe dia nguc
        weapons.add(new Weapon("Bad Gun",400,"Shoot",20,"D",1.3,2));   // Sung deu re tien
        weapons.add(new Weapon("Skyrim Knife",300,"Hit",15,"D",1.3,1)); //Dao gam re tien
        weapons.add(new Weapon("Infinity Sword",3500,"Hit",250,"S",4.5,2)); // Vo cuc kiem sieu manh voi damage cuc to
        weapons.add(new Weapon("Banana Scythe",1350,"Hit",75,"B+",2.0,3)); // luoi hai chuoi,vu khi voi tao hinh sieu buon cuoi gay loi cuon
        weapons.add(new Weapon("Skyward Atlas",3200,"Burn enemies"+"Hit",400,"S",0.75,5));
        weapons.add(new Weapon("Mace",450,"Hit",25,"D",1.4,1));
        weapons.add(new Weapon("Iron Sword", 100, "Slash", 20, "C", 1.5, 1));
        weapons.add(new Weapon("Warrior Greatsword", 350, "Slash", 50, "B", 1.0, 1));
        weapons.add(new Weapon("Ancient Battle Axe", 400, "Chop", 55, "B", 0.9, 1));
        weapons.add(new Weapon("Dagger of Shadows", 300, "Stab", 25, "C", 2.0, 1));
        weapons.add(new Weapon("Wooden Bow", 250, "Shoot", 35, "C", 0.7, 2));
        weapons.add(new Weapon("Mystic Crossbow", 600, "Shoot", 60, "A", 0.6, 4));
        weapons.add(new Weapon("Silver Spear", 450, "Pierce", 45, "B", 1.2, 2));
        weapons.add(new Weapon("Thunder Hammer", 800, "Smash", 80, "S", 0.8, 1));
        weapons.add(new Weapon("Dark Mage Staff", 700, "Blast", 65, "A", 1.0, 4));
        weapons.add(new Weapon("Twin Blades of Shadow", 1000, "Slash", 90, "S", 2.2, 1));

    }

    // Thêm giáp vào marketplac
    private void addArmors() {
        armors.add(new Armor("Shield of Valor", 800, "Blocks attacks", 40,"A"));
        armors.add(new Armor("Helmet of Wisdom", 500, "Increases defense", 30,"B"));
        armors.add(new Armor("Simple Leather Armor", 150, "Basic protection", 10, "C"));
        armors.add(new Armor("Sturdy Iron Armor", 400, "Solid defense", 30, "B"));
        armors.add(new Armor("Cloak of Shadows", 350, "Increases stealth", 15, "C"));
        armors.add(new Armor("Royal Gold Armor", 600, "Regal defense", 45, "A"));
        armors.add(new Armor("Ancient Knight Shield", 500, "Blocks attacks", 40, "B"));
        armors.add(new Armor("Legendary Dragon Armor", 1000, "Mythical defense", 60, "S"));
        armors.add(new Armor("Ancient Mage Robe", 700, "Magic resistance", 20, "A"));
        armors.add(new Armor("Titan's Unbreakable Armor", 1500, "Ultimate protection", 80, "S"));
        armors.add(new Armor("Bronze Chestplate", 200, "Basic metal protection", 20, "C"));
        armors.add(new Armor("Steel Breastplate", 450, "Heavy defense", 35, "B"));
        armors.add(new Armor("Shadow Assassin Armor", 500, "Stealth and agility boost", 25, "A"));
        armors.add(new Armor("Phoenix Feather Cloak", 750, "Resistance to fire damage", 30, "A"));
        armors.add(new Armor("Crystal Guardian Plate", 900, "Magic and physical defense", 50, "S"));
        armors.add(new Armor("Elven Chainmail", 550, "Lightweight and durable", 40, "B"));
        armors.add(new Armor("Demonic Plate", 1100, "Infernal power boost", 65, "S"));
        armors.add(new Armor("Frozen Warden Armor", 850, "Cold resistance and defense", 55, "A"));
        armors.add(new Armor("Lionheart Battle Armor", 1200, "Increases courage and defense", 70, "S"));
        armors.add(new Armor("Heavenly Aegis", 1600, "Ultimate divine protection", 85, "S"));

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
