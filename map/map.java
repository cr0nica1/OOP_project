
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
    private int backmapX;
    private int backmapY;
    // Constructor mặc định
    public map(String name, int[][] grid,int endpointX,int endpointY, int backmapX, int backmapY) {
        this.name=name;
        this.grid = grid;
        this.endpointX = endpointX;
        this.endpointY = endpointY;
        this.monsters = new ArrayList<>();
        this.backmapX=backmapX;
        this.backmapY=backmapY;


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 5) {
                    monsters.add(new Monster("Monster", 100, 10, 5, 1.0f, i, j));
                }
            }
        }

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

    public boolean checkpreviousMap(Player player) {
        if (player.getX()==backmapX&&player.getY()==backmapY) {
            if (previousMap!=null) {



                System.out.println("Loading previous map"+previousMap.getName());
                return true;
            }
            else{
                System.out.println("No previous map");
                return false;
            }
        }
        return false;
    }
    //cap nhat tinh trang quai vat
    // Cập nhật phương thức updateMonsters trong lớp map
    public void updateMonsters() {
        for (Monster monster : monsters) {
            if (monster.getHP() <= 0) {
                grid[monster.getX()][monster.getY()] = 0; // Đặt ô tương ứng thành 0
                System.out.println("Monster " + monster.getName() + " has been removed from the map at position ("
                        + monster.getX() + ", " + monster.getY() + ").");
            }
        }
        monsters.removeIf(monster -> monster.getHP() <= 0); // Loại bỏ quái vật đã chết khỏi danh sách
        displayGrid(); // Hiển thị trạng thái bản đồ sau khi cập nhật
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
    public map getPreviousMap() {
        return this.previousMap;
    }
    public int getBackmapX() {
        return backmapX;
    }
    public int getBackmapY() {
        return backmapY;
    }
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

}