public class Player {
    // Attributes
    private String name;
    private String currentMapName; // Current map the player is in
    private int HP;
    private int MP;
    private int attackPoint;
    private int defensePoint;
    private float speed;
    private Item inventory; // Assuming Item is another class
    private int level;
    private int currentExp;      	
    private int expToNextLevel;  

    private GameSystem gameSystem; // attribute another class
    // Constructor
    public Player(String name, String currentMapName, int HP, int MP, int attackPoint, int defensePoint, float speed, int level, GameSystem gameSystem) {
        this.name = name;
        this.currentMapName = currentMapName;
        this.HP = HP;
        this.MP = MP;
        this.attackPoint = attackPoint;
        this.defensePoint = defensePoint;
        this.speed = speed;
        this.level = level;
        this.inventory = null; // Initially empty
        this.gameSystem = gameSystem; // Link to the game system
        this.currentExp = 0;
        this.expToNextLevel = 100;
    }

    // Default Constructor 
    public Player(GameSystem gameSystem) {
        this.name = "New Player";
        this.currentMapName = "Map 0";
        this.HP = 50; 
        this.MP = 25;  
        this.attackPoint = 10; 
        this.defensePoint = 5; 
        this.speed = 1.0f; 
        this.level = 1; 
        this.inventory = null; 
        this.gameSystem = gameSystem; 
        this.currentExp = 0;
        this.expToNextLevel = 100;
    }
    
    // Methods
    public void move(char direction) {
        int newX = 0; 
        int newY = 0; 

        // Determine new coordinates based on direction
        switch (direction) {
            case 'W' -> // Move up
                newY += speed;
            case 'A' -> // Move left
                newX -= speed;
            case 'S' -> // Move down
                newY -= speed;
            case 'D' -> // Move right
                newX += speed;
            }
        }

        // Send movement information to the game system
        gameSystem.processMove(this, currentMapName, newX, newY);
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


    public String getCurrentMapName() {
        return currentMapName;
    }


    public void setCurrentMapName(String currentMapName) {
        this.currentMapName = currentMapName;
    }


    public GameSystem getGameSystem() {
        return gameSystem;
    }


    public void setGameSystem(GameSystem gameSystem) {
        this.gameSystem = gameSystem;
    }
    
    public void gainexp (int exp) {
    	System.out.println(name + " gained " + exp + " experience points!");
    	currentExp += exp;
    	while (currentExp >= expToNextLevel) {
    		levelUp();
    	}
    }
    
    private void levelUp() {
        level++;
        currentExp -= expToNextLevel; 
        expToNextLevel += 50; 
        HP += 10;
        MP += 5;
        attackPoint += 2;
        defensePoint += 1;
        speed += 0.1f;

        System.out.println(name + " leveled up! Now at level " + level + "!");
        System.out.println("New stats: HP=" + HP + ", MP=" + MP + ", Attack=" + attackPoint + ", Defense=" + defensePoint + ", Speed=" + speed);
    }
}