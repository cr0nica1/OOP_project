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
        // Cập nhật tọa độ dựa trên tốc độ và hướng di chuyển

        // In ra thông tin di chuyển và tọa độ mới của quái vật
        System.out.println(name + " moving at speed: " + speed + ", new coordinate: (" + x + ", " + y + ")");
    }
    private List<int[]> tracePath(Map<String,String> parentMap, int endX, int endY){
        return null;
    }
    public List<int[]> findpath(map m, Player player){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int rows=m.getGrid().length;
        int cols=m.getGrid()[0].length;
        int [][] dist=new int[cols][rows];
        for(int [] row:dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Map<String,String> parentMap=new HashMap<>();
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{x,y,0});
        dist[x][y]=0;
        parentMap.put(x+ ","+y, null);
        while (!q.isEmpty()) {
            int [] current=q.poll();
            int cur_x=current[0];
            int cur_y=current[1];
            if (m.getGrid()[cur_x][cur_y]==3) {
                return tracePath(parentMap,cur_x,cur_y);
            }
            for(int i=0;i<4;i++){
                int newX=cur_x+dx[i];
                int newY=cur_y+dy[i];
                // Add your logic here for processing newX and newY
            }
        }
        return null;
    }
    public void scan(map Map,Player player){
        if (takedamage()==true) {
            int [] dRow={-1,1,0,0};
            int [] dCol={0,0,-1,1};
            Queue<int[]>q=new LinkedList<>();
            boolean[][] visited= new boolean[Map.getGridWidth()][Map.getGridHeight()];
            q.add(new int[]{x,y});
            visited[x][y]=true;
            while (!q.isEmpty()) {
                int []current=q.poll();
                int row=current[0];
                int col=current[1];
                
                if (row<(Map.getGridHeight())&&col<(Map.getGridWidth())&&row<Map.getGridWidth()&&col<Map.getGridHeight()) {
                    if (Map.getGrid()[col][row]==3) {
                        int [] delta={1,-1};
                        for(int i=0;i<4;i++){
                            int r=y+dRow[i];
                            int c=x+dCol[i];
                            if (Map.getGrid()[c][r]==3) {
                                attack(player);
                            }
                        }
                    }else{
                        
                    }
                }
                for(int i =0;i<4;i++){
                    int newRow=row+dRow[i];
                    int newCol=col+dCol[i];
                    if (newCol>=0 &&newRow>=0&&newCol<Map.getGridWidth()&&newRow<Map.getGridHeight()) {                    
                    if (visited[newCol][newRow]==false&&row>=0&&row<Map.getGridHeight()&&col<Map.getGridWidth()&&col>=0) {
                        q.add(new int[]{newCol,newRow});
                        visited[newCol][newRow]=true;
    
                    }
                }
                }
            }
            
        }
    }
    // Phương thức tấn công
    public void attack(Player player) {
      
            int damage = attackPoint - player.getDefensePoint();
            if (damage > 0) {
                player.setHP(player.getHP()-damage);; // Giảm HP của người chơi
                System.out.println(name + " has attacked Player " + damage + " damage!");
            } 
            return;
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

}
