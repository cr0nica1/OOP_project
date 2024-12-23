import java.util.Queue;
import java.util.LinkedList;

public class Monster {
    private String name;
    private int HP;
    private int attackPoint;
    private int defense;
    private float speed;
    private int x, y;
    private int initialX, initialY;
    private int directionX, directionY;
    private int range;

    public Monster(String name, int HP, int attackPoint, int defense, float speed, int x, int y, int directionX, int directionY, int range) {
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
        this.range = range;
    }

    public void attack(Player player) {
        double distance = Math.sqrt(Math.pow(player.getX() - this.x, 2) + Math.pow(player.getY() - this.y, 2));
        if (distance <= range) {
            int damage = attackPoint - player.getDefensePoint();
            if (damage > 0) {
                player.setHP(player.getHP() - damage);
                System.out.println(name + " tấn công người chơi và gây ra " + damage + " damage!");
            } else {
                System.out.println("tấn công không ảnh hưởng gì!");
            }
        } else {
            System.out.println(name + " ngoài tầm tấn công");
        }
    }

    public void move() {
        x += speed * directionX;
        y += speed * directionY;
        System.out.println(name + " đang di chuyển với tốc độ: " + speed + ", tọa độ mới: (" + x + ", " + y + ")");
    }

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

    private void moveTo(int targetX, int targetY) {
        while (x != targetX || y != targetY) {
            if (x < targetX) x++;
            else if (x > targetX) x--;

            if (y < targetY) y++;
            else if (y > targetY) y--;

            System.out.println(name + " đang di chuyển tới tọa độ: (" + x + ", " + y + ")");
        }
    }

    private boolean isValid(int x, int y, int[][] grid, boolean[][] visited) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y];
    }

    public void respawn() {
        this.x = initialX;
        this.y = initialY;
        System.out.println(name + " đã hồi sinh tại (" + x + ", " + y + ")");
    }

    public void takeDamage(int damage) {
        this.HP -= damage;
        if (this.HP <= 0) {
            System.out.println(this.name + " đã chết!");
        }
    }


    @Override
    public String toString() {
        return ("Tên: " + name + ", HP: " + HP + ", Tấn công: " + attackPoint +
                ", Phòng thủ: " + defense + ", Tốc độ: " + speed + ", Tọa độ: (" + x + ", " + y + ")");
    }

    // Getter và Setter nếu cần
      public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
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
