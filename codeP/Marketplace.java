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
    }

    // Thêm giáp vào marketplac
    private void addArmors() {
        armors.add(new Armor("Shield of Valor", 800, "Blocks attacks", 40,"A"));
        armors.add(new Armor("Helmet of Wisdom", 500, "Increases defense", 30,"B"));
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