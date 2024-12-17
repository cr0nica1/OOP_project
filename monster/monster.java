public class Monster {
    // Thuộc tính
    private int HP; // Điểm sức khỏe
    private int attackPoint; // Điểm tấn công
    private int defense; // Điểm phòng thủ
    private float speed; // Tốc độ di chuyển

    // Constructor
    public Monster(String name, int HP, int attackPoint, int defense, int speed) {
        this.HP = HP;
        this.attackPoint = attackPoint;
        this.defense = defense;
        this.speed = speed;
    }
    
    // Phương thức di chuyển
    public void move() {
        // Logic di chuyển quái vật
        System.out.println("Quái vật đang di chuyển với tốc độ: " + speed);
        // Có thể thêm logic để thay đổi vị trí của quái vật
    }

    // Phương thức tấn công người chơi
    public void attack(Player player) {
        int damage = attackPoint - player.getDefensePoint(); // Tính sát thương
        if (damage > 0) {
            player.setHP(player.getHP()-damage);; // Giảm HP của người chơi
            System.out.println("Quái vật tấn công người chơi và gây ra " + damage + " sát thương!");
        } else {
            System.out.println("Tấn công không có hiệu lực!");
        }
    }

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

    public void setPosition(int monsterX, int monsterY) {
    }
}