import java.util.HashMap;
import java.util.Map;

public class Marketplace {
    private final Map<String, Items> items;

    public Marketplace() {
        items = new HashMap<>();
        addItems();
    }

    private void addItems() {
        addItem(new Weapon("Axe of Power", 1200, "Hit", 70, "B+", 1.0, 2));
        addItem(new Weapon("Machine Gun", 2000, "Shoot", 120, "A", 7.6, 4));
        addItem(new Armor("Shield of Valor", 800, "Blocks attacks", 40, "A"));
        addItem(new Armor("Helmet of Wisdom", 500, "Increases defense", 30, "B"));
        addItem(new Weapon("Skyrim Knife",300,"Hit",15,"D",1.3,1)); //Dao gam re tien
        addItem(new Weapon("Infinity Sword",3500,"Hit",250,"S",4.5,2)); // Vo cuc kiem sieu manh voi damage cuc to
        addItem(new Weapon("Banana Scythe",1350,"Hit",75,"B+",2.0,3)); // luoi hai chuoi,vu khi voi tao hinh sieu buon cuoi gay loi cuon
        addItem(new SpecialWeapon("Skyward Atlas",3200,"Hit",400,"S",0.75,5,"Burn"));
        addItem(new Weapon("Bow",600,"Hit",20,"D",1.5,2));
        addItem(new SpecialWeapon("FlameBlade",2100,""))
    }

    private void addItem(Items item) {
        items.put(item.getName().toLowerCase(), item);
    }

    public void showItems() {
        System.out.println("Marketplace Items:");
        for (Items item : items.values()) {
            System.out.println(item);
        }
    }

    public Items getItemByName(String itemName) {
        return items.get(itemName.toLowerCase());
    }

    public String useItem(String itemName) {
        Items item = getItemByName(itemName);
        if (item != null) {
            return item.usingItems();
        }
        return "Item not found.";
    }
}
