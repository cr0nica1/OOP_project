import java.util.ArrayList;
import java.util.List;

public class Player {
    // Attributes
    private String name;
    private String currentMapName;
    private int HP;
    private int MP;
    private int maxHP;
    private int maxMP;
    private int originalAttackPoint;
    private int originalDefensePoint;
    private float originalrange;
    private int attackPoint;
    private int defensePoint;
    private float speed;
    private List<Items> inventory;
    private List<Skills> availableSkill; 
    private int level;
    private int gold;
    private int x;
    private int y;
    private float range;
    private int defense;


    // Static attribute
    private static int max_items_number = 16; // Maximum items in inventory
    private static int max_skills_number = 5; // Maximum skills in availableSkill
   
    // Constructor
    public Player(String name, String currentMapName, int HP, int MP, int attackPoint, int defensePoint, float speed, int level, int gold) {
        this.name = name;
        this.currentMapName = currentMapName;
        this.maxHP = HP;
        this.maxMP = MP;
        this.HP = HP;
        this.MP = MP;
        this.defense = defense;
        this.originalAttackPoint = attackPoint;
        this.originalDefensePoint = defensePoint;
        this.attackPoint = attackPoint;
        this.defensePoint = defensePoint;
        this.speed = speed;
        this.level = level;
        this.gold=gold;
        this.inventory = new ArrayList<>();
        this.availableSkill= new ArrayList<>();
        this.x = 0;
        this.y = 0;

        this.range = 1.0f;
        this.originalrange = 1.0f;

    }

    public Player(String name) {
        this(name, null, 1000, 1000, 100, 30, 1.0f, 1, 10000);
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
        sys.processMove(x, y,oldx,oldy);
    }
    


    public void attack(Monster monster) {
        int damage=attackPoint-monster.getDefense();
        if (damage>0) {
            monster.setHP(monster.getHP()-damage);
            System.out.println("Player " + name + "dealt "+ damage + " damages!");
        }
        
    }
    public void printStatus() {
     
        System.out.println("Name: " + name);
        System.out.println("HP: " + HP);
        System.out.println("MP: " + MP);
        System.out.println("Attack Point: " + attackPoint);
        System.out.println("Defense Point: " + defensePoint);
        System.out.println("Speed: " + speed);
        System.out.println("Level: " + level);
        System.out.println("Gold: " + gold);
        System.out.println("Current Map: " + currentMapName);
        System.out.println("Position: (" + x + ", " + y + ")");
    }
    public boolean checking_inventory( Items items){
        for( Items m:inventory){
            if (items.getType()==m.getType()) {
                return false;
            }
        }
        return true;
    }
    public boolean cheking_skill(Skills skill){
        for( Skills m:availableSkill){
            if (skill.getSkillName()==m.getSkillName()) {
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
    public void dropItem(Items item, gameSystem sys) {
        if (inventory.size()>0) {
            inventory.remove(item);
            System.out.println(name+ " drop "+ item.getName());
        }else{
            System.out.println("Inventory is empty!");
        }
    }   
    public void showPotion(){
        for(Items item:inventory){
            if (item.getType().equals("Potion")) {
                System.out.println(item.getName());
            }
        }
    }
    public void usePotion(Potion potion) { // Assuming Drug is another class
        for(int i=0;i<this.inventory.size();i++){
            if (this.inventory.get(i)==potion) {

                Potion drug=(Potion) this.inventory.get(i);
                for (int j=0;j<drug.getDuration();j++){
                    if (this.getHP()>=this.getMaxHP()) {
                        this.setHP(this.getMaxHP());
                        return;
                    }
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

    public void castSkill(Skills skill, Monster monster) {
        // Implement skill logic
        if (MP < skill.getMPcost()) {
            System.out.println("Not enough MP to cast this skill.");
            return;
        }
        MP -= skill.getMPcost();
        int damage = skill.getSkillPower() - monster.getDefense();
        if (damage > 0) {
            monster.setHP(monster.getHP() - damage);
            System.out.println(name + " used " + skill.getSkillName() + " and dealt " + damage + " damage to " + monster.getName());
        } else {
            System.out.println(name + " used " + skill.getSkillName() + " but dealt no damage to " + monster.getName());
        }
    }

    // Getters and setters
    public float getOriginalrange() {
        return originalrange;
    }
    public void setOriginalrange(float originalrange) {
        this.originalrange = originalrange;
    }
    public int getOriginalAttackPoint() {
        return originalAttackPoint;
    }
    public void setOriginalAttackPoint(int originalAttackPoint) {
        this.originalAttackPoint = originalAttackPoint;
    }
    public int getOriginalDefensePoint() {
        return originalDefensePoint;
    }
    public void setOriginalDefensePoint(int originalDefensePoint) {
        this.originalDefensePoint = originalDefensePoint;
    }
    public int getMaxHP() {
        return maxHP;
    }
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
    public int getMaxMP() {
        return maxMP;
    }
    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }
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

    public List<Skills> getAvailableSkill() { 
        return availableSkill; 
    }
    
    public void setAvailableSkill(List<Skills> availableSkill) {
        if (availableSkill.size() <= max_skills_number) {
            this.availableSkill = availableSkill;
        } else {
            System.out.println("Skill list exceeds maximum allowed size of " + max_skills_number + ".");
        }
    }
    public void showSkill(){
        for(Skills skill:availableSkill){
            System.out.println(skill.getSkillName());
        }
    }
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
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
    
    public static int getMaxSkillsNumber() {
        return max_skills_number;
    }

    public static void setMaxSkillsNumber(int maxSkillsNumber) {
        max_skills_number = maxSkillsNumber;
    }
    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

}

