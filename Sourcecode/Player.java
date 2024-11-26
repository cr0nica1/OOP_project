// Class Player
public class Player {
    // Attributes
    private String name;
    private String mapnames;
    private int HP;
    private int MP;
    private int attackPoint;
    private int defensePoint;
    private float speed;
    private Item inventory; // Assuming Item is another class
    private int level;

    // Constructor
    public Player(String name, String mapnames, int HP, int MP, int attackPoint, int defensePoint, float speed, int level) {
        this.name = name;
        this.mapnames = mapnames;
        this.HP = HP;
        this.MP = MP;
        this.attackPoint = attackPoint;
        this.defensePoint = defensePoint;
        this.speed = speed;
        this.level = level;
        this.inventory = null; // Initially empty
    }

    // Methods
    public void move() {
        System.out.println(speed);
    }

    public void attack(Monster monster) { // Assuming Monster is another class
        System.out.println(name + " is attacking " + monster.getName());
        monster.takeDamage(attackPoint);
    }

    public void pickupItem(Item item) {
        System.out.println(name + " picked up " + item.getName());
        this.inventory = item;
    }

    public void wearingItem(Item item) {
        System.out.println(name + " equied " + item.getName());
        // Implement logic for wearing item
    }

    public void usingDrug(Drug drug) { // Assuming Drug is another class
        System.out.println(name + " used: " + drug.getName());
        this.HP += drug.getHealingAmount(); // Example healing logic
    }

    public void enterMap() {
        System.out.println(mapnames + " entered.");
    }

    public void usingSkill(Skill skill) { // Assuming Skill is another class
        System.out.println(name + " used skill: " + skill.getName());
        // Implement skill logic
    }

    // Getters and setters (optional, based on need)
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

    public Item getInventory() {
        return inventory;
    }

    public void setInventory(Item inventory) {
        this.inventory = inventory;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
