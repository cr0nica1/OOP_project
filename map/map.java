import java.util.ArrayList;

import java.util.List;

public class map {
    private String name;
    private int[][] grid; // Ma trận grid
    private List<Monster> monsters; // Mảng quái vật
    private int endpointX; // Tọa độ x của điểm kết thúc
    private int endpointY; // Tọa độ y của điểm kết thúc
    private map nextMap;
    private map previousMap; // Bản đồ trước đó
    // Hằng số cho giá trị quái vật
    //private static final int MONSTER_VALUE = 5; // Giá trị đại diện cho quái vật
    //private static final int PLAYER_VALUE = 3; // Giá trị đại diện cho người chơi
    //private static final int OBSTACLE_VALUE = 1; // Giá trị đại diện cho chướng ngại vật

    // Constructor mặc định
    public map() {

    this.grid = new int[][] {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 5, 0, 1, 0, 0, 0, 0},
        {0, 0, 5, 0, 0, 1, 0, 5, 0, 0},
        {0, 0, 1, 5, 0, 1, 0, 0, 9, 0},
        {0, 0, 5, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 1, 1, 5, 1, 0, 1, 0, 0},
        {0, 5, 0, 0, 0, 0, 5, 1, 0, 0},
        {0, 0, 1, 5, 0, 5, 0, 1, 0, 0},
        {0, 0, 1, 0, 0, 0, 5, 0, 0, 0},
        {0, 0, 1, 0, 0, 5, 0, 0, 0, 0}
    };
    this.endpointX=grid.length;
    this.endpointY=grid[0].length;
    this.monsters = new ArrayList<>();

    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
            if (grid[i][j] == 5) {
                monsters.add(new Monster("Monster", 100, 10, 5, 1.0f, i, j));
            }
        }
    }
  
    }

    // Constructor với tham số
    public map(int rows, int cols, int endpointX, int endpointY, int monsterCount) {
        this.grid = new int[rows][cols];
        this.monsters = new ArrayList<>();
        this.endpointX = endpointX;
        this.endpointY = endpointY;


    }
    // Khởi tạo grid với dữ liệu cụ thể
    public void remove_monster(){
        int x;
        int y;
        String name; int HP;int attackPoint;int defense; float speed;
        for(Monster monster:monsters){
            if (monster.die()) {
                name=monster.getName();
                HP=monster.getHP();
                attackPoint=monster.getAttackPoint();
                defense=monster.getDefense();
                speed=monster.getSpeed();
                monster=null;

                // bộ đếm thời gian

                
            }
        }
    }
    public void respawn( String name, int HP,int attackPoint,int defense, float speed ,int x, int y){
        Monster monster=new Monster(name,HP,attackPoint,defense,speed ,x,y);
        monsters.add(monster);
    }
    public void updatePlayerPosition(int oldX, int oldY, int newX, int newY) {
        grid[oldX][oldY] = 0; // Clear old position
        grid[newX][newY] = 3; // Set new position
        displayGrid(); // Display the updated grid
    }
    // Phương thức thiết lập bản đồ trước đó
    public void setPreviousMap(map previousMap) {
        this.previousMap = previousMap;
    }

    // Phương thức quay lại bản đồ trước đó
    // Phương thức load map
    public map loadMap(Player player) {
        if (check_previousMap(player)==true) {
            player.setX(previousMap.endpointX-1);
            player.setY(previousMap.endpointY-1);
            return previousMap;
            
        }
        if (checkEndpoint(player)==true) {
            player.setX(0);
            player.setY(0);
            return nextMap;
        }
        return null;
        
    }

    public boolean check_previousMap(Player player){
        if ((player.getX() == 0 && player.getY() == -1) || (player.getX() == -1 && player.getY() == 0)) {
            if (previousMap != null) {
                System.out.println("Quay lại bản đồ trước đó...");
                return true; // Trả về bản đồ trước đó
            } else {
                System.out.println("Không có bản đồ trước đó để quay lại.");
                return false;
            }
        }
        return false;
    }


// Phương thức kiểm tra điểm kết thúc
    public boolean checkEndpoint(Player player) {
        if (player.getX()==endpointX&&player.getY()==endpointY) {
            if (nextMap!=null) {
                System.out.println("Đang tải bản đồ"+nextMap.getName());
                return true;

            }else{
                System.out.println("không còn bản đồ.");
                return false;
            }
        }
        return false;

    
    }
// Getter cho kích thước grid
    public int [][] getGrid(){
        return grid;
    }
    public int getGridWidth() {
        return grid.length;
    }

    public int getGridHeight() {
        return grid[0].length;
    }
  

    // Getter cho số lượng quái vật
    public int getMonstersCount() {
        return this.monsters.size();
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public int getEndpointX() {
        return endpointX;
    }

    public int getEndpointY() {
        return endpointY;
    }
    public String getName(){
        return name;
    }

    // Phương thức hiển thị thông tin về bản đồ
    public void displayMapInfo() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Map Information:");
        System.out.println("Size: " + getGridWidth() + "x" + getGridHeight());
        System.out.println("Endpoint: (" + getEndpointX() + ", " + getEndpointY() + ")");
        System.out.println("Number of Monsters: " + getMonstersCount());

        // Hiển thị vị trí quái vật
        for (int i = 0; i < getMonstersCount(); i++) {

        }

        // Hiển thị trạng thái của grid
        System.out.println("Grid Status:");
        for (int i = 0; i < getGridHeight(); i++) {
            System.out.print("{ ");
            for (int j = 0; j < getGridWidth(); j++) {
                System.out.print(grid[j][i] + " ");
            }
            System.out.println("}");
        }

        
        System.out.println("--------------------------------------------------------------------------");
    }
    public void displayGrid() {
        System.out.println("Current Grid State:");
        for (int i = 0; i < grid.length; i++) {
            System.out.print("{ ");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("}");
        }
        System.out.println("--------------------------------");
    }

}
