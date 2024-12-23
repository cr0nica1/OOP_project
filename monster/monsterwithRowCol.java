import java.util.LinkedList;
import java.util.Queue;

public class Monster {
    // Thuộc tính
    private String name; // Tên quái vật
    private int HP; // Điểm sức khỏe (Health Points)
    private int attackPoint; // Điểm tấn công
    private int defense; // Điểm phòng thủ
    private float speed; // Tốc độ di chuyển
    private int row, col; // Tọa độ (hàng, cột)
    private int initialRow, initialCol; // Tọa độ khởi đầu
    private int directionRow, directionCol; // Hướng di chuyển

    // Constructor
    public Monster(String name, int HP, int attackPoint, int defense, float speed, int row, int col, int directionRow, int directionCol) {
        this.name = name;
        this.HP = HP;
        this.attackPoint = attackPoint;
        this.defense = defense;
        this.speed = speed;
        this.row = row;
        this.col = col;
        this.initialRow = row;
        this.initialCol = col;
        this.directionRow = directionRow;
        this.directionCol = directionCol;
    }

    // Phương thức di chuyển
    public void move() {
        // Cập nhật tọa độ dựa trên tốc độ và hướng di chuyển
        row += speed * directionRow;
        col += speed * directionCol;

        // In ra thông tin di chuyển và tọa độ mới của quái vật
        System.out.println(name + " đang di chuyển với tốc độ: " + speed + ", tọa độ mới: (" + row + ", " + col + ")");
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

        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            if (grid[currentRow][currentCol] == 3) { // Tìm thấy người chơi
                moveTo(currentRow, currentCol);
                attack(player);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = currentRow + dRow[i];
                int newCol = currentCol + dCol[i];

                if (isValid(newRow, newCol, grid, visited)) {
                    queue.add(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }

    // Phương thức di chuyển đến vị trí mục tiêu
    private void moveTo(int targetRow, int targetCol) {
        while (row != targetRow || col != targetCol) {
            if (row < targetRow) row++;
            else if (row > targetRow) row--;

            if (col < targetCol) col++;
            else if (col > targetCol) col--;

            System.out.println(name + " đang di chuyển tới tọa độ: (" + row + ", " + col + ")");
        }
    }

    // Kiểm tra tính hợp lệ của ô trong lưới
    private boolean isValid(int row, int col, int[][] grid, boolean[][] visited) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !visited[row][col];
    }

    // Phương thức hồi sinh
    public void respawn() {
        this.row = initialRow;
        this.col = initialCol;
        System.out.println(name + " đã hồi sinh tại (" + row + ", " + col + ")");
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
                ", Phòng thủ: " + defense + ", Tốc độ: " + speed + ", Tọa độ: (" + row + ", " + col + ")");
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

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getDirectionRow() {
        return directionRow;
    }

    public void setDirectionRow(int directionRow) {
        this.directionRow = directionRow;
    }

    public int getDirectionCol() {
        return directionCol;
    }

    public void setDirectionCol(int directionCol) {
        this.directionCol = directionCol;
    }

    public String getName() {
        return name;
    }
}
