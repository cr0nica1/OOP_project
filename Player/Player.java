import java.util.ArrayList;
import java.util.List;

public class Player {
    // Attributes
    private String name;
    private String currentMapName;
    private int HP;
    private int MP;
    private int attackPoint;
    private int defensePoint;
    private float speed;
    private List<Items> inventory; // Dynamic inventory
    private int level;


    // Static attribute
    private static int max_items_number = 16; // Maximum items in inventory

    // Constructor
    public Player(String name, String currentMapName, int HP, int MP, int attackPoint, int defensePoint, float speed, int level) {
        this.name = name;
        this.currentMapName = currentMapName;
        this.HP = HP;
        this.MP = MP;
        this.attackPoint = attackPoint;
        this.defensePoint = defensePoint;
        this.speed = speed;
        this.level = level;
        this.inventory = new ArrayList<>();
        this.x = 0;
        this.y = 0;
    }

    public Player(String name) {
        this(name, null, 1000, 1000, 100, 30, 1.0f, 1);
    }

    // Methods
    public void move(String direction, gameSystem sys) {
        switch (direction.toUpperCase()) {
            case "w" -> y += speed;
            case "a" -> x -= speed;
            case "s" -> y -= speed;
            case "d" -> x += speed;
            default -> System.out.println("Invalid direction!");
        }
        sys.progressMove(x, y);
    }

    public void attack(Monster monster) {
        System.out.println(name + " is attacking " + monster.getName());
        monster.takeDamage(attackPoint);
    }

    public void pickupItem(Items item) {
        if (inventory.size() < max_items_number) {
            inventory.add(item);
            System.out.println(name + " picked up " + item.getName());
        } else {
            System.out.println("Inventory is full! Cannot pick up " + item.getName());
        }
    }

    public void wearingItem(Items item) {
        System.out.println(name + " equipped " + item.getName());
        // Implement item effect logic
    }

    public void usingDrug(Potion potion) { // Assuming Drug is another class
        System.out.println(name + " used: " + drug.getName());
        this.HP += potion.getHealingAmount(); // Example healing logic
    }

    public void enterMap(Map map) {
        System.out.println(name + " entered " + map.getName());
        this.currentMapName = map.getName();
    }

    public void castSkill(Skills skill) {
        System.out.println(name + " used skill: " + skill.getName());
        // Implement skill logic
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getAttackPoint() {
        return attackPoint;
    }

    public void setAttackPoint(int attackPoint) {
        this.attackPoint = attackPoint;
    }

    public int getDefensePoint() {
        return defensePoint;
    }

    public void setDefensePoint(int defensePoint) {
        this.defensePoint = defensePoint;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public List<Items> getInventory() {
        return inventory;
    }

    public void setInventory(List<Items> inventory, GameSystem sys) {
        if (inventory.size() <= max_items_number) {
            this.inventory = inventory;
            sys.updateAbility();
        } else {
            System.out.println("Cannot set inventory. Exceeds maximum allowed items: " + max_items_number);
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCurrentMapName() {
        return currentMapName;
    }

    public void setCurrentMapName(String currentMapName) {
        this.currentMapName = currentMapName;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int getMaxItemsNumber() {
        return max_items_number;
    }

    public static void setMaxItemsNumber(int maxItemsNumber) {
        max_items_number = maxItemsNumber;
    }
}
