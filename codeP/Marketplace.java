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
        addItem(new Potion("Health Potion", 50, "Restore 50 HP", 50, 5, "A"));
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
