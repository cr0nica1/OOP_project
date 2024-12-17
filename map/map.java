import java.util.Arrays;

public class map {
    private int[][] grid; // Ma trận grid
    private Monster[] monsters; // Mảng quái vật
    private int endpointX; // Tọa độ x của điểm kết thúc
    private int endpointY; // Tọa độ y của điểm kết thúc

    private map previousmap;
    private map nextMap;

    // Constructor
    public map() {
        this.grid = new int[5][9];
        this.monsters = new Monster[3];
        this.endpointX = 6;
        this.endpointY = 6;

        initializeGrid();
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
    public map loadMap() {
        return this.nextMap;
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
        return this.monsters.length;
    }

    public Monster[] getMonsters() {
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

