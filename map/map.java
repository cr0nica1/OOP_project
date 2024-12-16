import java.util.Arrays;

public class map {
    private int[][] grid; // Ma trận grid
    private monster[] monsters; // Mảng quái vật
    private int endpointX; // Tọa độ x của điểm kết thúc
    private int endpointY; // Tọa độ y của điểm kết thúc
    private map nextMap;

    // Constructor
    public map() {
        this.grid = new int[5][9];
        this.monsters = new monster[3];
        this.endpointX = 6;
        this.endpointY = 6;

        initializeGrid();
        spawnMonsters(); // Sinh quái vật ngay khi khởi tạo
    }

    // Khởi tạo grid với dữ liệu cụ thể
    private void initializeGrid() {
        for (int i = 0; i < grid.length; i++) {
            // 0 có thể đại diện cho ô trống
            Arrays.fill(grid[i], 0);
        }
        // Có thể thêm logic để đặt các vật thể khác trên grid
        grid[1][1] = 1;
        grid[2][3] = 1;
        grid[3][0] = 1;
        grid[0][4] = 1;
    }

    // Phương thức load map
    public void loadMap() {
        this.grid = nextMap.grid; // Tải grid từ bản đồ tiếp theo
        this.monsters = nextMap.monsters; // Tải quái vật từ bản đồ tiếp theo
        this.endpointX = nextMap.endpointX; // Cập nhật điểm kết thúc
        this.endpointY = nextMap.endpointY; // Cập nhật điểm kết thúc
    }

    // Phương thức sinh quái vật
    private void spawnMonsters() {
        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = new monster(); // Tạo quái vật mới
            // Đặt vị trí cho quái vật, có thể là random hoặc theo logic cụ thể
            int monsterX, monsterY;
            do {
                monsterX = (int) (Math.random() * grid.length);
                monsterY = (int) (Math.random() * grid[0].length);
            } while (grid[monsterX][monsterY] != 0); // Đảm bảo không đặt quái vật lên ô đã có
            monsters[i].setPosition(monsterX, monsterY); // Cập nhật vị trí quái vật
        }
        // Đặt vị trí cho quái vật dựa trên grid
        monsters[0].setPosition(0, 0); // Quái vật 1 tại (0, 0)
        monsters[1].setPosition(3, 2); // Quái vật 2 tại (3, 2)
        monsters[2].setPosition(4, 1); // Quái vật 3 tại (4, 1)
    }

    // Phương thức kiểm tra điểm kết thúc
    public boolean checkEndpoint(int x, int y) {


        if (x == endpointX && y == endpointY) {
            System.out.println("Đã đến điểm kết thúc tại (" + x + ", " + y + ")");
            return true;
        } else {
            return false;
        }
    }
    // Getter cho kích thước grid
    public int getGridWidth() {
        return grid.length;
    }

    public int getGridHeight() {
        return grid[0].length;
    }

    // Getter cho số lượng quái vật
    public int getMonstersCount() {
        return monsters.length;
    }

    public monster[] getMonsters() {
        return monsters;
    }

    public int getEndpointX() {
        return endpointX;
    }

    public int getEndpointY() {
        return endpointY;
    }

    // Phương thức hiển thị thông tin về bản đồ
    private void displayMapInfo(map gameMap) {
        System.out.println("Thông tin bản đồ:");
        System.out.println("Kích thước: " + gameMap.getGridWidth() + "x" + gameMap.getGridHeight());
        System.out.println("Điểm kết thúc: (" + gameMap.getEndpointX() + ", " + gameMap.getEndpointY() + ")");
        System.out.println("Số lượng quái vật: " + gameMap.getMonstersCount());

        // Hiển thị vị trí quái vật
        for (int i = 0; i < gameMap.getMonstersCount(); i++) {
            monster monster = gameMap.getMonsters()[i];
            System.out.println("Quái vật " + (i + 1) + " ở vị trí: (" + monster.getPositionX() + ", " + monster.getPositionY() + ")");
        }

        // Hiển thị trạng thái của grid
        System.out.println("Trạng thái grid:");
        for (int i = 0; i < gameMap.getGridHeight(); i++) {
            for (int j = 0; j < gameMap.getGridWidth(); j++) {
                System.out.print(gameMap.grid[j][i] + " "); // Hiển thị trạng thái ô
            }
            System.out.println(); // Xuống dòng sau mỗi hàng
        }

        // Thông tin về chướng ngại vật
        System.out.println("Thông tin chướng ngại vật: ");
        for (int i = 0; i < gameMap.getGridHeight(); i++) {
            for (int j = 0; j < gameMap.getGridWidth(); j++) {
                if (gameMap.grid[j][i] == 1) {
                    System.out.println("Chướng ngại vật tại: (" + j + ", " + i + ")");
                }
            }
        }
    }
}

// Lớp Monster
class monster {
    private int positionX; // Tọa độ X
    private int positionY; // Tọa độ Y

    public monster() {
        // Khởi tạo quái vật với các thuộc tính mặc định (có thể mở rộng thêm)


    }

    public void setPosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}
    // ......
