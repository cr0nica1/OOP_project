import java.security.PublicKey;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Monster {
    // Thuộc tính
    private String name; // Tên quái vật
    private int HP; // Điểm sức khỏe (Health Points)
    private int attackPoint; // Điểm tấn công
    private int defense; // Điểm phòng thủ
    private float speed; // Tốc độ di chuyển
    private int x, y; // Tọa độ
    private int initHP;



    // Constructor
    public Monster(String name, int HP, int attackPoint, int defense, float speed, int x, int y) {
        this.name = name;
        this.HP = HP;
        this.attackPoint = attackPoint;
        this.defense = defense;
        this.speed = speed;
        this.x = x;
        this.y = y;


    }

    // Phương thức di chuyển
    public void move() {

        // In ra thông tin di chuyển và tọa độ mới của quái vật
        System.out.println(name + " moving at speed: " + speed + ", new coordinate: (" + x + ", " + y + ")");
    }
    public List<int[]> tracePath(Map<String, String> parentMap, int endX, int endY) {
        List<int[]> path = new LinkedList<>();
        String node = endX + "," + endY;
        while (node != null) {
            String[] parts = node.split(",");
            path.add(0, new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])});
            node = parentMap.get(node);
        }
        return path;
    }


    public List<int[]> findPath(map m, int targetX, int targetY) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int rows = m.getGrid().length;
        int cols = m.getGrid()[0].length;
        int[][] dist = new int[rows][cols];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Map<String, String> parentMap = new HashMap<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        dist[x][y] = 0;
        parentMap.put(x + "," + y, null);
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cur_x = current[0];
            int cur_y = current[1];
            if (cur_x == targetX && cur_y == targetY) {
                return tracePath(parentMap, cur_x, cur_y);
            }
            for (int i = 0; i < 4; i++) {
                int newX = cur_x + dx[i];
                int newY = cur_y + dy[i];
                if (newX >= 0 && newY >= 0 && newX < rows && newY < cols && m.getGrid()[newX][newY] != 1) {
                    int newDist = dist[cur_x][cur_y] + 1;
                    if (newDist < dist[newX][newY]) {
                        dist[newX][newY] = newDist;
                        q.offer(new int[]{newX, newY});
                        parentMap.put(newX + "," + newY, cur_x + "," + cur_y);
                    }
                }

            }
        }
        return null;
    }
    public void moveToTarget(map map, int targetX, int targetY) {
        List<int[]> path = findPath(map, targetX, targetY);
        if (path != null && !path.isEmpty()) {
            int steps = 0; // Biến đếm số bước di chuyển
            for (int[] step : path) {
                x = step[0];
                y = step[1];

                steps++;
                // Chỉ in ra thông tin sau mỗi 3 bước di chuyển
                if (steps % 3 == 0) {
                    System.out.println("Goblin Position after " + steps + " steps: (" + x + ", " + y + ")");
                }

                // Tạm dừng để mô phỏng thời gian di chuyển, chia thời gian tạm dừng theo tốc độ
                try {
                    Thread.sleep((long) (1000 / speed));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }




    public void scan(map Map, Player player) {
        if (takedamage()) {
            int[] dRow = {-1, 1, 0, 0};
            int[] dCol = {0, 0, -1, 1};
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[Map.getGridWidth()][Map.getGridHeight()];
            q.add(new int[]{x, y});
            visited[x][y] = true;
            int steps = 0;
            while (!q.isEmpty()) {
                int[] current = q.poll();
                int row = current[0];
                int col = current[1];

                steps ++;

                // Chỉ in ra thông tin khi Goblin di chuyển 3 ô
                if (steps % 3 == 0) {
                    System.out.println("Goblin Position after " + steps + " steps: (" + row + ", " + col + ")");
                }


                if (row < Map.getGridHeight() && col < Map.getGridWidth()) {
                    if (Map.getGrid()[row][col] == 3) {
                        for (int i = 0; i < 4; i++) {
                            int r = y + dRow[i];
                            int c = x + dCol[i];
                            if (Map.getGrid()[r][c] == 3) {
                                attack(player);
                                System.out.println("Attacking at position: (" + r + ", " + c + ")");
                            }
                        }
                    }
                }
                for (int i = 0; i < 4; i++) {
                    int newRow = row + dRow[i];
                    int newCol = col + dCol[i];
                    if (newCol >= 0 && newRow >= 0 && newCol < Map.getGridWidth() && newRow < Map.getGridHeight() && !visited[newCol][newRow]) {
                        visited[newCol][newRow] = true;

                        if (Math.abs(newRow - x) <= 1 && Math.abs(newCol - y) <= 1) {
                            int damage = 10;
                            player.setHP(player.getHP() - damage);
                            System.out.println("Monster has attacked player for " + damage + " damage at position: (" + newRow + ", " + newCol + ")");
                            return;
                        }

                        q.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
    }


    public boolean takedamage(){
        if (HP<initHP) {
            return true;
        }
        return false;
    }
    public boolean die(){
        if (HP==0) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return ("Name: " + name + ", HP: " + HP + ", Attack: " + attackPoint +
                ", Defense: " + defense + ", Speed: " + speed + ", Coordinates: (" + x + ", " + y + ")");
    }

    // Getter và Setter nếu cần
    public int getInitHP(){
        return initHP;
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

    public void attack(Player player) {
        int damage = this.attackPoint - player.getDefense();
        if (damage > 0) {
            player.setHP(player.getHP() - damage);
            System.out.println(name + " has attacked " + player.getName() + " for " + damage + " damage!");
        } else {
            System.out.println(name + "'s attack was too weak to damage " + player.getName());
        }
    }

}