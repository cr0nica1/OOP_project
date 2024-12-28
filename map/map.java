
import java.util.ArrayList;

import java.util.List;

public class map {
    private String name;
    private int[][] grid; // Ma trận grid
    private List<Monster> monsters; // Mảng quái vật
    private int endpointX; // Tọa độ x của điểm kết thúc
    private int endpointY; // Tọa độ y của điểm kết thúc
    private map nextMap;
    private map previousMap;



    // Hằng số cho giá trị quái vật
    //private static final int MONSTER_VALUE = 5; // Giá trị đại diện cho quái vật
    //private static final int PLAYER_VALUE = 3; // Giá trị đại diện cho người chơi
    //private static final int OBSTACLE_VALUE = 1; // Giá trị đại diện cho chướng ngại vật
    // Constructor với tham số
// Constructor với tham số int[][]


    public map(int[][] grid,int endpointX,int endpointY) {

        int[][] grid1=
                {
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
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
        map Map1=new map(grid1,10,10);
        int[][] grid2={
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 5, 0, 1, 0, 0, 1, 0},
                {0, 3, 5, 0, 0, 1, 0, 5, 1, 0},
                {0, 0, 1, 5, 0, 1, 0, 0, 9, 0},
                {5, 0, 5, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0, 0, 0, 0},
                {0, 5, 0, 0, 0, 0, 5, 0, 1, 0},
                {5, 0, 1, 5, 0, 5, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 5, 0, 1, 0},
                {0, 0, 1, 0, 0, 5, 0, 5, 0, 0}
        };
        map Map2=new map(grid2,10,10);
        int[][] grid3={
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 5, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 5, 1, 0, 0, 9, 0},
                {0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 5, 0, 1, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 0, 5, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 5, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 9}
        };
        map Map3=new map(grid3,10,10);
        Map1.setNextMap(Map2);
        Map2.setPreviousMap(Map1);
        Map2.setNextMap(Map3);
        Map3.setPreviousMap(Map2);
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
        displayGrid();
    }




    // Constructor với tham số
    // Constructor với tham số
    public map(int rows, int cols, int endpointX, int endpointY, int monsterCount) {
        this.grid = new int[rows][cols];
        this.monsters = new ArrayList<>();
        this.endpointX = endpointX;
        this.endpointY = endpointY;

        // Thêm code để khởi tạo player position
        grid[0][0] = 3; // Player starts at (0,0)

        // Thêm code để khởi tạo monsters ngẫu nhiên
        int monstersPlaced = 0;
        while (monstersPlaced < monsterCount) {
            int randomX = (int)(Math.random() * rows);
            int randomY = (int)(Math.random() * cols);

            // Chỉ đặt monster nếu ô trống (giá trị = 0)
            if (grid[randomX][randomY] == 0) {
                grid[randomX][randomY] = 5;  // 5 là giá trị đại diện cho monster
                monsters.add(new Monster("Monster", 100, 10, 5, 1.0f, randomX, randomY));
                monstersPlaced++;
            }
        }

        // Hiển thị map ban đầu
        displayGrid();
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
            }
        }
    }
    //cap nhat xem nguoi choi dang o dau
    // Kiểm tra tường bị chặn trước khi cập nhật vị trí người chơi
    public void updatePlayerPosition(int oldX, int oldY, int newX, int newY) {
        if (grid[newX][newY] != 1) { // Kiểm tra ô mới không phải là tường (giá trị 1 đại diện cho tường)
            grid[oldX][oldY] = 0; // Xóa vị trí cũ
            grid[newX][newY] = 3; // Đặt vị trí mới
            displayGrid(); // Hiển thị lưới đã cập nhật
        } else {
            System.out.println("Cannot move to the position (" + newX + ", " + newY + ") because it is blocked.");
        }
    }
    // Phương thức thiết lập bản đồ trước đó
// Phương thức quay lại bản đồ trước đó
    public void setPreviousMapPosition(int x, int y) { grid[x][y] = 7; }
    public boolean checkpreviousMap(Player player) {
        if (grid[player.getX()][player.getY()] == 7) {
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
        return false;
    }

    // Phương thức quay lại bản đồ trước đó
    // Phương thức load map
    public map loadMap(Player player) {

        if (checkEndpoint(player)==true) {
            player.setX(0);
            player.setY(0);
            return nextMap;
        }
        if (checkpreviousMap(player)==true) {
            player.setX(previousMap.getGridHeight()-2);
            player.setY(previousMap.getGridWidth()-2);
            return previousMap;

        }
        return null;

    }


    //cap nhat tinh trang quai vat
    public void updateMonsters() {
        for (Monster monster : monsters) {
            if (monster.getHP() <= 0) {
                grid[monster.getX()][monster.getY()] = 0; // Cập nhật ô thành 0
                System.out.println("Monster " + monster.getName() + " has been removed from the map.");
                displayGrid();
            }
        }
        monsters.removeIf(monster -> monster.getHP() <= 0); // Loại bỏ quái vật đã chết khỏi danh sách
    }

    // Phương thức kiểm tra điểm kết thúc
    public boolean checkEndpoint(Player player) {
        if (player.getX()==endpointX&&player.getY()==endpointY) {
            if (nextMap!=null) {
                System.out.println("\n" +
                        "Loading map"+nextMap.getName());
                return true;

            }else{
                System.out.println("There are no more maps.");
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
    // Getter và setter cho nextMap
    public void setNextMap(map nextMap) {
        this.nextMap = nextMap;
    }

    public map getNextMap() {
        return this.nextMap;
    }

    public void setPreviousMap(map previousMap) {
        this.previousMap = previousMap;
    }
}
