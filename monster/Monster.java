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
    public Monster(String name, int HP, int attackPoint, int defense, float speed, int x, int y,int initHP) {
        this.name = name;
        this.HP = HP;
        this.attackPoint = attackPoint;
        this.defense = defense;
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.initHP=initHP;

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
    public void move(map m,Player player) {
        List<int[]> path = findPath(m, player.getX(), player.getY());
        if (Math.abs( x - player.getX()) <= 1 && Math.abs(y - player.getY()) <= 1) {
            attack(player);
        }
        if (takedamage()) {
            System.out.println("Monster " + name + " has taken damage!");
            if (path != null) {
                int c=0;
                while (c<path.size()) {
                    
                    int[] next = path.get(c);
                    if (m.getGrid()[next[0]][next[1]] == 0) {
                        int oldx = x;
                        int oldy = y;
                        x = next[0];
                        y = next[1];
                        m.updatemonstermove(oldx, oldy, x, y);
                        break;
                       
                        
                    }
                    c++;
                };
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
        int damage = this.attackPoint - player.getDefensePoint();
        if (damage > 0) {
            player.setHP(player.getHP() - damage);
            System.out.println(name + " has attacked " + player.getName() + " for " + damage + " damage!");
            System.out.println(" HP: " + player.getHP());
        } else {
            System.out.println(name + "'s attack was too weak to damage " + player.getName());
        }
    }

}