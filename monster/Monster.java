public class Monster {
    // Thuộc tính
    private String name; // Tên quái vật
    private int HP; // Điểm sức khỏe (Health Points)
    private int attackPoint; // Điểm tấn công
    private int defense; // Điểm phòng thủ
    private float speed; // Tốc độ di chuyển
    private int x, y; // Tọa độ
    private int initialX, initialY; // Tọa độ khởi đầu
    

    // Constructor
    public Monster(String name, int HP, int attackPoint, int defense, float speed, int x, int y) {
        this.name = name;
        this.HP = HP;
        this.attackPoint = attackPoint;
        this.defense = defense;
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.initialX = x;
        this.initialY = y;

    }

    // Phương thức di chuyển
    public void move() {
        // Cập nhật tọa độ dựa trên tốc độ và hướng di chuyển

        // In ra thông tin di chuyển và tọa độ mới của quái vật
        System.out.println(name + " đang di chuyển với tốc độ: " + speed + ", tọa độ mới: (" + x + ", " + y + ")");
    }

    // Phương thức tấn công
    public void attack(Player player) {
        int damage = attackPoint - player.getDefensePoint();
        if (damage > 0) {
            player.setHP(player.getHP()-damage);; // Giảm HP của người chơi
            System.out.println(name + " đã tấn công người chơi gây ra " + damage + " sát thương!");
        } else {
            System.out.println("Tấn công không có hiệu lực!");
        }
    }

 
    public Boolean die(){
        if (HP==0) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return ("Tên: " + name + ", HP: " + HP + ", Tấn công: " + attackPoint +
                ", Phòng thủ: " + defense + ", Tốc độ: " + speed + ", Tọa độ: (" + x + ", " + y + ")");
    }

    // Getter và Setter nếu cần
    public int getInitX(){
        return initialX;
    }
    public int getInitY(){
        return initialY;

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

    public String getName(){
        return name;
    }
}
