import java.util.LinkedList;
import java.util.Queue;

public class Monster {
    // Thuộc tính
    private String name; // Tên quái vật
    private int HP; // Điểm sức khỏe (Health Points)
    private int attackPoint; // Điểm tấn công
    private int defense; // Điểm phòng thủ
    private float speed; // Tốc độ di chuyển
    private int x, y; // Tọa độ
    private int initialX, initialY; // Tọa độ khởi đầu
    private int directionX, directionY; // Hướng di chuyển

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

    // Phương thức di chuyển
    public void move() {
        // Cập nhật tọa độ dựa trên tốc độ và hướng di chuyển
        x += speed * directionX;
        y += speed * directionY;

        // In ra thông tin di chuyển và tọa độ mới của quái vật
        System.out.println(name + " đang di chuyển với tốc độ: " + speed + ", tọa độ mới: (" + x + ", " + y + ")");
    }

    // Phương thức tấn công
    public void attack(Player player) {
        int damage = attackPoint - player.getDefensePoint();
        if (damage > 0) {
            player.setHP(player.getHP() - damage); // Giảm HP của người chơi
            System.out.println(name + " đã tấn công người chơi gây ra " + damage + " sát thương!");
        } else {
            System.out.println("Tấn công không có hiệu lực!");
        }
    }

    // Phương thức quét lưới tìm người chơi
    public void scan(int[][] grid, Player player) {
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            if (grid[currentX][currentY] == 3) { // Tìm thấy người chơi
                moveTo(currentX, currentY);
                attack(player);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newX = currentX + dRow[i];
                int newY = currentY + dCol[i];

                if (isValid(newX, newY, grid, visited)) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
    }

    // Phương thức di chuyển đến vị trí mục tiêu
    private void moveTo(int targetX, int targetY) {
        while (x != targetX || y != targetY) {
            if (x < targetX) x++;
            else if (x > targetX) x--;

            if (y < targetY) y++;
            else if (y > targetY) y--;

            System.out.println(name + " đang di chuyển tới tọa độ: (" + x + ", " + y + ")");
        }
    }

    // Kiểm tra tính hợp lệ của ô trong lưới
    private boolean isValid(int x, int y, int[][] grid, boolean[][] visited) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y];
    }

    // Phương thức hồi sinh
    public void respawn() {
        this.x = initialX;
        this.y = initialY;
        System.out.println(name + " đã hồi sinh tại (" + x + ", " + y + ")");
    }

    public void reduceHP(int amount) {
        this.HP -= amount;
        if (this.HP <= 0) {
            System.out.println(name + " đã chết và sẽ hồi sinh sau 5 giây.");
            try {
                Thread.sleep(5000); // Chờ 5 giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            respawn(); // Hồi sinh sau khi chết
        }
    }

    @Override
    public String toString() {
        return ("Tên: " + name + ", HP: " + HP + ", Tấn công: " + attackPoint +
                ", Phòng thủ: " + defense + ", Tốc độ: " + speed + ", Tọa độ: (" + x + ", " + y + ")");
    }

    // Getter và Setter nếu cần
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
