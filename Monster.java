public class Monster {
    // Attributes
    private String name;       // Monster's name
    private int HP;            // Health Points
    private int attackPoint;   // Attack points
    private int defense;       // Defense points
    private float speed;       // Movement speed
    private int x, y;          // Current coordinates
    private int initialX, initialY; // Initial spawn coordinates
    private int directionX, directionY; // Movement direction

    // Constructor
    public Monster(String name, int HP, int attackPoint, int defense, float speed, int x, int y, int directionX, int directionY) {
        this.name = name;
        this.HP = HP;
        this.attackPoint = attackPoint;
        this.defense = defense;
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.initialX = x;
        this.initialY = y;
        this.directionX = directionX;
        this.directionY = directionY;
    }

    // Move method
    public void move() {
        // Update coordinates based on speed and direction
        x += speed * directionX;
        y += speed * directionY;

        // Display movement information and new coordinates
        System.out.println(name + " is moving at speed: " + speed + ", new coordinates: (" + x + ", " + y + ")");
    }

    // Attack method
    public void attack(Player player) {
        int damage = attackPoint - player.getDefensePoint();
        if (damage > 0) {
            player.setHP(player.getHP() - damage); // Reduce player's HP
            System.out.println(name + " attacked the player and dealt " + damage + " damage!");
        } else {
            System.out.println(name + "'s attack had no effect!");
        }
    }

    // Respawn method
    public void respawn() {
        this.x = initialX;
        this.y = initialY;
        System.out.println(name + " has respawned at (" + x + ", " + y + ")");
    }

    // Reduce HP method
    public void reduceHP(int amount) {
        this.HP -= amount;
        if (this.HP <= 0) {
            System.out.println(name + " has died and will respawn in 5 seconds.");
            try {
                Thread.sleep(5000); // Wait 5 seconds before respawning
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            respawn(); // Respawn after death
        }
    }

    // toString method to display monster information
    @Override
    public String toString() {
        return ("Name: " + name + ", HP: " + HP + ", Attack: " + attackPoint +
                ", Defense: " + defense + ", Speed: " + speed + ", Coordinates: (" + x + ", " + y + ")");
    }

    // Getters and Setters
    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttackPoint() {
        return attackPoint;
    }

    public void setAttackPoint(int attackPoint) {
        this.attackPoint = attackPoint;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
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

    public int getDirectionX() {
        return directionX;
    }

    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }

    public int getDirectionY() {
        return directionY;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }

    public String getName() {
        return name;
    }
}
