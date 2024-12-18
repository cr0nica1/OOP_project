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
    private int x;
    private int y;
    private float range;
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
        this.range=1.0f;
    }

    public Player(String name) {
        this(name, null, 1000, 1000, 100, 30, 1.0f, 1);
    }

    // Methods
    public void move(String direction, gameSystem sys) {
        int oldx=this.x;
        int oldy=this.y;
        switch (direction.toUpperCase()) {
            case "A" -> y -= speed;
            case "W" -> x -= speed;
            case "D" -> y += speed;
            case "S" -> x += speed;
            default -> System.out.println("Invalid direction!");
        }
        System.out.println("test");

        sys.processMove(x, y,oldx,oldy);
    }

    public void attack(Monster monster) {
        int damage=attackPoint-monster.getDefense();
        if (damage>0) {
            monster.setHP(monster.getHP()-damage);
            System.out.println("Người chơi gây ra " + damage + " sát thương!");
        }
        
    }
    public boolean checking_inventory( Items items){
        for( Items m:inventory){
            if (items.getType()==m.getType()) {
                return false;
            }
        }
        return true;
    }
    public void pickupItem(Items item) {
        if (inventory.size() < max_items_number) {
            if (checking_inventory(item)) {
            inventory.add(item);
            System.out.println(name + " picked up " + item.getName());
            }
            if (!checking_inventory(item)) {
                System.out.println(item.getType()+"is equipped");
            }
        } else {
            System.out.println("Inventory is full! Cannot pick up " + item.getName());
        }
    }
    public void dropItem(Items item){
        if (inventory.size()>0) {
            inventory.remove(item);
            System.out.println(name+ " drop "+ item.getName());
        }
    }   
    public void usingDrug(Potion potion) { // Assuming Drug is another class
        for(int i=0;i<this.inventory.size();i++){
            if (this.inventory.get(i)==potion) {

                Potion drug=(Potion) this.inventory.get(i);
                for (int j=0;j<drug.getDuration();j++){
                    this.setHP(this.getHP()+drug.getAttributePoints());
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){   
                        System.err.println(e.getMessage());                     
                    }
                }
            }
        }
    }

    public void enterMap(map map) {
        System.out.println(name + " entered " + map.getClass());
     
    }

    public void castSkill(Skills skill) {
        // Implement skill logic
    }

    // Getters and setters
    public float getRange(){
        return range;
    }
    public void setRange(float range){
        this.range=range;
    }
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

    public void setInventory(List<Items> inventory, gameSystem sys) {
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
